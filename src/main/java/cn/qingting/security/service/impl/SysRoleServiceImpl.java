package cn.qingting.security.service.impl;

import cn.qingting.security.dao.ISysRoleDao;
import cn.qingting.security.service.ISysRoleService;
import cn.qingting.core.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by howetong on 9/6/2017.
 */
@Service
public class SysRoleServiceImpl extends BaseServiceImpl implements ISysRoleService {

    private ISysRoleDao roleDao;

    @Resource
    public void setRoleDao(ISysRoleDao roleDao){
        this.roleDao = roleDao;
        this.dao = roleDao;
    }
}
