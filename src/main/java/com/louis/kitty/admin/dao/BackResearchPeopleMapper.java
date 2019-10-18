package com.louis.kitty.admin.dao;

import java.util.List;

import com.louis.kitty.admin.model.BackResearchPeople;

/**
 * ---------------------------
 * 随访人员表 (BackResearchPeopleMapper)
 * ---------------------------
 */
public interface BackResearchPeopleMapper {

	/**
	 * 添加随访人员表
	 * @param record
	 * @return
	 */
    int add(BackResearchPeople record);

    /**
     * 删除随访人员表
     * @param id
     * @return
     */
    int delete(Integer id);
    
    /**
     * 修改随访人员表
     * @param record
     * @return
     */
    int update(BackResearchPeople record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    BackResearchPeople findById(Integer id);

    /**
     * 基础分页查询
     * @param
     * @return
     */    
    List<BackResearchPeople> findPage();
    
}