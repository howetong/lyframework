package cn.qingting.core.util;

import cn.qingting.core.util.encrypt.RSAUtils;
import cn.qingting.core.util.jsonXml.JSONValidator;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;
import java.util.Map.Entry;

import static cn.qingting.core.util.Constants.POST;
import static cn.qingting.core.util.Constants.UTF8;


/**
 * 
 * 功能:类主要功能 - HttpServletRequest帮助类<br>
 * 作者: Administrator <br>
 * 时间:2015年10月21日 下午2:41:24 <br>
 * <br>
 */
public class RequestUtils {
	private static final Logger log = LoggerFactory.getLogger(RequestUtils.class);

	private RequestUtils() {
	}

	/**
	 * 获取请求
	 * 
	 * @return HttpServletRequest
	 */
	public static HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	/**
	 * 获取客户端系统版本
	 * 
	 * @return String
	 */
	public static String getUserAgent() {
		return getRequest().getHeader("User-Agent");
	}

	/**
	 * 获取客户端IP
	 * 
	 * @return String
	 */
	public static String getUserIP() {
		return getIpAddr(getRequest());
	}

	/**
	 * 获取客户端主机名
	 * 
	 * @return String
	 */
	public static String getUserHost() {
		return getRequest().getRemoteHost();
	}

	/**
	 * 获取客户端端口
	 * 
	 * @return int
	 */
	public static int getUserPort() {
		return getRequest().getRemotePort();
	}

	/**
	 * 获取客户端用户
	 * 
	 * @return String
	 */
	public static String getUser() {
		return getRequest().getRemoteUser();
	}

	/**
	 * 获取服务器IP
	 * 
	 * @return String
	 */
	public static String getLocalIP() {
		return getRequest().getLocalAddr();
	}

	/**
	 * 获取服务器端口
	 * 
	 * @return int
	 */
	public static int getLocalPort() {
		return getRequest().getLocalPort();
	}

	/**
	 * 得到session中的对象
	 * 
	 * @param key
	 * @return Object
	 */
	public static Object getSession(String key) {
		if (getRequest() == null) {
			return null;
		}
		return getRequest().getSession().getAttribute(key);
	}
	public static Object getSession(HttpServletRequest request,String key) {
		if (request == null) {
			return null;
		}
		return request.getSession().getAttribute(key);
	}
	/**
	 * 添加对象到session
	 * 
	 * @param key
	 * @param obj
	 */
	public static <T> void putSession(String key, T obj) {
		getRequest().getSession().setAttribute(key, obj);
	}

	/**
	 * 添加对象到session
	 * 
	 * @param request
	 * @param key
	 * @param obj
	 */
	public static <T> void putSession(HttpServletRequest request, String key, T obj) {
		request.getSession().setAttribute(key, obj);
	}

	/**
	 * 删除session中的对象
	 * 
	 * @param key
	 */
	public static void removeSession(String key) {
		getRequest().getSession().removeAttribute(key);
	}

	/**
	 * 删除session中的对象
	 * 
	 * @param request
	 * @param key
	 */
	public static void removeSession(HttpServletRequest request, String key) {
		request.getSession().removeAttribute(key);
	}

	/**
	 * 获取QueryString的参数，并使用URLDecoder以UTF-8格式转码。如果请求是以post方法提交的，
	 * 那么将通过HttpServletRequest#getParameter获取。
	 * 
	 * @param request
	 *            web请求
	 * @param name
	 *            参数名称
	 * @return String
	 */
	public static String getQueryParam(HttpServletRequest request, String name) {
		if (StringUtils.isBlank(name)) {
			return null;
		}
		if (request.getMethod().equalsIgnoreCase(POST)) {
			return request.getParameter(name);
		}
		String s = request.getQueryString();
		if (StringUtils.isBlank(s)) {
			return null;
		}
		try {
			s = URLDecoder.decode(s, UTF8);
		} catch (UnsupportedEncodingException e) {
			log.error("encoding " + UTF8 + " not support?", e);
		}
		String[] values = parseQueryString(s).get(name);
		if (values != null && values.length > 0) {
			return values[values.length - 1];
		} else {
			return null;
		}
	}

	/**
	 * 获取请求参数
	 * 
	 * @param request
	 * @return Map<String, Object>
	 */
	public static Map<String, Object> getQueryParams(HttpServletRequest request) {
		Map<String, String[]> map;
		if (request.getMethod().equalsIgnoreCase(POST)) {
			map = request.getParameterMap();
		} else {
			String s = request.getQueryString();
			if (StringUtils.isBlank(s)) {
				return new HashMap<String, Object>();
			}
			try {
				s = URLDecoder.decode(s, UTF8);
			} catch (UnsupportedEncodingException e) {
				log.error("encoding " + UTF8 + " not support?", e);
			}
			map = parseQueryString(s);
		}

		Map<String, Object> params = new HashMap<String, Object>(map.size());
		int len;
		for (Entry<String, String[]> entry : map.entrySet()) {
			len = entry.getValue().length;
			if (len == 1) {
				params.put(entry.getKey(), entry.getValue()[0]);
			} else if (len > 1) {
				params.put(entry.getKey(), entry.getValue());
			}
		}
		return params;
	}

	/**
	 * 解析URL?后的请求参数
	 * 
	 * @param s
	 * @return Map<String, String[]>
	 */
	public static Map<String, String[]> parseQueryString(String s) {
		String valArray[] = null;
		if (s == null) {
			throw new IllegalArgumentException();
		}
		Map<String, String[]> ht = new HashMap<String, String[]>();
		StringTokenizer st = new StringTokenizer(s, "&");
		while (st.hasMoreTokens()) {
			String pair = (String) st.nextToken();
			int pos = pair.indexOf('=');
			if (pos == -1) {
				continue;
			}
			String key = pair.substring(0, pos);
			String val = pair.substring(pos + 1, pair.length());
			if (ht.containsKey(key)) {
				String oldVals[] = (String[]) ht.get(key);
				valArray = new String[oldVals.length + 1];
				for (int i = 0; i < oldVals.length; i++) {
					valArray[i] = oldVals[i];
				}
				valArray[oldVals.length] = val;
			} else {
				valArray = new String[1];
				valArray[0] = val;
			}
			ht.put(key, valArray);
		}
		return ht;
	}

	/**
	 * 获取请求参数
	 * 
	 * @param request
	 * @param prefix
	 * @return Map<String, String>
	 */
	public static Map<String, String> getRequestMap(HttpServletRequest request, String prefix) {
		return getRequestMap(request, prefix, false);
	}

	/**
	 * 从参数map中按前缀获取
	 * 
	 * @param request
	 * @param prefix
	 * @return Map<String, String>
	 */
	public static Map<String, String> getRequestMapWithPrefix(HttpServletRequest request, String prefix) {
		return getRequestMap(request, prefix, true);
	}

	/**
	 * 从参数map中按前缀获取,nameWithPrefix为false则切割值与前缀相同部分
	 * 
	 * @param request
	 * @param prefix
	 * @param nameWithPrefix
	 * @return Map<String, String>
	 */
	private static Map<String, String> getRequestMap(HttpServletRequest request, String prefix,
			boolean nameWithPrefix) {
		Map<String, String> map = new HashMap<String, String>();
		Enumeration<String> names = request.getParameterNames();
		String name, key, value;
		while (names.hasMoreElements()) {
			name = names.nextElement();
			if (name.startsWith(prefix)) {
				key = nameWithPrefix ? name : name.substring(prefix.length());
				value = StringUtils.join(request.getParameterValues(name), ',');
				map.put(key, value);
			}
		}
		return map;
	}

	/**
	 * 获取访问者IP
	 * 
	 * 在一般情况下使用Request.getRemoteAddr()即可，但是经过nginx等反向代理软件后，这个方法会失效。
	 * 
	 * 本方法先从Header中获取X-Real-IP，如果不存在再从X-Forwarded-For获得第一个IP(用,分割)，
	 * 如果还不存在则调用Request .getRemoteAddr()。
	 * 
	 * @return String
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("X-Real-IP");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			return ip;
		}
		ip = request.getHeader("X-Forwarded-For");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			// 多次反向代理后会有多个IP值，第一个为真实IP。
			int index = ip.indexOf(',');
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		} else {
			return request.getRemoteAddr();
		}
	}

	/**
	 * 获得当的访问路径
	 * 
	 * HttpServletRequest.getRequestURL+"?"+HttpServletRequest.getQueryString
	 * 
	 * @return String
	 */
	public static String getCurrentUrl() {
		return getCurrentUrl(getRequest());

	}

	/**
	 * 获得当的访问路径
	 * 
	 * HttpServletRequest.getRequestURL+"?"+HttpServletRequest.getQueryString
	 * 
	 * @return String
	 */
	public static String getCurrentUrl(HttpServletRequest request) {
		UrlPathHelper helper = new UrlPathHelper();
		StringBuffer buff = request.getRequestURL();
		String uri = request.getRequestURI();
		String origUri = helper.getOriginatingRequestUri(request);
		buff.replace(buff.length() - uri.length(), buff.length(), origUri);
		String queryString = helper.getOriginatingQueryString(request);
		if (queryString != null) {
			buff.append("?").append(queryString);
		}
		return buff.toString();
	}

	/**
	 * 获得请求的session id，但是HttpServletRequest#getRequestedSessionId()方法有一些问题。
	 * 当存在部署路径的时候，会获取到根路径下的jsessionid。
	 * 
	 * @see HttpServletRequest#getRequestedSessionId()
	 * 
	 * @param request
	 * @return String
	 */
	public static String getRequestedSessionId(HttpServletRequest request) {
		String sid = request.getRequestedSessionId();
		String ctx = request.getContextPath();
		// 如果session id是从url中获取，或者部署路径为空，那么是在正确的。
		if (request.isRequestedSessionIdFromURL() || StringUtils.isBlank(ctx)) {
			return sid;
		} else {
			// 手动从cookie获取
			Cookie cookie = CookieUtils.getCookie(request, Constants.JSESSION_COOKIE);
			if (cookie != null) {
				return cookie.getValue();
			} else {
				return request.getSession().getId();
			}
		}
	}

	/**
	 * 获取请求参数转为map
	 * 
	 * @return Map<String, Object>
	 */
	@SuppressWarnings("rawtypes")
	public static Map<String, Object> getParameterMap(HttpServletRequest request) {
		Map<String, String[]> properties = request.getParameterMap();
		Iterator<Entry<String, String[]>> entries = properties.entrySet().iterator();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Entry entry;
		String name = "";
		String value = "";
		while (entries.hasNext()) {
			entry = (Entry) entries.next();
			name = (String) entry.getKey();
			Object valueObj = entry.getValue();
			if (null == valueObj) {
				value = "";
			} else if (valueObj instanceof String[]) {
				String[] values = (String[]) valueObj;
				for (int i = 0; i < values.length; i++) {
					value = values[i] + ",";
				}
				value = value.substring(0, value.length() - 1);
			} else {
				value = valueObj.toString();
			}
			returnMap.put(name, value);
		}
		return returnMap;
	}

	public static Map<String, Object> getParameterAllMap(HttpServletRequest request){
		Map<String, String[]> parameterMap = request.getParameterMap();
		Map<String, Object> map =  new HashMap<String, Object>();
		for (String name : parameterMap.keySet()) {
			String[] value = parameterMap.get(name);
			if (value.length == 1) {
				map.put(name, value[0]);
			} else if (value.length == 0) {
				map.put(name, null);
			} else {
				map.put(name, value);
			}
		}
		return map;
	}

	public static Map<String, Object> getParameterAllRSAMap(HttpServletRequest request) throws Exception{
		String privateKey = (String) RequestUtils.getSession(request,RSAUtils.SESSION_PRIVATE_KEY);
		String publicKey = (String) RequestUtils.getSession(request, RSAUtils.SESSION_PUBLIC_KEY);
		Map<String, String[]> parameterMap = request.getParameterMap();
		Map<String, Object> hashMap = new HashMap<String, Object>();
		for (String name : parameterMap.keySet()) {
			String info = StringUtil.asString(parameterMap.get(name));
			String[] value = parameterMap.get(name);
			if (value.length == 1) {
				info = StringUtil.asString(value[0]);
			}
			if (StringUtils.isBlank(info))
				break;
			byte[] dataBytes = info.getBytes();
			LoggerUtils.info(RequestUtils.class, "privateKey:"+privateKey);
			LoggerUtils.info(RequestUtils.class, "info:"+info);
			// 进行签名验证
			String sign = RSAUtils.sign(dataBytes, privateKey);
			boolean status = RSAUtils.verify(dataBytes, publicKey, sign);
			if (status) {
				// 解密后文字
				byte[] decodedData = RSAUtils.decryptByPrivateKey(dataBytes, privateKey);
				String target = new String(decodedData);
				if (new JSONValidator().validate(target)) {
					JSONObject json = JSONObject.parseObject(target);
					hashMap.putAll(json);
				} else
					hashMap.put(name, target);
			} else {
				hashMap.put(name, value);
			}
		}
		return hashMap;
	}
}
