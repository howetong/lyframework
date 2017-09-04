package cn.core.dao;

import cn.core.domain.BaseBean;

import java.util.List;
import java.util.Map;

/**
 * Created by howeTong on 2017/6/11 0011.
 */
public interface IBaseDao {

    /**
     * 根据属性和排序条件获取对象实体列表
     * @param propName  属性数组名称
     * @param propValue 属性数组值
     * @param sortedCondition 排序条件
     * @param entityClass 要查询的实体类
     * @param <T> 返回对象实体列表
     * @return
     */
    public <T extends BaseBean> List<T> queryByProperties(String[] propName, Object[] propValue, Map<String, String> sortedCondition, Class<T> entityClass);

    /**
     * 根据属性名，排序条件和要返回的记录数据获取对象实体列表
     * @param propName 属性数组名称
     * @param propValue 属性数组值
     * @param sortedCondition 排序条件
     * @param top 要返回的记录数目
     * @param entityClass 要查询的实体类
     * @param <T> 返回对象实体列表
     * @return
     */
    public <T extends BaseBean> List<T> queryByProperties(String[] propName,Object[] propValue, Map<String, String> sortedCondition, Integer top, Class<T> entityClass);

}
