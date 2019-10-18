package com.louis.kitty.admin.dao;

import java.util.List;

import com.louis.kitty.admin.model.BackPeopleData;

public interface BackPeopleDataMapper {

	/**
	 * 添加人员数据表-备份
	 * @param record
	 * @return
	 */
    int add(BackPeopleData record);

    /**
     * 删除人员数据表-备份
     * @param id
     * @return
     */
    int delete(Integer id);
    
    /**
     * 修改人员数据表-备份
     * @param record
     * @return
     */
    int update(BackPeopleData record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    BackPeopleData findById(Integer id);

    /**
     * 基础分页查询
     * @param
     * @return
     */    
    List<BackPeopleData> findPage();
    
}