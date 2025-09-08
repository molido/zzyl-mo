package com.zzyl.nursing.mapper;

import java.util.List;
import com.zzyl.nursing.domain.NursingProjectPlan;
import com.zzyl.nursing.domain.vo.NursingProjectPlanVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 护理计划和项目关联Mapper接口
 * 
 * @author ruoyi
 * @date 2025-07-23
 */
@Mapper
public interface NursingProjectPlanMapper 
{
    /**
     * 查询护理计划和项目关联
     * 
     * @param id 护理计划和项目关联主键
     * @return 护理计划和项目关联
     */
    public NursingProjectPlan selectNursingProjectPlanById(Integer id);

    /**
     * 查询护理计划和项目关联列表
     * 
     * @param nursingProjectPlan 护理计划和项目关联
     * @return 护理计划和项目关联集合
     */
    public List<NursingProjectPlan> selectNursingProjectPlanList(NursingProjectPlan nursingProjectPlan);

    /**
     * 新增护理计划和项目关联
     * 
     * @param nursingProjectPlan 护理计划和项目关联
     * @return 结果
     */
    public int insertNursingProjectPlan(NursingProjectPlan nursingProjectPlan);

    /**
     * 修改护理计划和项目关联
     * 
     * @param nursingProjectPlan 护理计划和项目关联
     * @return 结果
     */
    public int updateNursingProjectPlan(NursingProjectPlan nursingProjectPlan);

    /**
     * 删除护理计划和项目关联
     * 
     * @param id 护理计划和项目关联主键
     * @return 结果
     */
    public int deleteNursingProjectPlanById(Integer id);

    /**
     * 批量删除护理计划和项目关联
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteNursingProjectPlanByIds(Integer[] ids);

/**
 * 新增
 */
 int batchInsert(@Param("list") List<NursingProjectPlan> projectPlans, @Param("planId") Integer planId);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    List<NursingProjectPlanVo> selectByPlanId(Integer id);

    /**
     * 删除根据id
     * @param id
     */
    void deleteByPlanId(Integer id);
}
