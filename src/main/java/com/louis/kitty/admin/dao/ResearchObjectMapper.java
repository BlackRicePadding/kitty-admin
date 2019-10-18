package com.louis.kitty.admin.dao;

import java.util.HashMap;
import java.util.List;

import com.louis.kitty.admin.model.ResearchObject;

/**
 * ---------------------------
 * 科研项目表 (ResearchObjectMapper)         
 * ---------------------------
 */
public interface ResearchObjectMapper {

	/**
	 * 添加科研项目表
	 * @param record
	 * @return
	 */
    int add(ResearchObject record);

    /**
     * 删除科研项目表
     * @param id
     * @return
     */
    int delete(Integer id);
    
    /**
     * 修改科研项目表
     * @param record
     * @return
     */
    int update(ResearchObject record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    ResearchObject findById(Integer id);

    /**
     * 基础分页查询
     * @param
     * @return
     */    
    List<ResearchObject> findPage();

    /**
     * 获取最大的ID
     * @param
     * @return
     */
    ResearchObject getMaxID();
}