package com.louis.kitty.admin.dao;

import java.util.List;

import com.louis.kitty.admin.model.PeopleData;

public interface PeopleDataMapper {

	/**
	 * 添加人员数据表
	 * @param record
	 * @return
	 */
    int add(PeopleData record);

    /**
     * 删除人员数据表
     * @param id
     * @return
     */
    int delete(Integer id);
    
    /**
     * 修改人员数据表
     * @param record
     * @return
     */
    int update(PeopleData record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    PeopleData findById(Integer id);

    /**
     * 基础分页查询
     * @param
     * @return
     */    
    List<PeopleData> findPage();

    /**
     * 基础分页查询
     * @param
     * @return
     */
    List<PeopleData> findByEntityPage(PeopleData peopleData);

    /**
     * 根据条件查询出符合的人员个数
     * @param peopleData
     * @return
     */
    int getEntityTotal(PeopleData peopleData);

    /**
     * 根据项目id来查询具体数据
     * @param peopleData
     * @return
     */
    PeopleData findByObjEntity(PeopleData peopleData);


}