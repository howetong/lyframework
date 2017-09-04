package cn.core.interceptor.validation;

/**
 * Created by howeTong on 2017/7/18 0018.
 */
public class ValidException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ValidException(String message){
        super(message);
    }

    public ValidException() {
        super();
    }

    public ValidException(String message, Throwable cause) {
        super(message, cause);
    }
    public ValidException(Throwable cause) {
        super(cause);
    }
}
