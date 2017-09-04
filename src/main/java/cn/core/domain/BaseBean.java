package cn.core.domain;

import cn.core.domain.support.ExpandBaseParameter;
import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by howeTong on 2017/6/11 0011.
 */
@MappedSuperclass
public abstract class BaseBean extends ExpandBaseParameter {
    /**
     * id字段，long型
     */
    public static final String ID_FIELD = "id";

    /**
     * 删除状态字段，boolean值
     */
    public static final String DEL_STATUS_FIELD = "delStatus";

    /**
     * 状态字段，布尔型
     */
    public static final String STATUS_FIELD = "status";

    /**
     * 序列字段,Integer型
     */
    public static final String SEQUENCE_FIELD = "sequence";

    /**
     * 创建时间 字段,Date型
     */
    public static final String CREATETIME_FIELD = "createTime";
    /**
     * 修改时间 字段,Date型
     */
    public static final String UPDATETIME_FIELD = "updateTime";

    /**
     * code字段，String型
     */
    public static final String CODE_FIELD = "code";

    @Id
    @GeneratedValue
    private Long id;
    /**
     * 创建时间，值为时间戳
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    /**
     * 名称
     */
    private String name;
    /**
     * 描述信息
     */
    @Type(type="text")
    private String description;
    /**
     * 排序
     */
    @Column(columnDefinition = "INT default 0")
    private int sequence = 0;
    /**
     * 修改时间，值为时间戳
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    /**
     * 状态，true表示正常
     */
    private boolean status = true;
    /**
     * 状态删除，true表示删除
     */
    @JSONField(serialize = false)
    private boolean delStatus = false;
    /**
     * 编号
     */
    @Column(unique = true)
    private String code;

    public BaseBean() {
    }

    public BaseBean(Long id) {
        super();
        this.id = id;
    }

    public BaseBean(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isDelStatus() {
        return delStatus;
    }

    public void setDelStatus(boolean delStatus) {
        this.delStatus = delStatus;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
