package cn.core.component;

import cn.core.service.base.IBaseService;
import cn.core.utils.LoggerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import java.util.List;

/**
 * spring容器初始化完成事件(ContextRefreshedEvent)监听器
 * Created by howeTong on 2017/9/6.
 */
@Component
public class InstantiationUtil implements ApplicationListener<ContextRefreshedEvent>{

    private static Logger logger = LoggerFactory.getLogger(InstantiationUtil.class);

    private static ApplicationContext context;

    @Resource
    private List<IinitSysInfo> iinitSysInfos;

    private static ServletContext ctx;

    @Resource(name = "baseSimpleServiceImpl")
    protected IBaseService service;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (event.getApplicationContext().getParent() == null) {
            //监听spring顶级容器初始化完成事件
            logger.info("spring容器初始化完成，获取系统配置信息");
            context = event.getApplicationContext();
        }else {
            //监听spring子容器初始化完成事件
            context = event.getApplicationContext();
            logger.info("springmvc容器初始化完成，加载初始化...{}",iinitSysInfos);
            if (iinitSysInfos != null && iinitSysInfos.size() > 0) {
                for (IinitSysInfo iinitSysInfo : iinitSysInfos) {
                    try {
                        iinitSysInfo.init(context, ctx, service);
                    } catch (Exception e) {
                        LoggerUtils.info(iinitSysInfo.getClass(), "初始化错误,跳过继续执行...." + e.getMessage());
                        e.printStackTrace();
                        continue;
                    }
                }
            }
        }
    }

    public static ApplicationContext getContext() {
        return context;
    }

}
