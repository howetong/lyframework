package cn.core.security.domain;

import cn.core.domain.ParentChildrenBean;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by howetong on 9/6/2017.
 */
@Entity
@Table(name="Sys_Auth")
public class SysAuth extends ParentChildrenBean<SysAuth>{

    /**
     * 所拥有的菜单权限
     */
    @OneToMany(fetch= FetchType.LAZY)
    @JoinTable(name="SYS_Auth_Menu",joinColumns={@JoinColumn(name="auth_id")},inverseJoinColumns={@JoinColumn(name="menu_id")})
    private List<SysMenu> menus = new ArrayList<>();

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
}
