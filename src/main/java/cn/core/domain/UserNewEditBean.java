package cn.core.domain;

import cn.core.security.domain.SysUser;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * Created by howeTong on 2017/6/11 0011.
 */
@MappedSuperclass
public abstract class UserNewEditBean extends BaseBean{

    /**
     * 创建者
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = true)
    private SysUser createUser;
    /**
     * 修改者
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = true)
    private SysUser updateUser;

    public UserNewEditBean() {
        super();
    }

    public UserNewEditBean(Long id) {
        super(id);
    }

    public UserNewEditBean(Long id,String name) {
        super(id,name);
    }

    public SysUser getCreateUser() {
        return createUser;
    }

    public void setCreateUser(SysUser createUser) {
        this.createUser = createUser;
    }

    public SysUser getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(SysUser updateUser) {
        this.updateUser = updateUser;
    }
}
