package com.dkd.manage.service.impl;

import java.util.List;

import com.dkd.common.exception.ServiceException;
import com.dkd.common.utils.DateUtils;
import com.dkd.manage.domain.TbChannel;
import com.dkd.manage.mapper.TbChannelMapper;
import com.dkd.manage.service.ITbChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dkd.manage.mapper.TbSkuMapper;
import com.dkd.manage.domain.TbSku;
import com.dkd.manage.service.ITbSkuService;
import com.dkd.manage.domain.TbChannel;
/**
 * 商品Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-10-31
 */
@Service
public class TbSkuServiceImpl implements ITbSkuService 
{
    @Autowired
    private TbSkuMapper tbSkuMapper;
    @Autowired
    private TbChannelMapper tbChannelMapper;
    @Autowired
    private ITbChannelService tbChannelService;

    /**
     * 查询商品
     * 
     * @param skuId 商品主键
     * @return 商品
     */
    @Override
    public TbSku selectTbSkuBySkuId(Long skuId)
    {
        return tbSkuMapper.selectTbSkuBySkuId(skuId);
    }

    /**
     * 查询商品列表
     * 
     * @param tbSku 商品
     * @return 商品
     */
    @Override
    public List<TbSku> selectTbSkuList(TbSku tbSku)
    {
        return tbSkuMapper.selectTbSkuList(tbSku);
    }

    /**
     * 新增商品
     * 
     * @param tbSku 商品
     * @return 结果
     */
    @Override
    public int insertTbSku(TbSku tbSku)
    {
        tbSku.setCreateTime(DateUtils.getNowDate());
        return tbSkuMapper.insertTbSku(tbSku);
    }

    /**
     * 修改商品
     * 
     * @param tbSku 商品
     * @return 结果
     */
    @Override
    public int updateTbSku(TbSku tbSku)
    {
        tbSku.setUpdateTime(DateUtils.getNowDate());
        return tbSkuMapper.updateTbSku(tbSku);
    }

    /**
     * 批量删除商品
     * 
     * @param skuIds 需要删除的商品主键
     * @return 结果
     */
    @Override
    public int deleteTbSkuBySkuIds(Long[] skuIds)
    {
        int count = tbChannelService.countChannelBySkuIds(skuIds);
        if(count>0){
            throw new ServiceException("此商品被货道关联，无法删除");
        }
        return tbSkuMapper.deleteTbSkuBySkuIds(skuIds);
    }

    /**
     * 删除商品信息
     * 
     * @param skuId 商品主键
     * @return 结果
     */
    @Override
    public int deleteTbSkuBySkuId(Long skuId)
    {
        return tbSkuMapper.deleteTbSkuBySkuId(skuId);
    }

    /*
    * 批量插入
    * */
    @Override
    public int insertSkus(List<TbSku> skuList) {

        return tbSkuMapper.insertBatch(skuList);
    }


}
