package cn.core.security.controller;

import cn.core.controller.CRUDController;
import cn.core.security.domain.SysUser;
import cn.core.security.service.ISysRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 *
 */
@Controller
@RequestMapping("/admin/role")
public class SysRoleController extends CRUDController<SysUser> {

    private ISysRoleService service;

    @Resource
    public void setRoleService(ISysRoleService service) {
        this.service = service;
        super.service = service;
    }
}
