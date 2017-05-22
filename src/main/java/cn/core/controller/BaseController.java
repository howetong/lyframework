package cn.core.controller;

import cn.core.utils.jsonXml.FastJSONHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 基本控制器
 */
@Controller
@RequestMapping(value="admin")
public class BaseController {

    protected<T> void writeJSON(HttpServletResponse response, T obj) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String json = FastJSONHelper.serialize(obj);
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
        out.close();
    }

    @RequestMapping(value="/test")
    @ResponseBody
    public Map<String, String> index(){
        Map<String,String> map = new HashMap<String, String>();
        map.put("name","tonghao");
        map.put("sex","nan1");
        return map;
    }
}

