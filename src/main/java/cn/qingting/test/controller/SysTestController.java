package cn.qingting.test.controller;
import cn.qingting.core.annotation.AInitMenu;
import cn.qingting.core.controller.BaseController;
import cn.qingting.core.interceptor.validation.BeanValid;
import cn.qingting.security.domain.SysMenu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by howeTong on 2017/6/20 0020.
 */
@Controller
@RequestMapping(value="admin/test")
@AInitMenu(name="连接测试",parent="开发工具",type=1, path="/admin/test")
public class SysTestController extends BaseController<SysMenu>{

    /**
     * 设置系统管理模块路径
     */
    @Override
    protected void beforeInitBinder(WebDataBinder binder) {
        super.setModuleDirectoryView("sys/tools");
        super.beforeInitBinder(binder);
    }
}