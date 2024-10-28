package com.dkd.manage.service.impl;

import java.util.List;
import com.dkd.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dkd.manage.mapper.TbChannelMapper;
import com.dkd.manage.domain.TbChannel;
import com.dkd.manage.service.ITbChannelService;

/**
 * 售货机货道Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-10-28
 */
@Service
public class TbChannelServiceImpl implements ITbChannelService 
{
    @Autowired
    private TbChannelMapper tbChannelMapper;

    /**
     * 查询售货机货道
     * 
     * @param id 售货机货道主键
     * @return 售货机货道
     */
    @Override
    public TbChannel selectTbChannelById(Long id)
    {
        return tbChannelMapper.selectTbChannelById(id);
    }

    /**
     * 查询售货机货道列表
     * 
     * @param tbChannel 售货机货道
     * @return 售货机货道
     */
    @Override
    public List<TbChannel> selectTbChannelList(TbChannel tbChannel)
    {
        return tbChannelMapper.selectTbChannelList(tbChannel);
    }

    /**
     * 新增售货机货道
     * 
     * @param tbChannel 售货机货道
     * @return 结果
     */
    @Override
    public int insertTbChannel(TbChannel tbChannel)
    {
        tbChannel.setCreateTime(DateUtils.getNowDate());
        return tbChannelMapper.insertTbChannel(tbChannel);
    }

    /**
     * 修改售货机货道
     * 
     * @param tbChannel 售货机货道
     * @return 结果
     */
    @Override
    public int updateTbChannel(TbChannel tbChannel)
    {
        tbChannel.setUpdateTime(DateUtils.getNowDate());
        return tbChannelMapper.updateTbChannel(tbChannel);
    }

    /**
     * 批量删除售货机货道
     * 
     * @param ids 需要删除的售货机货道主键
     * @return 结果
     */
    @Override
    public int deleteTbChannelByIds(Long[] ids)
    {
        return tbChannelMapper.deleteTbChannelByIds(ids);
    }

    /**
     * 删除售货机货道信息
     * 
     * @param id 售货机货道主键
     * @return 结果
     */
    @Override
    public int deleteTbChannelById(Long id)
    {
        return tbChannelMapper.deleteTbChannelById(id);
    }
}
