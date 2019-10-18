package com.louis.kitty.admin.sevice;

import com.louis.kitty.admin.core.service.CurdService;
import com.louis.kitty.admin.model.ResearchFollow;

import java.util.List;
import java.util.Map;

public interface ResearchFollowService extends CurdService<ResearchFollow> {

    /**
     * 修改内容
     * @param researchFollow
     * @return
     */
    int updateContent(ResearchFollow researchFollow);

    /**
     * 根据父类ID去查询
     * @param researchFollow
     * @return
     */
    List<Map<String,Object>> followList(ResearchFollow researchFollow);

    /**
     * 删除项目周期
     * @param researchFollow
     * @return
     */
    int deleteByObjid(ResearchFollow researchFollow);

    /**
     * 获取最大的ID
     * @return
     */
    ResearchFollow maxId();

    /**
     * 获取周期中选择的值
     * @param researchFollow
     * @return
     */
    List<Map<String,Object>>  findAllFollowContent(ResearchFollow researchFollow);

}
