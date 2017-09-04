package cn.core.security.domain;

import cn.core.domain.UserNewEditBean;
import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by howeTong on 2017/6/11 0011.
 */
@Entity
@Table(name="Sys_User")
public class SysUser extends UserNewEditBean {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    @JSONField(serialize = false)
    private String password;

    /**
     * 盐是用户名+随机数
     */
    @JSONField(serialize = false)
    private String salt;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
