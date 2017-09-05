package cn.core.service.impl;

import cn.core.dao.IBaseSimpleDao;
import cn.core.service.IBaseSimpleService;
import cn.core.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 
 * @description 业务逻辑服务实现层
 * @author howeTong
 */
@Service
public class BaseSimpleServiceImpl extends BaseServiceImpl implements IBaseSimpleService {

	@Resource(name="baseSimpleDaoImpl")
	protected IBaseSimpleDao dao;

}
