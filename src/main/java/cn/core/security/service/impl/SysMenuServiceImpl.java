package cn.core.security.service.impl;

import cn.core.security.dao.ISysMenuDao;
import cn.core.security.service.ISysMenuService;
import cn.core.service.base.BaseServiceImpl;
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



