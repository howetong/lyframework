package cn.qingting.security.domain;

import cn.qingting.core.domain.UserNewEditBean;
import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by howeTong on 2017/6/11 0011.
 */
@Entity
@Table(name="Sys_User")
public class SysUser extends UserNewEditBean {

    /**
     * 用户名
     */
    @NotEmpty(message = "用户名不能为空")
    @Column(unique = true)
    private String username;

    /**
     * 密码
     */
    @NotEmpty(message = "密码不能为空")
    @JSONField(serialize = false)
    private String password;

    /**
     * 用户修改密码时,验证用户的密码是否正确
     */
    @JSONField(serialize = false)
    @Transient
    private String oldPassword;

    /**
     * 是否是root用户
     */
    @JSONField(serialize = false)
    private Boolean root = false;

    /**
     * 盐是用户名+随机数
     */
    @JSONField(serialize = false)
    private String salt;

    /**
     * 登陆次数
     */
    @Column(columnDefinition = "INT default 0")
    private Integer loginCount = 0;
    /**
     * 登陆错误次数
     */
    @Column(columnDefinition = "INT default 0")
    private Integer loginErrorCount = 0;
    /**
     * 最后一次登录ip
     */
    private String lastLoginIp;
    /**
     * 最后一次登录时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginTime;

    //CascadeType.REFRESH级联刷新：获取目标对象时重新获取最新的items对象
    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name="Sys_Role_User", joinColumns = {@JoinColumn(name="user_id")},inverseJoinColumns ={@JoinColumn(name="role_id")})
    private List<SysRole> roles = new ArrayList<>();

    private Boolean allRole = false;

    public SysUser() {
        super();
    }

    public SysUser(Long id) {
        super(id);
    }

    public SysUser(Long id,String name) {
        super(id,name);
    }

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

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public Boolean isRoot() {
        return root;
    }

    public void setRoot(Boolean root) {
        this.root = root;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public Integer getLoginErrorCount() {
        return loginErrorCount;
    }

    public void setLoginErrorCount(Integer loginErrorCount) {
        this.loginErrorCount = loginErrorCount;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    public Boolean getAllRole() {
        return allRole;
    }

    public void setAllRole(Boolean allRole) {
        this.allRole = allRole;
    }

}
