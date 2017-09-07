package cn.core.security.controller;

import cn.core.annotation.AInitMenu;
import cn.core.controller.CRUDController;
import cn.core.security.domain.SysUser;
import cn.core.security.service.ISysUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
}
