package com.louis.kitty.admin.dao;

import java.util.List;

import com.louis.kitty.admin.model.ResearchPeople;

/**
 * ---------------------------
 * 随访人员表 (ResearchPeopleMapper)         
 * ---------------------------
 */
public interface ResearchPeopleMapper {

    /**
     * 按照条件检索总个数
     * @param researchPeople
     * @return
     */
    int getTotal(ResearchPeople researchPeople);
	/**
	 * 添加随访人员表
	 * @param record
	 * @return
	 */
    int add(ResearchPeople record);

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
    int update(ResearchPeople record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    ResearchPeople findById(Integer id);

    /**
     * 基础分页查询
     * @param
     * @return
     */    
    List<ResearchPeople> findPage();

    /**
     * 按照条件检索
     * @return
     */
    List<ResearchPeople> findByFalgPage(ResearchPeople researchPeople);

}