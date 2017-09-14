package cn.qingting.security.component;

import cn.qingting.core.component.IinitSysInfo;
import cn.qingting.core.service.base.IBaseService;
import cn.qingting.security.domain.SysRole;
import cn.qingting.security.domain.SysUser;
import cn.qingting.security.service.ISysRoleService;
import cn.qingting.security.service.ISysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * description：初始化基本用户信息
 * Created by howetong on 9/13/2017.
 */
@Component
public class InitUserInfo implements IinitSysInfo{

    public static Logger logger = LoggerFactory.getLogger(InitUserInfo.class);

    @Resource
    private ISysUserService userService;

    @Resource
    private ISysRoleService roleService;

    @Override
    public void init(ApplicationContext context, ServletContext ctx, IBaseService service) {
        Long userCount = userService.countAll(SysUser.class);
        if (userCount == null || userCount < 1) {
            logger.info("初始化系统用户...");
            SysUser user = new SysUser();
            user.setStatus(1);
            user.setRoot(true);
            user.setUsername("root");
            user.setPassword("root");
            user.setAllRole(true);
            user.setCreateTime(new Date());
            user.setName("超级管理员");
            Long roleCount = roleService.countAll(SysRole.class);
            List<SysRole> roles = new ArrayList<>();
            SysRole role = null;
            if (roleCount == null || roleCount < 1) {
                role = createRole();
            } else {
                role = roleService.get(SysRole.class, 1);
                if (role == null) {
                    role = createRole();
                }
            }
            if (role.getId() != 1) {
                role.setId(1L);
                roleService.update(role);
            }
            roles.add(role);
            user.setRoles(roles);
            userService.save(user);
            logger.info("系统用户初始化完成");
        }
    }


    private SysRole createRole() {
        logger.info("初始化角色信息...");
        SysRole role = new SysRole();
        role.setStatus(1);
        role.setRoot(true);
        role.setAllAuth(true);
        role.setCreateTime(new Date());
        role.setName("超级用户");
        roleService.save(role);
        return role;
    }
}
