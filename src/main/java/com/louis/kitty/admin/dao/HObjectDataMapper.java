package com.louis.kitty.admin.dao;

import com.louis.kitty.admin.model.HObjectData;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface HObjectDataMapper {

	/**
	 * 添加表单数据表
	 * @param record
	 * @return
	 */
    int add(HObjectData record);

    /**
     * 删除表单数据表
     * @param id
     * @return
     */
    int delete(Integer id);
    
    /**
     * 修改表单数据表
     * @param record
     * @return
     */
    int update(HObjectData record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    HObjectData findById(Integer id);

    /**
     * 基础分页查询
     * @param
     * @return
     */    
    List<HObjectData> findPage();

    /**
     * 根据PID查询数据
     * @param objId
     * @return
     */
    List<HObjectData> findPageByPid(@Param(value="objId") String objId);;

    /**
     * 根据具体条件检索
     * @param hObjectData
     * @return
     */
    List<HObjectData> findPageByData(HObjectData hObjectData);

    /**
     * 获取人员的总数量
     * @param hObjectData
     * @return
     */
    int getCount(HObjectData hObjectData);
}