package cn.core.security.component;

import cn.core.annotation.AInitMenu;
import cn.core.component.IinitSysInfo;
import cn.core.domain.BaseBean;
import cn.core.security.domain.SysMenu;
import cn.core.security.service.ISysMenuService;
import cn.core.service.base.IBaseService;
import jdk.nashorn.internal.ir.BaseNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by howeTong on 2017/9/6.
 */
@Component
public class InitMenuInfo implements IinitSysInfo{

    private static Logger logger = LoggerFactory.getLogger(InitMenuInfo.class);

    @Resource
    private ISysMenuService menuService;

    @Override
    public void init(ApplicationContext context, ServletContext ctx, IBaseService service) {
        logger.info("初始化菜单信息...");
        //获取spring（子）容器中所有注解为@controller的Bean的名字
        String[] beanNames = context.getBeanNamesForAnnotation(Controller.class);
        for (String beanName : beanNames) {
            //获取当前控制器的RequestMapping注解
            RequestMapping mapping = context.findAnnotationOnBean(beanName, RequestMapping.class);
            //获取当前控制器的AInitMenu注解
            AInitMenu menu = context.findAnnotationOnBean(beanName, AInitMenu.class);
            if (menu == null) {
                continue;
            }

            String path = menu.path();
            if (path == null || "#".equals(path)) {
                Class<?> handlerType = context.getType(beanName);
                if (mapping != null) {
                    //如果存在请求映射路径，就取映射路径的第一个值
                    String[] typeLevelPatterns = mapping.value();
                    if (typeLevelPatterns != null && typeLevelPatterns.length > 0) {
                        path = typeLevelPatterns[0];
                    }
                } else if (AnnotationUtils.findAnnotation(handlerType, Controller.class) != null){
                    //如果不存在请求映射路径，但该bean上有controller注解
                    Map<String, String> conpath = new HashMap<String, String>();
                    ReflectionUtils.doWithMethods(handlerType, new ReflectionUtils.MethodCallback() {
                        @Override
                        public void doWith(Method method) {
                            RequestMapping mapping = AnnotationUtils.findAnnotation(method, RequestMapping.class);
                            if (mapping != null) {
                                String[] mappedPatterns = mapping.value();
                                if (mappedPatterns.length > 0) {
                                    for (String mappedPattern : mappedPatterns) {
                                        if (!mappedPattern
                                                .startsWith("/")) {
                                            mappedPattern = "/"
                                                    + mappedPattern;
                                        }
                                        conpath.put("conpath", mappedPattern);
                                    }
                                }
                            }
                        }
                    }, ReflectionUtils.USER_DECLARED_METHODS);
                    path = conpath.get("conpath");
                }
            }
            try {
                //如果当前控制器的AInitMenu注解中path不为null和#
                Object bean = context.getBean(beanName);
                //根据参数类型和方法名获取当前controller的方法
                Method m = bean.getClass().getMethod("doView", String.class);
                if (m != null) {
                    if (!path.startsWith("/")) {
                        path = "/"+path;
                    }
                    if (!path.endsWith("/")) {
                        path = path+"/";
                    }
                    String url = "page" + path + "view";
                    createMenu(menu, url);
                }
            } catch (NoSuchMethodException e) {
                continue;
            } catch (SecurityException e) {
                continue;
            }
        }
    }

    private void createMenu(AInitMenu annomenu, String path) {
        if (null == annomenu || null != menuService.getByProperties(BaseBean.NAME_FIELD,
                annomenu.name(), SysMenu.class)) {
            return;
        }
        SysMenu sysMenu = new SysMenu();
        sysMenu.setName(annomenu.name());
        sysMenu.setUrl(path);
        sysMenu.setType(annomenu.type());
        sysMenu.setCreateTime(new Date());
        if (annomenu.addParent()) {
            SysMenu pmenu = null;
            //如果菜单拥有父菜单
            if (annomenu.parent() != null) {
                //获取父菜单
                pmenu = menuService.getByProperties(BaseBean.NAME_FIELD, annomenu.parent(), SysMenu.class);
            }
            //如果菜单没有父菜单（即本身就是顶级菜单）
            if (pmenu == null) {
                pmenu = new SysMenu();
                pmenu.setName(annomenu.parent());
                pmenu.setAsParent(true);
                pmenu.setCreateTime(new Date());
                menuService.save(pmenu);
            }
            sysMenu.setParent(pmenu);
        }
        menuService.save(sysMenu);
        logger.info("sysMenu:" + sysMenu);
    }
}
