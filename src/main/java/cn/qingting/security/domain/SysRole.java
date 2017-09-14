package cn.qingting.security.domain;

import cn.qingting.core.domain.ParentChildrenBean;
import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by howetong on 9/6/2017.
 */
@Entity
@Table(name="Sys_Role")
public class SysRole extends ParentChildrenBean<SysRole> {

    /**
     * 所有权限字段 boolean
     */
    public static final String ALL_AUTH = "allAuth";

    /**
     * 所拥有的权限
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Sys_Auth_Role", joinColumns = {@JoinColumn(name="role_id")},inverseJoinColumns = {@JoinColumn(name="auth_id")})
    private List<SysAuth> auths = new ArrayList<SysAuth>();

    /**
     * 所拥有的用户
     */
    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.REFRESH})
    @JoinTable(name="Sys_Role_User",joinColumns = {@JoinColumn(name="role_id")},inverseJoinColumns = {@JoinColumn(name="user_id")})
    //角色拥有的用户不需要发往前端
    @JSONField(serialize = false)
    private List<SysUser> users = new ArrayList<>();

    private Boolean allAuth = false;

    @JSONField(serialize = false)
    private Boolean root = false;

    public SysRole() {
        super();
    }

    public SysRole(Long id) {
        super(id);
    }

    public SysRole(Long id, String name) {
        super(id, name);
    }

    public List<SysAuth> getAuths() {
        return auths;
    }

    public void setAuths(List<SysAuth> auths) {
        this.auths = auths;
    }

    public List<SysUser> getUsers() {
        return users;
    }

    public void setUsers(List<SysUser> users) {
        this.users = users;
    }

    public Boolean getAllAuth() {
        return allAuth;
    }

    public void setAllAuth(Boolean allAuth) {
        this.allAuth = allAuth;
    }

    public Boolean getRoot() {
        return root;
    }

    public void setRoot(Boolean root) {
        this.root = root;
    }
}