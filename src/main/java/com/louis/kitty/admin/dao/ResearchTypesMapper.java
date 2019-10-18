package com.louis.kitty.admin.dao;

import java.util.List;

import com.louis.kitty.admin.model.ResearchTypes;

/**
 * ---------------------------
 * 科研类型表 (ResearchTypesMapper)         
 * ---------------------------
 */
public interface ResearchTypesMapper {

	/**
	 * 添加科研类型表
	 * @param record
	 * @return
	 */
    int add(ResearchTypes record);

    /**
     * 删除科研类型表
     * @param id
     * @return
     */
    int delete(Integer id);
    
    /**
     * 修改科研类型表
     * @param record
     * @return
     */
    int update(ResearchTypes record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    ResearchTypes findById(Integer id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<ResearchTypes> findPage();
    
}