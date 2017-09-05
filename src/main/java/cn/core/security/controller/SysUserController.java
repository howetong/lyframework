package cn.core.security.controller;

import cn.core.controller.CRUDController;
import cn.core.security.domain.SysUser;
import cn.core.security.service.ISysUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by howetong on 9/5/2017.
 */
@Controller
@RequestMapping("/admin/user")
public class SysUserController extends CRUDController<SysUser> {

    private ISysUserService service;

    @Resource
    public void setUserService(ISysUserService service) {
        this.service = service;
        super.service = service;
    }

}
