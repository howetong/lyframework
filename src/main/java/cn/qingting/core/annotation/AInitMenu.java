package cn.qingting.core.annotation;

import java.lang.annotation.*;

/**
 * Created by howeTong on 2017/9/6.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface AInitMenu {

    /**
     * 菜单名称
     */
    String name() default "新菜单";

    /**
     * 上级菜单名称
     */
    String parent() default "系统菜单";

    /**
     * 菜单类型
     * 1-用于访问资源的连接  2-按钮 0-系统
     */
    int type() default 1;

    /**
     * 菜单路径
     */
    String path() default "#";

    /**
     * 是否创建父菜单
     */
    boolean addParent() default true;
}
