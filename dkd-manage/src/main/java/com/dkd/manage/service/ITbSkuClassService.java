package com.dkd.manage.service;

import java.util.List;
import com.dkd.manage.domain.TbSkuClass;

/**
 * 商品类型Service接口
 * 
 * @author ruoyi
 * @date 2024-10-31
 */
public interface ITbSkuClassService 
{
    /**
     * 查询商品类型
     * 
     * @param classId 商品类型主键
     * @return 商品类型
     */
    public TbSkuClass selectTbSkuClassByClassId(Long classId);

    /**
     * 查询商品类型列表
     * 
     * @param tbSkuClass 商品类型
     * @return 商品类型集合
     */
    public List<TbSkuClass> selectTbSkuClassList(TbSkuClass tbSkuClass);

    /**
     * 新增商品类型
     * 
     * @param tbSkuClass 商品类型
     * @return 结果
     */
    public int insertTbSkuClass(TbSkuClass tbSkuClass);

    /**
     * 修改商品类型
     * 
     * @param tbSkuClass 商品类型
     * @return 结果
     */
    public int updateTbSkuClass(TbSkuClass tbSkuClass);

    /**
     * 批量删除商品类型
     * 
     * @param classIds 需要删除的商品类型主键集合
     * @return 结果
     */
    public int deleteTbSkuClassByClassIds(Long[] classIds);

    /**
     * 删除商品类型信息
     * 
     * @param classId 商品类型主键
     * @return 结果
     */
    public int deleteTbSkuClassByClassId(Long classId);
}
