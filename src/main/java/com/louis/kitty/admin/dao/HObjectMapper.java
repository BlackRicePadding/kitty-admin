package com.louis.kitty.admin.dao;

import com.louis.kitty.admin.model.HObject;

import java.util.List;

public interface HObjectMapper {

	/**
	 * 添加表单项目表
	 * @param record
	 * @return
	 */
    int add(HObject record);

    /**
     * 删除表单项目表
     * @param id
     * @return
     */
    int delete(Integer id);
    
    /**
     * 修改表单项目表
     * @param record
     * @return
     */
    int update(HObject record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    HObject findById(Integer id);

    /**
     * 基础分页查询
     * @param
     * @return
     */    
    List<HObject> findPage();

    /**
     * 获取总个数
     * @param hObject
     * @return
     */
    int getCount(HObject hObject);

}