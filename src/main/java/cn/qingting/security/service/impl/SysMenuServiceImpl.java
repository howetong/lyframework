package cn.qingting.security.service.impl;

import cn.qingting.security.dao.ISysMenuDao;
import cn.qingting.security.service.ISysMenuService;
import cn.qingting.core.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by howeTong on 2017/6/11 0011.
 */
@Service
public class SysMenuServiceImpl extends BaseServiceImpl implements ISysMenuService {

    private ISysMenuDao menuDao;

    @Resource
    public void setMenuDao(ISysMenuDao menuDao){
        this.menuDao = menuDao;
        this.dao = menuDao;
    }
}



