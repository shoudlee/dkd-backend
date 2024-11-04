package com.dkd.manage.mapper;

import java.util.List;
import com.dkd.manage.domain.TbChannel;
import com.dkd.manage.domain.vo.ChannelVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 售货机货道Mapper接口
 * 
 * @author ruoyi
 * @date 2024-10-28
 */
public interface TbChannelMapper 
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
     * 删除售货机货道
     * 
     * @param id 售货机货道主键
     * @return 结果
     */
    public int deleteTbChannelById(Long id);

    /**
     * 批量删除售货机货道
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbChannelByIds(Long[] ids);


    public int countChannelBySkuIds(Long[] skuIds);

    /**
     * 根据售货机编号查询货道列表
     *
     * @param innerCode
     * @return ChannelVo集合
     */
    List<ChannelVo> selectChannelVoListByInnerCode(String innerCode);

    /**
     * 根据售货机编号和货道编号查询货道信息
     * @param innerCode
     * @param channelCode
     * @return 售货机货道
     */
    @Select("select * from tb_channel where inner_code =#{innerCode} and channel_code=#{channelCode}")
    TbChannel getChannelInfo(@Param("innerCode") String innerCode, @Param("channelCode") String channelCode);

    /**
     * 批量修改货道
     * @param list
     * @return 结果
     */
    int batchUpdateChannel(List<TbChannel> list);
}
