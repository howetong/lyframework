package cn.core.controller;

import cn.core.utils.jsonXml.FastJSONHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.MappedSuperclass;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 基本控制器
 */
@MappedSuperclass
public class BaseController {

    /**
     * JSP页面模板主文件路径
     * @return
     */
    private String templateDirectoryView = "default";

    protected String getTemplateDirectoryView(){
        return templateDirectoryView;
    }

}

