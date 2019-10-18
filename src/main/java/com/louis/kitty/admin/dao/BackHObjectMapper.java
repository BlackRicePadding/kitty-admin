package com.louis.kitty.admin.dao;


import com.louis.kitty.admin.model.BackHObject;
import com.louis.kitty.admin.model.HObject;

import java.util.List;

public interface BackHObjectMapper {

	/**
	 * 添加表单项目表_备份数据
	 * @param record
	 * @return
	 */
    int add(BackHObject record);

    /**
     * 删除表单项目表_备份数据
     * @param id
     * @return
     */
    int delete(Integer id);
    
    /**
     * 修改表单项目表_备份数据
     * @param record
     * @return
     */
    int update(BackHObject record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    BackHObject findById(Integer id);

    /**
     * 基础分页查询
     * @param
     * @return
     */    
    List<BackHObject> findPage();
    /**
     * 获取总个数
     * @param backHObject
     * @return
     */
    int getCount(BackHObject backHObject);
}