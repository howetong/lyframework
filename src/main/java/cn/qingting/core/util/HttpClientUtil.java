package cn.qingting.core.util;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;

import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;


/**
 * Http请求工具类
 * Created by Administator on 2017/5/8.
 */
@Component
public class HttpClientUtil {

    private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    @Value("${ly.connectionTimeout}")
    private int connectionTimeout;

    @Value("${ly.socketTimeout}")
    private int socketTimeout;

    @Value("${ly.keyStore}")
    private String keyStore;

    @Value("${ly.keyPass}")
    private String keyPass;

    private static RequestConfig requestConfig = null;

    //连接池
    private static PoolingHttpClientConnectionManager poolConnManager = null;

    //这里想将连接池作为全局变量使用，但是涉及到注入的变量值，导致不能通过static块来初始化。
    @PostConstruct
    public void init() {
        //设置requestConfig
        requestConfig = RequestConfig.custom().setConnectTimeout(connectionTimeout)
                .setConnectionRequestTimeout(10000).setSocketTimeout(socketTimeout).build();
        /*设置通过证书访问https服务的连接池，该连接池只能sendDataWithCert方法使用*/
        if (keyStore == null || StringUtils.isBlank(keyStore)){
            logger.warn("证书路径不存在！");
            return;
        }
        SSLContext sslContext = createCertSSL(keyStore, keyPass);
        //设置连接工厂
        SSLConnectionSocketFactory sslFactory = new SSLConnectionSocketFactory(sslContext);
        // 设置协议http和https对应的处理socket链接工厂的对象
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", sslFactory)
                .build();
        poolConnManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        // 将最大连接数增加到200
        poolConnManager.setMaxTotal(200);
        // 将每个路由基础的连接增加到30
        poolConnManager.setDefaultMaxPerRoute(30);
    }

    /**
     * 发送post请求
     *
     * @param url 请求路径
     * @param str 请求参数字符串
     * @return 请求响应结果字符串
     */
    public static String sendData(String url, String str) {
        SSLConnectionSocketFactory sslFactory = SSLConnectionSocketFactory.getSocketFactory();
        //创建httpClient对象
        CloseableHttpClient client = HttpClients.custom().setSSLSocketFactory(sslFactory).build();

        //创建post方式请求对象
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        //设置参数到请求对象中
        StringEntity entity = new StringEntity(str, "utf-8");
        httpPost.setEntity(entity);
        //设置header信息
        //指定报文头【Content-type】、【User-Agent】
        httpPost.setHeader("Content-type", "application/json");
        httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        return executeHttpPost(httpPost, client);
    }

    /**
     * 信任自定义证书
     *
     * @param url   请求url
     * @param param 请求参数
     * @return 返回请求结果字符串
     */
    public static String sendDataWithCert(String url, String param) {
        if (poolConnManager == null){
            logger.warn("【工具方法日志】http连接池初始化失败！");
        }
        CloseableHttpClient client = HttpClients.custom()
                .setConnectionManager(poolConnManager)
                .setDefaultRequestConfig(requestConfig).build();

        //创建post方式请求对象
        HttpPost httpPost = new HttpPost(url);
        //设置连接超时时间
        //httpPost.setConfig(requestConfig);
        //设置参数到请求对象中
        StringEntity entity = new StringEntity(param, "utf-8");
        httpPost.setEntity(entity);
        //设置header信息
        //指定报文头【Content-type】、【User-Agent】
        httpPost.setHeader("Content-type", "application/json");
        httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        return executeHttpPost(httpPost, client);
    }

    /**
     * 信任所有证书,绕过验证
     *
     * @param url   请求url
     * @param param 请求参数
     * @return String　返回请求结果
     */
    public static String sendDataWithAllCerts(String url, String param) {
        try {
            //信任所有证书
            SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, (TrustStrategy) (chain, authType) -> true).build();
            //设置连接工厂
            SSLConnectionSocketFactory sslFactory = new SSLConnectionSocketFactory(sslContext, new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.2"}, null, NoopHostnameVerifier.INSTANCE);
            //创建httpClient对象
            CloseableHttpClient client = HttpClients.custom().setSSLSocketFactory(sslFactory)
                    .setDefaultRequestConfig(requestConfig)
                    .build();

            //创建post方式请求对象
            HttpPost httpPost = new HttpPost(url);
            //httpPost.setConfig(requestConfig);
            //设置参数到请求对象中
            StringEntity entity = new StringEntity(param, "utf-8");
            httpPost.setEntity(entity);
            //设置header信息
            //指定报文头【Content-type】、【User-Agent】
            httpPost.setHeader("Content-type", "application/json");
            httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            return executeHttpPost(httpPost, client);
        } catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException e) {
            logger.info("【工具方法日志】https请求出现异常,{}", e.getMessage());
            return null;
        }
    }

    /**
     * 执行post请求并返回影响结果字符串
     *
     * @param httpPost post请求
     * @param client   httpclient客户端
     * @return 响应字符串
     */
    private static String executeHttpPost(HttpPost httpPost, CloseableHttpClient client) {
        CloseableHttpResponse response = null;
        try {
            //执行请求操作，并拿到结果（同步阻塞）
            response = client.execute(httpPost);
            HttpEntity respEntity = response.getEntity();
            if (respEntity != null) {
                return EntityUtils.toString(respEntity);
            }
        } catch (IOException e) {
            //调用异常，timeOut或者协议错误
            logger.error("【工具方法日志】  http请求异常！,{}", e.getMessage());
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                logger.warn("【工具方法日志】  response关闭异常！,{}", e.getMessage());
            }
        }
        return null;
    }

    /**
     * 返回通过证书验证的SSLContext
     *
     * @param keyStorePath 密钥库路径
     * @param keyStorePass 密钥库密码
     * @return SSLContext
     */
    private static SSLContext createCertSSL(String keyStorePath, String keyStorePass) {
        SSLContext sc = null;
        FileInputStream instream = null;
        KeyStore trustStore;
        try {
            trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            instream = new FileInputStream(new File(keyStorePath));
            trustStore.load(instream, keyStorePass.toCharArray());
            // 相信自己的CA和所有自签名的证书
            sc = SSLContexts.custom().loadTrustMaterial(trustStore, new TrustSelfSignedStrategy()).build();
        } catch (KeyStoreException | NoSuchAlgorithmException | CertificateException | IOException | KeyManagementException e) {
            logger.error("【工具方法日志】 生成SSL上下文异常,原因是：", e.getMessage());
        } finally {
            try {
                if (instream != null)
                    instream.close();
            } catch (IOException e) {
                logger.warn("【工具方法日志】 资源关闭异常", e.getMessage());
            }
        }
        return sc;
    }
}