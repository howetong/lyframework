package cn.core.security.domain;

import cn.core.domain.ParentChildrenBean;
import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 权限表，与角色和菜单都是多对多关系。角色拥有某菜单和某权限，但该权限能不能操作该菜单需要看权限和菜单的关系
 * Created by howetong on 9/6/2017.
 */
@Entity
@Table(name="Sys_Auth")
public class SysAuth extends ParentChildrenBean<SysAuth>{

    /**
     * 可以使用的菜单
     */
    @ManyToMany(cascade = { CascadeType.REFRESH })
    @JSONField(serialize = false)
    @JoinTable(name = "Sys_Menu_Auth", joinColumns = { @JoinColumn(name = "auth_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "menu_id", referencedColumnName = "id") })
    private List<SysMenu> menus = new ArrayList<SysMenu>();

    /**
     * 所属的角色
     */
    @ManyToMany(cascade = { CascadeType.REFRESH })
    @JSONField(serialize = false)
    @JoinTable(name = "Sys_Role_Auth", joinColumns = { @JoinColumn(name = "auth_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
    private List<SysRole> roles = new ArrayList<SysRole>();


    public SysAuth() {
        super();
    }

    public SysAuth(Long id) {
        super(id);
    }

    public SysAuth(Long id,String name) {
        super(id,name);
    }

    public List<SysMenu> getMenus() {
        return menus;
    }

    public void setMenus(List<SysMenu> menus) {
        this.menus = menus;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }
}
