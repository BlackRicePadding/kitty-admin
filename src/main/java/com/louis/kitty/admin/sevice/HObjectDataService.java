package com.louis.kitty.admin.sevice;


import com.louis.kitty.admin.core.service.CurdService;
import com.louis.kitty.admin.model.HObjectData;


public interface HObjectDataService extends CurdService<HObjectData> {

    /**
     * 获取人员的总数量
     * @param hObjectData
     * @return
     */
    int getCount(HObjectData hObjectData);
}
