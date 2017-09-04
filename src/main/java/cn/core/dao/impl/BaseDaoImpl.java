package cn.core.dao.impl;

import cn.core.dao.IBaseDao;
import cn.core.domain.BaseBean;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by howeTong on 2017/6/11 0011.
 */
@Repository
public class BaseDaoImpl implements IBaseDao {

    @Resource
    private SessionFactory sessionFactory;

    public Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    public <T extends BaseBean> List<T> queryByProperties(String[] propName, Object[] propValue, Map<String, String> sortedCondition, Class<T> entityClass) {
        return queryByProperties(propName, propValue, sortedCondition, null,entityClass);
    }

    public <T extends BaseBean> List<T> queryByProperties(String[] propName,Object[] propValue, Map<String, String> sortedCondition, Integer top, Class<T> entityClass) {
        if ((propName != null) && (propValue != null)
                && (propValue.length == propName.length)) {
            StringBuffer sb = new StringBuffer("select o from "
                    + entityClass.getName() + " o where 1=1 ");
            appendQL(sb, propName, propValue);
            if ((sortedCondition != null) && (sortedCondition.size() > 0)) {
                sb.append(" order by ");
                for (Map.Entry<String, String> e : sortedCondition.entrySet()) {
                    sb.append((String) e.getKey() + " " + (String) e.getValue()
                            + ",");
                }
                sb.deleteCharAt(sb.length() - 1);
            }
            Query query = getSession().createQuery(sb.toString());
            setParameter(query, propName, propValue);
            if (top != null) {
                query.setFirstResult(0);
                query.setMaxResults(top.intValue());
            }
            return query.list();
        }
        return null;
    }

    private void appendQL(StringBuffer sb, String[] propName, Object[] propValue) {
        for (int i = 0; i < propName.length; i++) {
            String name = propName[i];
            Object value = propValue[i];
            if (((value instanceof Object[]))
                    || ((value instanceof Collection))) {
                Object[] arraySerializable = (Object[]) value;
                if ((arraySerializable != null)
                        && (arraySerializable.length > 0)) {
                    sb.append(" and o." + name + " in (:"
                            + name.replace(".", "") + ")");
                }
            } else if (value == null) {
                sb.append(" and o." + name + " is null ");
            } else {
                sb.append(" and o." + name + "=:" + name.replace(".", ""));
            }
        }
    }

    private void setParameter(Query query, String[] propName, Object[] propValue) {
        for (int i = 0; i < propName.length; i++) {
            String name = propName[i];
            Object value = propValue[i];
            if (value != null) {
                if ((value instanceof Object[])) {
                    query.setParameterList(name.replace(".", ""),
                            (Object[]) value);
                } else if ((value instanceof Collection)) {
                    query.setParameterList(name.replace(".", ""),
                            (Collection) value);
                } else {
                    query.setParameter(name.replace(".", ""), value);
                }
            }
        }
    }

}
