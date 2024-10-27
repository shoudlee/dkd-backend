package com.dkd.manage.mapper;

import java.util.List;
import com.dkd.manage.domain.TbEmp;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * 工单员工Mapper接口
 * 
 * @author ruoyi
 * @date 2024-10-27
 */
public interface TbEmpMapper 
{
    /**
     * 查询工单员工
     * 
     * @param id 工单员工主键
     * @return 工单员工
     */
    public TbEmp selectTbEmpById(Long id);

    /**
     * 查询工单员工列表
     * 
     * @param tbEmp 工单员工
     * @return 工单员工集合
     */
    public List<TbEmp> selectTbEmpList(TbEmp tbEmp);

    /**
     * 新增工单员工
     * 
     * @param tbEmp 工单员工
     * @return 结果
     */
    public int insertTbEmp(TbEmp tbEmp);

    /**
     * 修改工单员工
     * 
     * @param tbEmp 工单员工
     * @return 结果
     */
    public int updateTbEmp(TbEmp tbEmp);

    /**
     * 删除工单员工
     * 
     * @param id 工单员工主键
     * @return 结果
     */
    public int deleteTbEmpById(Long id);

    /**
     * 批量删除工单员工
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbEmpByIds(Long[] ids);

    /**
     * 根据区域id修改区域名称
     * @param regionName
     * @param regionId
     * @return 结果
     */
    @Update("update tb_emp set region_name=#{regionName} where region_id=#{regionId}")
    int updateByRegionId(@Param("regionName") String regionName, @Param("regionId") Long regionId);
}
