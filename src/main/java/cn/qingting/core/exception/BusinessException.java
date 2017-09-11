package cn.qingting.core.exception;

/**
 * Created by howeTong on 2017/7/18 0018.
 */
public class BusinessException extends RuntimeException{

    private ErrorCodeDefinition errorCodeDefinition;

    private Integer errCode;

    private String errMsg;

    public BusinessException() {
    }

    public BusinessException(int errCode, String errMsg){
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public BusinessException(ErrorCodeDefinition errorCodeDefinition,String errMsg){
        this.errorCodeDefinition = errorCodeDefinition;
        this.errMsg = errMsg;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public ErrorCodeDefinition getErrorCodeDefinition() {
        return errorCodeDefinition;
    }

    public void setErrorCodeDefinition(ErrorCodeDefinition errorCodeDefinition) {
        this.errorCodeDefinition = errorCodeDefinition;
    }
}
