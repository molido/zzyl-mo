package com.zzyl.nursing.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zzyl.common.annotation.Excel;
import com.zzyl.common.core.domain.BaseEntity;

/**
 * 护理计划和项目关联对象 nursing_project_plan
 * 
 * @author ruoyi
 * @date 2025-07-23
 */
public class NursingProjectPlan extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Integer id;

    /** 计划id */
    @Excel(name = "计划id")
    private Integer planId;

    /** 项目id */
    @Excel(name = "项目id")
    private Integer projectId;

    /** 计划执行时间 */
    @Excel(name = "计划执行时间")
    private String executeTime;

    /** 执行周期 0 天 1 周 2月 */
    @Excel(name = "执行周期 0 天 1 周 2月")
    private Integer executeCycle;

    /** 执行频次 */
    @Excel(name = "执行频次")
    private Integer executeFrequency;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }

    public void setPlanId(Integer planId) 
    {
        this.planId = planId;
    }

    public Integer getPlanId() 
    {
        return planId;
    }

    public void setProjectId(Integer projectId) 
    {
        this.projectId = projectId;
    }

    public Integer getProjectId() 
    {
        return projectId;
    }

    public void setExecuteTime(String executeTime) 
    {
        this.executeTime = executeTime;
    }

    public String getExecuteTime() 
    {
        return executeTime;
    }

    public void setExecuteCycle(Integer executeCycle) 
    {
        this.executeCycle = executeCycle;
    }

    public Integer getExecuteCycle() 
    {
        return executeCycle;
    }

    public void setExecuteFrequency(Integer executeFrequency) 
    {
        this.executeFrequency = executeFrequency;
    }

    public Integer getExecuteFrequency() 
    {
        return executeFrequency;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("planId", getPlanId())
            .append("projectId", getProjectId())
            .append("executeTime", getExecuteTime())
            .append("executeCycle", getExecuteCycle())
            .append("executeFrequency", getExecuteFrequency())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .toString();
    }
}
