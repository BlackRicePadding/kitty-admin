package com.louis.kitty.admin.sevice;


import com.louis.kitty.admin.core.service.CurdService;
import com.louis.kitty.admin.model.BackHObject;

public interface BackHObjectService extends CurdService<BackHObject> {
    /**
     * 获取总个数
     * @param backHObject
     * @return
     */
    int getCount(BackHObject backHObject);
}
