package com.louis.kitty.admin.dao;

import com.louis.kitty.admin.model.HDictionry;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HDictionryMapper {

    /**
     * 添加字典表
     *
     * @param record
     * @return
     */
    int add(HDictionry record);

    /**
     * 删除字典表
     *
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 修改字典表
     *
     * @param record
     * @return
     */
    int update(HDictionry record);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    HDictionry findById(Integer id);

    /**
     * 基础分页查询
     *
     * @param
     * @return
     */
    List<HDictionry> findPage();

    /**
     * 根据具体信息查询
     * @param pid
     * @return
     */
    List<HDictionry> findPageByPid(@Param(value = "pid") String pid);
}