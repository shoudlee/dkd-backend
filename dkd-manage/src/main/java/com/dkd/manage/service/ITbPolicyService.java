package com.dkd.manage.service;

import java.util.List;
import com.dkd.manage.domain.TbPolicy;

/**
 * 策略管理Service接口
 * 
 * @author ruoyi
 * @date 2024-10-29
 */
public interface ITbPolicyService 
{
    /**
     * 查询策略管理
     * 
     * @param policyId 策略管理主键
     * @return 策略管理
     */
    public TbPolicy selectTbPolicyByPolicyId(Long policyId);

    /**
     * 查询策略管理列表
     * 
     * @param tbPolicy 策略管理
     * @return 策略管理集合
     */
    public List<TbPolicy> selectTbPolicyList(TbPolicy tbPolicy);

    /**
     * 新增策略管理
     * 
     * @param tbPolicy 策略管理
     * @return 结果
     */
    public int insertTbPolicy(TbPolicy tbPolicy);

    /**
     * 修改策略管理
     * 
     * @param tbPolicy 策略管理
     * @return 结果
     */
    public int updateTbPolicy(TbPolicy tbPolicy);

    /**
     * 批量删除策略管理
     * 
     * @param policyIds 需要删除的策略管理主键集合
     * @return 结果
     */
    public int deleteTbPolicyByPolicyIds(Long[] policyIds);

    /**
     * 删除策略管理信息
     * 
     * @param policyId 策略管理主键
     * @return 结果
     */
    public int deleteTbPolicyByPolicyId(Long policyId);
}
