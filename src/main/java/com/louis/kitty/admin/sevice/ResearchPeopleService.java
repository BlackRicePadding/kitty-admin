package com.louis.kitty.admin.sevice;

import com.louis.kitty.admin.core.service.CurdService;
import com.louis.kitty.admin.model.ResearchPeople;

import java.util.List;
import java.util.Map;


public interface ResearchPeopleService extends CurdService<ResearchPeople> {

    /**
     * 批量修改用户状态
     * @param ids
     * @return
     */
    int updateFalg(String ids);

    /**
     * 查询每个人，具体的周期
     * @param researchPeople
     * @return
     */
    List<Map<String,Object>> findFollowById(ResearchPeople researchPeople);

    /**
     * 查询这个人具体的周期信息，，，，博包含是否选中
     * @param researchPeople
     * @return
     */
    List<Map<String,Object>> findFollowSortById(ResearchPeople researchPeople);

}
