
import cn.core.utils.HttpClientUtil;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by howeTong on 2017/5/14 0014.
 */
public class HttpClientTest {

    String url = "https://tonghao.cn:8443/lyframework/admin/test";

    @Test
    public void invokeHttps(){
        Map map = new HashMap<String,String>();
        map.put("name","liuyu");
        map.put("sex","nv");
        String paramsStr  = JSON.toJSONString(map);
        String str = HttpClientUtil.sendDataWithCert(url,paramsStr,"utf-8","D:/keys/tomcat.keystore","changeit");
        System.out.println("返回结果为："+str);
    }


}
