package cn.core.aop;

import cn.core.exception.BusinessException;
import cn.core.exception.ErrorCodeDefinition;
import cn.core.interceptor.validation.DataValidationUtil;
import cn.core.interceptor.validation.ValidException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by howeTong on 2017/7/18 0018.
 */
@Component
@Aspect
public class BeanAspect {
    @Before("@annotation(cn.core.interceptor.validation.BeanValid)")
    public void checkBeanValid(JoinPoint joinPoint) throws Exception{
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        try {
            args.stream().forEach((Object obj) -> {
                DataValidationUtil.validate(obj);
            });
        } catch (ValidException e) {
            throw new BusinessException(ErrorCodeDefinition.INVALID_PARAMETER, "参数不合法," + e.getMessage());
        }
    }
}
