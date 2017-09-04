package cn.core.test.controller;
import cn.core.interceptor.validation.BeanValid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by howeTong on 2017/6/20 0020.
 */
@Controller
@RequestMapping(value="admin")
public class TestController {
    @RequestMapping(value="/test")
    @ResponseBody
    @BeanValid
    public String test(){
        return "666";
    }
}