package cn.qingting.core.domain.support;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 基本参数扩展功能属性
 * Created by howeTong on 2017/6/11 0011.
 */
public class ExpandBaseParameter extends BaseParameter{

    /**
     * 功能字段，操作状态，用于向前端反馈
     */
    private Boolean success;

    /**
     * 功能字段，消息信息，用于向前端反馈
     */
    private String message;

    @JSONField(serialize = false)
    private Integer $eq_delStatus;
    @JSONField(serialize = false)
    private Integer $eq_status;
    @JSONField(serialize = false)
    private String $like_name;
    @JSONField(serialize = false)
    private String $like_description;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer get$eq_delStatus() {
        return $eq_delStatus;
    }

    public void set$eq_delStatus(Integer $eq_delStatus) {
        this.$eq_delStatus = $eq_delStatus;
    }

    public Integer get$eq_status() {
        return $eq_status;
    }

    public void set$eq_status(Integer $eq_status) {
        this.$eq_status = $eq_status;
    }

    public String get$like_name() {
        return $like_name;
    }

    public void set$like_name(String $like_name) {
        this.$like_name = $like_name;
    }

    public String get$like_description() {
        return $like_description;
    }

    public void set$like_description(String $like_description) {
        this.$like_description = $like_description;
    }
}
