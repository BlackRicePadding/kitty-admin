package com.louis.kitty.admin.sevice;


import com.louis.kitty.admin.core.service.CurdService;
import com.louis.kitty.admin.model.HObject;

import java.util.List;


public interface HObjectService extends CurdService<HObject> {

    /**
     * 获取总个数
     * @param hObject
     * @return
     */
    int getCount(HObject hObject);

    /**
     * 获取全部用户
     * @return
     */
    List<HObject> findAll();
}
