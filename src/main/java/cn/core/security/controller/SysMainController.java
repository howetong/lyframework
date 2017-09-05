package cn.core.security.controller;

import cn.core.controller.BaseController;
import cn.core.controller.CRUDController;
import cn.core.domain.BaseBean;
import cn.core.domain.ParentChildrenBean;
import cn.core.security.domain.SysMenu;
import cn.core.security.service.ISysMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cn.core.utils.RequestUtils.getCurrentUrl;

/**
 * 后台首页相关界面数据
 * Created by howeTong on 2017/6/8 0008.
 */
@Controller
@RequestMapping("/admin")
public class SysMainController extends CRUDController<SysMenu> {

    @Resource
    protected ISysMenuService service;

    @RequestMapping(method= RequestMethod.GET)
    private ModelAndView doIndex() throws Exception{
        ModelAndView mv = new ModelAndView();
        Map<String, String> sortedCondition = new HashMap<String, String>();
        sortedCondition.put("sequence", "ASC");
        //查询所有状态正常的一级菜单
        List<SysMenu> rootMenu = this.service.queryByProperties(new String[]{ParentChildrenBean.PARENT_FIELD, BaseBean.STATUS_FIELD},
                new Object[]{null,false},sortedCondition,SysMenu.class);
        mv.addObject("menus",rootMenu);
        mv.addObject("mainPath",getCurrentUrl());
        mv.addObject("loginPath",getLoginUrl());
        mv.setViewName(getTemplateDirectoryView()+"/index");
        return mv;
    }

}
