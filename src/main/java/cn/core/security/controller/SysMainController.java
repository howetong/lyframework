package cn.core.security.controller;

import cn.core.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 后台首页先关界面数据
 * Created by howeTong on 2017/6/8 0008.
 */
@Controller
@RequestMapping("/admin")
public class SysMainController extends BaseController {

    @RequestMapping(method= RequestMethod.GET)
    public ModelAndView doIndex() throws Exception{
        ModelAndView mv = new ModelAndView();
        //查询所有状态正常的一级菜单
//        List<SysMenu> rootMenu = this.service.queryByProperties(new String[]{ParentChildrenBean.PARENT_FIELD,BaseBean.STATUS_FIELD},
//                new Object[]{null,false},sortedCondition,SysMenu.class);
//        mv.addObject("menus",rootMenu);
        mv.setViewName(getTemplateDirectoryView()+"/index");
        return mv;
    }

}
