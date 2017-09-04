package cn.core.domain.support;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 基本参数模型，主要是分页模型、排序等参数
 * Created by howeTong on 2017/6/11 0011.
 */
public class BaseParameter implements Serializable{

    private static final long serialVersionUID = 1L;
    public static final String SORTED_ASC = "ASC";
    public static final String SORTED_DESC = "DESC";

    /**
     * 页码
     */
    @JSONField(serialize = false)
    private Integer page = 1;

    /**
     * 每页数据记录数,默认为10
     */
    @JSONField(serialize = false)
    private Integer rows = 10;

    /**
     * top n数据
     */
    @JSONField(serialize = false)
    private Integer topCount;

    /**
     * 字段分类
     */
    @JSONField(serialize = false)
    private String[] sortColumns;

    /**
     * 操作指令
     */
    @JSONField(serialize = false)
    private String cmd;

    /**
     * 数据库操作查询种类
     */
    @JSONField(serialize = false)
    private String flag = "AND";

    /**
     * 数据库操作排序字段
     */
    @JSONField(serialize = false)
    private Map<String,String> sortedConditions = new LinkedHashMap(4);

    @JSONField(serialize = false)
    private Map<String,Object> queryDynamicConditions = new HashMap(4);

    @JSONField(serialize = false)
    private Map<String,Object> dynamicProperties = new HashMap(4);

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        if (page == null || page == 0){
            page = 1;
        }
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getTopCount() {
        return topCount;
    }

    public void setTopCount(Integer topCount) {
        this.topCount = topCount;
    }

    public String[] getSortColumns() {
        return sortColumns;
    }

    public void setSortColumns(String[] sortColumns) {
        this.sortColumns = sortColumns;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Map<String, String> getSortedConditions() {
        return sortedConditions;
    }

    public void setSortedConditions(Map<String, String> sortedConditions) {
        this.sortedConditions = sortedConditions;
    }

    public Map<String, Object> getQueryDynamicConditions() {
        return queryDynamicConditions;
    }

    public void setQueryDynamicConditions(Map<String, Object> queryDynamicConditions) {
        this.queryDynamicConditions = queryDynamicConditions;
    }

    public Map<String, Object> getDynamicProperties() {
        return dynamicProperties;
    }

    public void setDynamicProperties(Map<String, Object> dynamicProperties) {
        this.dynamicProperties = dynamicProperties;
    }

    /**
     * 当前页第一条记录index
     * @return
     */
    public Integer getFirstResult(){
        return this.getRows()* (this.getPage() - 1);
    }

    /**
     * 当前页最后一条记录index + 1（index总是比记录数少1）
     * @return
     */
    public Integer getLastResult(){
        return this.getRows()* this.getPage();
    }
}
