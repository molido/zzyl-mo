package com.zzyl.nursing.service.impl;

import com.zzyl.common.utils.DateUtils;
import com.zzyl.nursing.domain.NursingPlan;
import com.zzyl.nursing.domain.dto.NursingPlanDto;
import com.zzyl.nursing.domain.vo.NursingPlanVo;
import com.zzyl.nursing.domain.vo.NursingProjectPlanVo;
import com.zzyl.nursing.domain.vo.NursingProjectVo;
import com.zzyl.nursing.mapper.NursingPlanMapper;
import com.zzyl.nursing.mapper.NursingProjectPlanMapper;
import com.zzyl.nursing.service.INursingPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;


/**
 * 护理计划Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-07-21
 */
@Service
@RequiredArgsConstructor
public class NursingPlanServiceImpl implements INursingPlanService
{

    private final NursingPlanMapper nursingPlanMapper;
    private final NursingProjectPlanMapper nursingProjectPlanMapper;

    /**
     * 查询护理计划
     * 
     * @param id 护理计划主键
     * @return 护理计划
     */
    @Override
    public NursingPlanVo selectNursingPlanById(Integer id)
    {
        //查询护理计划
        NursingPlan nursingPlan = nursingPlanMapper.selectNursingPlanById(id);
        //给返回的NursingPlanVo赋值
        NursingPlanVo nursingPlanVo = new NursingPlanVo();
        BeanUtils.copyProperties(nursingPlan,nursingPlanVo);
        ////根据护理计划ID查询护理项目的关系
        List<NursingProjectPlanVo> list = nursingProjectPlanMapper.selectByPlanId(id);
        nursingPlanVo.setProjectPlans(list);
        return nursingPlanVo;
    }

    /**
     * 查询护理计划列表
     * 
     * @param nursingPlan 护理计划
     * @return 护理计划
     */
    @Override
    public List<NursingPlan> selectNursingPlanList(NursingPlan nursingPlan)
    {
        return nursingPlanMapper.selectNursingPlanList(nursingPlan);
    }

    /**
     * 新增护理计划
     *
     */
    @Override
    public int insertNursingPlan(NursingPlanDto dto)
    {
        //保存护理计划//属性拷贝
       NursingPlan nursingPlan = new NursingPlan();
        BeanUtils.copyProperties(dto,nursingPlan);
        nursingPlan.setCreateTime(DateUtils.getNowDate());
        nursingPlanMapper.insertNursingPlan(nursingPlan);
        //批量保存护理项目计划关系
        int count = nursingProjectPlanMapper.batchInsert(dto.getProjectPlans(), nursingPlan.getId());
        return count == 0 ? 0 : 1;
    }

    /**
     * 修改护理计划
     * 
     * @param nursingPlan 护理计划
     * @return 结果
     */
    @Override
    public int updateNursingPlan(NursingPlanDto dto)
    {
        //执行修改护理计划表
        NursingPlan nursingPlan = new NursingPlan();
        BeanUtils.copyProperties(dto, nursingPlan);

        int count = nursingPlanMapper.updateNursingPlan(nursingPlan);
        if (!CollectionUtils.isEmpty(dto.getProjectPlans())) {
            //删除原有的的护理计划项目关系表的对应数据
            nursingProjectPlanMapper.deleteByPlanId(nursingPlan.getId());
            //新增护理计划项目关系表的对应数据
            count = nursingProjectPlanMapper.batchInsert(dto.getProjectPlans(), nursingPlan.getId());
        }
        return count == 0? 0:1;
    }

    /**
     * 批量删除护理计划
     * 
     * @param id 需要删除的护理计划主键
     * @return 结果
     */
    @Override
    public int deleteNursingPlanByIds(Integer id)
    {
        try {
            //删除关系
            //删除护理计划与护理项目的关系
            nursingProjectPlanMapper.deleteByPlanId(id);
            return nursingPlanMapper.deleteNursingPlanById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 删除护理计划信息
     * 
     * @param id 护理计划主键
     * @return 结果
     */
    @Override
    public int deleteNursingPlanById(Integer id)
    {
        return nursingPlanMapper.deleteNursingPlanById(id);
    }
}
