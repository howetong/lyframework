package cn.qingting.core.domain.interfaces;

import cn.qingting.core.domain.BaseBean;

import java.util.List;

public interface IEntityParentChildrenBean<T extends BaseBean> {
	/**
	 * 父类元素字段,T型
	 */
    String PARENT_FIELD = "parent";
	/**
	 * 父类元素id字段,Long型
	 */
    String PARENT_ID_FIELD = "parent.id";
	/**
	 * 枝干,Boolean型
	 */
    String ASPARENT_FIELD = "asParent";
	/**
	 * 叶子,Boolean型
	 */
    String LEAF_FIELD = "leaf";
	/**
	 * 子类字段,List<T>型
	 */
    String CHILDREN_FIELD = "children";

	T getParent();

	void setParent(T parent);

	List<T> getChildren();

	void setChildren(List<T> children);
}
