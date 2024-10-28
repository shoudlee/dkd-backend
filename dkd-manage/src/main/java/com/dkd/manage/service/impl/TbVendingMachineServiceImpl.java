package com.dkd.manage.service.impl;

import java.util.List;
import com.dkd.common.utils.DateUtils;
import com.dkd.common.utils.uuid.UUIDUtils;
import com.dkd.manage.domain.Node;
import com.dkd.manage.domain.TbChannel;
import com.dkd.manage.domain.TbVmType;
import com.dkd.manage.mapper.NodeMapper;
import com.dkd.manage.mapper.TbChannelMapper;
import com.dkd.manage.mapper.TbVmTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dkd.manage.mapper.TbVendingMachineMapper;
import com.dkd.manage.domain.TbVendingMachine;
import com.dkd.manage.service.ITbVendingMachineService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 设备Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-10-28
 */
@Service
public class TbVendingMachineServiceImpl implements ITbVendingMachineService 
{
    @Autowired
    private TbVendingMachineMapper tbVendingMachineMapper;
    @Autowired
    private NodeMapper tbNodeMapper;
    @Autowired
    private TbChannelMapper tbChannelMapper;
    @Autowired
    private TbVmTypeMapper tbVmTypeMapper;

    /**
     * 查询设备
     * 
     * @param id 设备主键
     * @return 设备
     */
    @Override
    public TbVendingMachine selectTbVendingMachineById(Long id)
    {
        return tbVendingMachineMapper.selectTbVendingMachineById(id);
    }

    /**
     * 查询设备列表
     * 
     * @param tbVendingMachine 设备
     * @return 设备
     */
    @Override
    public List<TbVendingMachine> selectTbVendingMachineList(TbVendingMachine tbVendingMachine)
    {
        return tbVendingMachineMapper.selectTbVendingMachineList(tbVendingMachine);
    }

    /**
     * 新增设备
     * 
     * @param tbVendingMachine 设备
     * @return 结果
     */
    @Override
    @Transactional
    public int insertTbVendingMachine(TbVendingMachine tbVendingMachine)
    {
        TbVendingMachine newTbVendingMachine = new TbVendingMachine();
        String innerCode = UUIDUtils.getUUID();
        newTbVendingMachine.setInnerCode(innerCode);
        // 查询tb_node获取详细地址等
        Node _node = tbNodeMapper.selectNodeById(tbVendingMachine.getNodeId());
        newTbVendingMachine.setAddr(_node.getAddress());
        newTbVendingMachine.setBusinessType(_node.getBusinessType());
        newTbVendingMachine.setRegionId(_node.getRegionId());
        newTbVendingMachine.setPartnerId(_node.getPartnerId());
        newTbVendingMachine.setNodeId(tbVendingMachine.getNodeId());
        newTbVendingMachine.setVmTypeId(tbVendingMachine.getVmTypeId());
        newTbVendingMachine.setCreateTime(DateUtils.getNowDate());
        newTbVendingMachine.setUpdateTime(DateUtils.getNowDate());
        // 插入tb_vending_machine
        int result = tbVendingMachineMapper.insertTbVendingMachine(newTbVendingMachine);
        // 查询tb_vm_type获取row,column等
        TbVmType _type = tbVmTypeMapper.selectTbVmTypeById(tbVendingMachine.getVmTypeId());
        int row = _type.getVmRow().intValue();
        int column = _type.getVmCol().intValue();
        Long maxCapacity = _type.getChannelMaxCapacity();
        // 插入tb_channel
        for (int i = 0; i<row; i++){
            for (int j = 0; j<column; j++){
                TbChannel _chanel = TbChannel.builder()
                        .channelCode((i+1) + "-" + (j+1))
                        .innerCode(innerCode)
                        .vmId(newTbVendingMachine.getId())
                        .maxCapacity(maxCapacity)
                        .build();
                _chanel.setCreateTime(DateUtils.getNowDate());
                _chanel.setUpdateTime(DateUtils.getNowDate());
                tbChannelMapper.insertTbChannel(_chanel);
            }
        }
        return result;
    }

    /**
     * 修改设备
     * 
     * @param tbVendingMachine 设备
     * @return 结果
     */
    @Override
    public int updateTbVendingMachine(TbVendingMachine tbVendingMachine)
    {
        tbVendingMachine.setUpdateTime(DateUtils.getNowDate());
        return tbVendingMachineMapper.updateTbVendingMachine(tbVendingMachine);
    }

    /**
     * 批量删除设备
     * 
     * @param ids 需要删除的设备主键
     * @return 结果
     */
    @Override
    public int deleteTbVendingMachineByIds(Long[] ids)
    {
        return tbVendingMachineMapper.deleteTbVendingMachineByIds(ids);
    }

    /**
     * 删除设备信息
     * 
     * @param id 设备主键
     * @return 结果
     */
    @Override
    public int deleteTbVendingMachineById(Long id)
    {
        return tbVendingMachineMapper.deleteTbVendingMachineById(id);
    }
}
