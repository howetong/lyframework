package cn.qingting.core.converter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import cn.qingting.core.util.LoggerUtils;
import cn.qingting.core.util.RequestUtils;
import cn.qingting.core.util.encrypt.RSAUtils;
import cn.qingting.core.util.jsonXml.FastJSONHelper;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * 功能:类主要功能 - <br>
 * 作者: Administrator <br>
 * 时间:2016年11月16日 上午8:56:39 <br>
 * extends <br>
 * ::
 */

public class MyFastJsonHttpMessageConverter extends FastJsonHttpMessageConverter {
	private Charset charset = UTF8;
	private SerializerFeature[] features = new SerializerFeature[0];

	@Resource
	protected HttpServletRequest request;

	@Override
	protected Object readInternal(Class<? extends Object> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		InputStream in = inputMessage.getBody();

		byte[] buf = new byte[1024];
		for (;;) {
			int len = in.read(buf);
			if (len == -1) {
				break;
			}

			if (len > 0) {
				baos.write(buf, 0, len);
			}
		}

		byte[] bytes = baos.toByteArray();
		String data = new String(bytes,"UTF-8");
		LoggerUtils.info(getClass(), "数据请求:...." + data);

		if (request != null) {
			String privateKey = (String) RequestUtils.getSession(RSAUtils.SESSION_PRIVATE_KEY);
			String publicKey = (String) RequestUtils.getSession(RSAUtils.SESSION_PUBLIC_KEY);
			LoggerUtils.info(getClass(), "privateKey:" + privateKey);
			LoggerUtils.info(getClass(), "publicKey:" + publicKey);
			@SuppressWarnings("unchecked")
			Map<String, Object> map = FastJSONHelper.deserialize(data, HashMap.class);
			LoggerUtils.info(getClass(), "map:" + map);
			
			if (map != null && map.size() > 0 && map.get("data") != null) {
				try {
					byte[] dataBytes = map.get("data").toString().getBytes();
					byte[] decodedData = RSAUtils.decryptByPrivateKey(dataBytes, privateKey);
					String target = new String(decodedData);
					System.out.println("解密后文字: \r\n" + target);

					String sign = RSAUtils.sign(dataBytes, privateKey);
					System.err.println("签名:\r" + sign);
					boolean status;
					status = RSAUtils.verify(dataBytes, publicKey, sign);
					System.err.println("验证结果:\r" + status);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return JSON.parseObject(bytes, 0, bytes.length, charset.newDecoder(), clazz);
	}

	@Override
	protected void writeInternal(Object obj, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		HttpHeaders headers = outputMessage.getHeaders();
		String text = JSON.toJSONString(obj, //
				SerializeConfig.globalInstance, //
				serialzeFilters, //
				dateFormat, //
				JSON.DEFAULT_GENERATE_FEATURE, //
				features);
		LoggerUtils.info(getClass(), "数据输出:...." + text);
		byte[] bytes = text.getBytes();
		headers.setContentLength(bytes.length);
		OutputStream out = outputMessage.getBody();
		out.write(bytes);
	}

	public SerializerFeature[] getFeatures() {
		return features;
	}

	public void setFeatures(SerializerFeature...features) {
		this.features = features;
	}

}
