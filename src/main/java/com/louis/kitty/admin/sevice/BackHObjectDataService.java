package com.louis.kitty.admin.sevice;


import com.louis.kitty.admin.core.service.CurdService;
import com.louis.kitty.admin.model.BackHObjectData;
import com.louis.kitty.admin.model.HObject;

public interface BackHObjectDataService extends CurdService<BackHObjectData> {
    /**
     * 获取总个数
     * @param backHObjectData
     * @return
     */
    int getCount(BackHObjectData backHObjectData);
}
