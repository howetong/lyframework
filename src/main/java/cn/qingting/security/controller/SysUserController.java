package cn.qingting.security.controller;

import cn.qingting.core.annotation.AInitMenu;
import cn.qingting.core.controller.CRUDController;
import cn.qingting.security.domain.SysUser;
import cn.qingting.security.service.ISysUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by howetong on 9/5/2017.
 */
@Controller
@RequestMapping("/admin/user")
@AInitMenu(name="用户管理",parent="系统管理",type=1,path="/admin/user")
public class SysUserController extends CRUDController<SysUser> {

    private ISysUserService service;

    @Resource
    public void setUserService(ISysUserService service) {
        this.service = service;
        super.service = service;
    }

    /**
     * 设置系统管理模块路径
     */
    @Override
    protected void beforeInitBinder(WebDataBinder binder) {
        super.setModuleDirectoryView("sys");
        super.beforeInitBinder(binder);
    }
}
