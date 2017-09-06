package cn.core.security.service.impl;

import cn.core.security.dao.ISysRoleDao;
import cn.core.security.service.ISysRoleService;
import cn.core.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by howetong on 9/6/2017.
 */
@Service
public class SysRoleServiceImpl extends BaseServiceImpl implements ISysRoleService{

    private ISysRoleDao roleDao;

    @Resource
    public void setRoleDao(ISysRoleDao roleDao){
        this.roleDao = roleDao;
        this.dao = roleDao;
    }
}
