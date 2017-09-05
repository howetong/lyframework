package cn.core.security.service.impl;

import cn.core.security.dao.ISysUserDao;
import cn.core.security.service.ISysUserService;
import cn.core.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by howetong on 9/5/2017.
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl implements ISysUserService {

    private ISysUserDao userDao;

    @Resource
    public void setUserDao(ISysUserDao userDao){
        this.userDao = userDao;
        this.dao = userDao;
    }
}
