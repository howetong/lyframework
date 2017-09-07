package cn.core.security.domain;

import cn.core.domain.ParentChildrenBean;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 菜单表，拥有角色就拥有菜单，拥有权限才能操作菜单
 * Created by howeTong on 2017/6/11 0011.
 */
@Entity
@Table(name="Sys_Menu")
public class SysMenu extends ParentChildrenBean<SysMenu> {

    /**
     * 菜单类型
     */
    private static final String TYPE_FIELD = "type";

    /**
     * 系统操作链接
     */
    public static final Integer TYPE_SYSTEM_INTEGER = 0;

    /**
     * 菜单
     */
    public static final Integer TYPE_MENU_INTEGER = 1;

    /**
     * 按钮
     */
    public static final Integer TYPE_BUTTON_INTEGER = 2;

    //图片样式
    private String iconCls = "ace-icon fa fa-list-alt";

    //css样式
    private String className = "icon-bookmark-empty";

    /**
     * 所需要的权限
     */
    @ManyToMany(cascade={CascadeType.REFRESH})
    @JoinTable(name = "Sys_Menu_Auth", joinColumns = { @JoinColumn(name = "menu_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "auth_id", referencedColumnName = "id") })
    private List<SysAuth> auths = new ArrayList<SysAuth>();

    /**
     * 所需要的角色
     */
    @ManyToMany(cascade={CascadeType.REFRESH})
    @JoinTable(name = "Sys_Menu_Role", joinColumns = { @JoinColumn(name = "menu_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") })
    private List<SysRole> roles = new ArrayList<SysRole>();

    /**
     * 访问连接
     */
    private String url = "#";

    // 类型，默认是菜单类型
    private Integer type = TYPE_MENU_INTEGER;

    public SysMenu() {
        super();
    }

    public SysMenu(Long id) {
        super(id);
    }

    public SysMenu(Long id,String name) {
        super(id,name);
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<SysAuth> getAuths() {
        return auths;
    }

    public void setAuths(List<SysAuth> auths) {
        this.auths = auths;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
