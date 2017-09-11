package cn.qingting.core.interceptor.validation;

import java.lang.annotation.*;

/**
 * Created by howeTong on 2017/7/18 0018.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BeanValid {
    /* 是否必须校验 */
    boolean required() default true;
}
