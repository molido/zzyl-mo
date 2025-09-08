package com.zzyl.nursing.domain.dto;
import com.zzyl.nursing.domain.NursingProjectPlan;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.List;
@Schema(description = "护理计划信息")
@Data
public class NursingPlanDto {


    private Integer id;

    /**
     * 排序号
     */
    @Schema(title = "排序号")
    private Integer sortNo;

    /**
     * 计划名称
     */
    @Schema(title = "计划名称")
    private String planName;

    /**
     * 状态（0：禁用，1：启用）
     */
    @Schema(title = "状态（0：禁用，1：启用）")
    private Integer status;

    /**
     * 护理计划关联项目列表
     */
    List<NursingProjectPlan> projectPlans;
}