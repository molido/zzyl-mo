package com.zzyl.nursing.domain.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class NursingProjectVo {

    /**
     * 项目名称
     */
    private String label;

    /**
     * 项目ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Integer value;
}