package com.dkd.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dkd.manage.mapper.TbSkuClassMapper;
import com.dkd.manage.domain.TbSkuClass;
import com.dkd.manage.service.ITbSkuClassService;

/**
 * 商品类型Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-10-31
 */
@Service
public class TbSkuClassServiceImpl implements ITbSkuClassService 
{
    @Autowired
    private TbSkuClassMapper tbSkuClassMapper;

    /**
     * 查询商品类型
     * 
     * @param classId 商品类型主键
     * @return 商品类型
     */
    @Override
    public TbSkuClass selectTbSkuClassByClassId(Long classId)
    {
        return tbSkuClassMapper.selectTbSkuClassByClassId(classId);
    }

    /**
     * 查询商品类型列表
     * 
     * @param tbSkuClass 商品类型
     * @return 商品类型
     */
    @Override
    public List<TbSkuClass> selectTbSkuClassList(TbSkuClass tbSkuClass)
    {
        return tbSkuClassMapper.selectTbSkuClassList(tbSkuClass);
    }

    /**
     * 新增商品类型
     * 
     * @param tbSkuClass 商品类型
     * @return 结果
     */
    @Override
    public int insertTbSkuClass(TbSkuClass tbSkuClass)
    {
        return tbSkuClassMapper.insertTbSkuClass(tbSkuClass);
    }

    /**
     * 修改商品类型
     * 
     * @param tbSkuClass 商品类型
     * @return 结果
     */
    @Override
    public int updateTbSkuClass(TbSkuClass tbSkuClass)
    {
        return tbSkuClassMapper.updateTbSkuClass(tbSkuClass);
    }

    /**
     * 批量删除商品类型
     * 
     * @param classIds 需要删除的商品类型主键
     * @return 结果
     */
    @Override
    public int deleteTbSkuClassByClassIds(Long[] classIds)
    {
        return tbSkuClassMapper.deleteTbSkuClassByClassIds(classIds);
    }

    /**
     * 删除商品类型信息
     * 
     * @param classId 商品类型主键
     * @return 结果
     */
    @Override
    public int deleteTbSkuClassByClassId(Long classId)
    {
        return tbSkuClassMapper.deleteTbSkuClassByClassId(classId);
    }
}
