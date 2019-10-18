package com.louis.kitty.admin.dao;

import java.util.List;
import java.util.Map;

import com.louis.kitty.admin.model.ResearchFollow;

/**
 * ---------------------------
 * 项目周期表 (ResearchFollowMapper)
 * ---------------------------
 */
public interface ResearchFollowMapper {

	/**
	 * 添加项目周期表
	 * @param record
	 * @return
	 */
    int add(ResearchFollow record);

    /**
     * 删除项目周期表
     * @param id
     * @return
     */
    int delete(Integer id);
    
    /**
     * 修改项目周期表
     * @param record
     * @return
     */
    int update(ResearchFollow record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    ResearchFollow findById(Integer id);

    /**
     * 基础分页查询
     * @param
     * @return
     */    
    List<ResearchFollow> findPage();

    /**
     * 根据父类ID去查询
     * @param researchFollow
     * @return
     */
    List<ResearchFollow> followList(ResearchFollow researchFollow);
    /**
     * 获取最大的ID
     * @return
     */
    ResearchFollow maxId();

}