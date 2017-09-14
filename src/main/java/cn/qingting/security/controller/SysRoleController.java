package cn.qingting.security.controller;

import cn.qingting.core.annotation.AInitMenu;
import cn.qingting.core.controller.CRUDController;
import cn.qingting.security.domain.SysUser;
import cn.qingting.security.service.ISysRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 *
 */
@Controller
@RequestMapping("/admin/role")
@AInitMenu(name="角色管理",parent = "系统管理", type=1, path="/admin/role")
public class SysRoleController extends CRUDController<SysUser> {

    private ISysRoleService service;

    @Resource
    public void setRoleService(ISysRoleService service) {
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
