package cn.qingting.core.domain;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by howeTong on 2017/6/11 0011.
 */
@MappedSuperclass
public abstract class ParentChildrenBean<T> extends UserNewEditBean {
    /**
     * 父类元素字段
     */
    public static final String PARENT_FIELD = "parent";

    /**
     * 子类字段
     */
    public static final String CHILDREN_FIELD = "children";

    /**
     * 枝干
     */
    public static final String ASPARENT_FIELD = "asParent";

    /**
     * 叶子
     */
    public static final String LEAF_FIELD = "leaf";

    /**
     * 父菜单标识
     */
    private Boolean asParent;

    /**
     * 子菜单标识
     */
    private Boolean leaf;

    /**
     * 父类（对子菜单标识为真的菜单而言）
     */
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="parent_id")
    @JSONField(serialize=false)
    private T parent;

    /**
     * 子类（对父菜单标识为真的菜单而言）
     */
    @OneToMany(mappedBy="parent",fetch=FetchType.LAZY)
    @JSONField(serialize=false)
    private List<T> children = new ArrayList<T>();

    public ParentChildrenBean() {
        super();
    }

    public ParentChildrenBean(Long id) {
        super(id);
    }

    public ParentChildrenBean(Long id,String name) {
        super(id,name);
    }

    public T getParent() {
        return parent;
    }

    public void setParent(T parent) {
        this.parent = parent;
    }

    public List<T> getChildren() {
        return children;
    }

    public void setChildren(List<T> children) {
        this.children = children;
    }

    public Boolean getAsParent() {
        return asParent;
    }

    public void setAsParent(Boolean asParent) {
        this.asParent = asParent;
    }

    public Boolean getLeaf() {
        return leaf;
    }

    public void setLeaf(Boolean leaf) {
        this.leaf = leaf;
    }
}
