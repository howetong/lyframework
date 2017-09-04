package cn.core.service.impl;

import cn.core.dao.IBaseDao;
import cn.core.domain.BaseBean;
import cn.core.service.IBaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by howeTong on 2017/6/11 0011.
 */
@Service
public class BaseServiceImpl implements IBaseService {
    @Resource
    protected IBaseDao dao;

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public <T extends BaseBean> List<T> queryByProperties(String[] propName, Object[] propValue, Map<String, String> sortedCondition, Class<T> entityClass) {
        return this.dao.queryByProperties(propName, propValue, sortedCondition, entityClass);
    }
}
