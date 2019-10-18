package com.louis.kitty.admin.dao;

import com.louis.kitty.admin.model.BackHObjectData;
import com.louis.kitty.admin.model.HObject;

import java.util.List;

public interface BackHObjectDataMapper {

	/**
	 * 添加表单数据表_备份表
	 * @param record
	 * @return
	 */
    int add(BackHObjectData record);

    /**
     * 删除表单数据表_备份表
     * @param id
     * @return
     */
    int delete(Integer id);
    
    /**
     * 修改表单数据表_备份表
     * @param record
     * @return
     */
    int update(BackHObjectData record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    BackHObjectData findById(Integer id);

    /**
     * 基础分页查询
     * @param
     * @return
     */    
    List<BackHObjectData> findPage();
    /**
     * 获取总个数
     * @param backHObjectData
     * @return
     */
    int getCount(BackHObjectData backHObjectData);
}