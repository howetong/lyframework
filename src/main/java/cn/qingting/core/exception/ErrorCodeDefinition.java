package cn.qingting.core.exception;

/**
 * Created by howeTong on 2017/7/18 0018.
 */
public enum  ErrorCodeDefinition {
    INVALID_PARAMETER(10850001,"参数不合法");

    ErrorCodeDefinition(Integer errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    private final Integer errCode;

    private final String errMsg;

    public Integer getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }
}
