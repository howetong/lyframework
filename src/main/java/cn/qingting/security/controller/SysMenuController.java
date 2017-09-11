package cn.qingting.security.controller;

import cn.qingting.core.annotation.AInitMenu;
import cn.qingting.core.controller.CRUDController;
import cn.qingting.security.domain.SysMenu;
import cn.qingting.security.service.ISysMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by howetong on 9/9/2017.
 */
@Controller
@RequestMapping("/admin/menu")
@AInitMenu(name="菜单管理",parent="系统管理",type=1,path="/admin/menu")
public class SysMenuController extends CRUDController<SysMenu> {

    private ISysMenuService service;

    @Resource
    public void setMenuService(ISysMenuService service) {
        this.service = service;
        super.service = service;
    }

}
