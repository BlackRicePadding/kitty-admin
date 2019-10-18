package com.louis.kitty.admin.sevice;

import com.louis.kitty.admin.core.service.CurdService;
import com.louis.kitty.admin.model.PeopleData;


public interface PeopleDataService extends CurdService<PeopleData> {

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
