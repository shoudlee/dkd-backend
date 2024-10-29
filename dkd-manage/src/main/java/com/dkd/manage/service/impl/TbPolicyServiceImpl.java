package com.dkd.manage.service.impl;

import java.util.List;
import com.dkd.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dkd.manage.mapper.TbPolicyMapper;
import com.dkd.manage.domain.TbPolicy;
import com.dkd.manage.service.ITbPolicyService;

/**
 * 策略管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-10-29
 */
@Service
public class TbPolicyServiceImpl implements ITbPolicyService 
{
    @Autowired
    private TbPolicyMapper tbPolicyMapper;

    /**
     * 查询策略管理
     * 
     * @param policyId 策略管理主键
     * @return 策略管理
     */
    @Override
    public TbPolicy selectTbPolicyByPolicyId(Long policyId)
    {
        return tbPolicyMapper.selectTbPolicyByPolicyId(policyId);
    }

    /**
     * 查询策略管理列表
     * 
     * @param tbPolicy 策略管理
     * @return 策略管理
     */
    @Override
    public List<TbPolicy> selectTbPolicyList(TbPolicy tbPolicy)
    {
        return tbPolicyMapper.selectTbPolicyList(tbPolicy);
    }

    /**
     * 新增策略管理
     * 
     * @param tbPolicy 策略管理
     * @return 结果
     */
    @Override
    public int insertTbPolicy(TbPolicy tbPolicy)
    {
        tbPolicy.setCreateTime(DateUtils.getNowDate());
        return tbPolicyMapper.insertTbPolicy(tbPolicy);
    }

    /**
     * 修改策略管理
     * 
     * @param tbPolicy 策略管理
     * @return 结果
     */
    @Override
    public int updateTbPolicy(TbPolicy tbPolicy)
    {
        tbPolicy.setUpdateTime(DateUtils.getNowDate());
        return tbPolicyMapper.updateTbPolicy(tbPolicy);
    }

    /**
     * 批量删除策略管理
     * 
     * @param policyIds 需要删除的策略管理主键
     * @return 结果
     */
    @Override
    public int deleteTbPolicyByPolicyIds(Long[] policyIds)
    {
        return tbPolicyMapper.deleteTbPolicyByPolicyIds(policyIds);
    }

    /**
     * 删除策略管理信息
     * 
     * @param policyId 策略管理主键
     * @return 结果
     */
    @Override
    public int deleteTbPolicyByPolicyId(Long policyId)
    {
        return tbPolicyMapper.deleteTbPolicyByPolicyId(policyId);
    }
}
