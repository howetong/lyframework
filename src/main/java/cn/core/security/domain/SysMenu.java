package cn.core.security.domain;

import cn.core.domain.ParentChildrenBean;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by howeTong on 2017/6/11 0011.
 */
@Entity
@Table(name="Sys_Menu")
public class SysMenu extends ParentChildrenBean<SysMenu> {

    //图片样式
    private String iconCls = "menu";
    //css样式
    private String className = "icon-bookmark-empty";

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
}
