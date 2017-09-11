package cn.qingting.core.interceptor.validation;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Created by howeTong on 2017/7/18 0018.
 */
public class DataValidationUtil {
    private static final Logger LOG = LoggerFactory.getLogger(DataValidationUtil.class);
    private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static Validator validator = factory.getValidator();
    public static <T> void validate(T bean){
        StringBuffer sb = new StringBuffer();
        try {
            if (null == bean) {
                sb.append("校验的对象不能为null");
            } else {
                Set<ConstraintViolation<T>> constraintViolations = validator.validate(bean);
                for (ConstraintViolation<T> violation : constraintViolations) {
                    sb.append(violation.getPropertyPath()).append(":").append(violation.getMessage()).append(" ,");
                }
            }
        } catch (RuntimeException e) {
            LOG.error("数据校验发生异常", e);
            sb.append("数据校验发生异常，请检查字段注解配置是否合法");
        }
        if(StringUtils.isNotEmpty(sb.toString())){
            LOG.info("校验异常入参");
            throw new ValidException(sb.toString());
        }
    }
}
