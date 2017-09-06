package cn.core.annotation;

import java.lang.annotation.*;

/**
 * Created by howeTong on 2017/9/6.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface AInitMenu {

    String name() default "新菜单";

    /**
     * 菜单类型
     * 1-用于访问资源的连接  2-按钮 0-系统
     */
    int type() default 1;

    /**
     * 菜单路径
     */
    String path() default "#";
}
