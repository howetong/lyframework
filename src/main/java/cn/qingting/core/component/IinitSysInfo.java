package cn.qingting.core.component;

import cn.qingting.core.service.base.IBaseService;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;
import java.io.Serializable;

/**
 * 基础数据初始化
 * Created by howeTong on 2017/9/6.
 */
public interface IinitSysInfo extends Serializable{

    public void init(ApplicationContext context, ServletContext ctx, IBaseService service);
}
