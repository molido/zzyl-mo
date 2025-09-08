package com.zzyl.nursing.domain.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
@Schema(description = "护理计划和项目的关系")
@Data
public class NursingProjectPlanVo {

    /** 项目id */
    @Schema(title = "项目id")
    private String projectId;

    /** $column.columnComment */
    private Integer id;

    /** 计划id */
    @Schema(title = "计划id")
    private Integer planId;

    /** 计划执行时间 */
    @Schema(title = "计划执行时间")
    private String executeTime;

    /** 执行周期 0 天 1 周 2月 */
    @JsonSerialize(using = ToStringSerializer.class)
    @Schema(title = "执行周期 0 天 1 周 2月")
    private Integer executeCycle;

    /** 执行频次 */
    @Schema(title = "执行频次")
    private Integer executeFrequency;
}