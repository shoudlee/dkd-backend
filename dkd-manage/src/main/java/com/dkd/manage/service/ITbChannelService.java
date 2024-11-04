package com.dkd.manage.service;

import java.util.List;
import com.dkd.manage.domain.TbChannel;
import com.dkd.manage.domain.dto.ChannelConfigDto;
import com.dkd.manage.domain.vo.ChannelVo;

/**
 * 售货机货道Service接口
 * 
 * @author ruoyi
 * @date 2024-10-28
 */
public interface ITbChannelService 
{
    /**
     * 查询售货机货道
     * 
     * @param id 售货机货道主键
     * @return 售货机货道
     */
    public TbChannel selectTbChannelById(Long id);

    /**
     * 查询售货机货道列表
     * 
     * @param tbChannel 售货机货道
     * @return 售货机货道集合
     */
    public List<TbChannel> selectTbChannelList(TbChannel tbChannel);

    /**
     * 新增售货机货道
     * 
     * @param tbChannel 售货机货道
     * @return 结果
     */
    public int insertTbChannel(TbChannel tbChannel);

    /**
     * 修改售货机货道
     * 
     * @param tbChannel 售货机货道
     * @return 结果
     */
    public int updateTbChannel(TbChannel tbChannel);

    /**
     * 批量删除售货机货道
     * 
     * @param ids 需要删除的售货机货道主键集合
     * @return 结果
     */
    public int deleteTbChannelByIds(Long[] ids);

    /**
     * 删除售货机货道信息
     * 
     * @param id 售货机货道主键
     * @return 结果
     */
    public int deleteTbChannelById(Long id);

    ///查询所有货道绑定的特定skuid数量
    public int countChannelBySkuIds(Long[] skuIds);


    /**
     * 根据售货机编号查询货道列表
     *
     * @param innerCode
     * @return ChannelVo集合
     */
    List<ChannelVo> selectChannelVoListByInnerCode(String innerCode);

    /**
     * 货道关联商品
     * @param channelConfigDto
     * @return 结果
     */
    int setChannel(ChannelConfigDto channelConfigDto);
}
