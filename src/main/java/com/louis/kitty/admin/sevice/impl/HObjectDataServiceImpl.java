package com.louis.kitty.admin.sevice.impl;

import java.util.Date;
import java.util.List;

import com.louis.kitty.admin.core.page.ColumnFilter;
import com.louis.kitty.admin.core.page.MybatisPageHelper;
import com.louis.kitty.admin.core.page.PageRequest;
import com.louis.kitty.admin.core.page.PageResult;
import com.louis.kitty.admin.dao.BackHObjectDataMapper;
import com.louis.kitty.admin.dao.HObjectDataMapper;
import com.louis.kitty.admin.model.BackHObjectData;
import com.louis.kitty.admin.model.HObjectData;
import com.louis.kitty.admin.sevice.HObjectDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HObjectDataServiceImpl implements HObjectDataService {

    @Autowired
    private HObjectDataMapper hObjectDataMapper;
    @Autowired
    private BackHObjectDataMapper backHObjectDataMapper;

    @Override
    public int save(HObjectData record) {
        if (record.getId() == null || record.getId() == 0) {
            return hObjectDataMapper.add(record);
        } else {
            BackHObjectData backHObjectData = new BackHObjectData();
            backHObjectData.setObjDataId(record.getId());
            backHObjectData.setContent(record.getContent());
            backHObjectData.setAddtime(new Date());
            backHObjectDataMapper.add(backHObjectData);
            return hObjectDataMapper.update(record);
        }
    }

    @Override
    public int delete(HObjectData record) {
        return hObjectDataMapper.delete(record.getId());
    }

    @Override
    public int delete(List<HObjectData> records) {
        for (HObjectData record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public HObjectData findById(Long id) {
        return hObjectDataMapper.findById(Integer.valueOf(String.valueOf(id)));
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        String objId = getColumnFilterValue(pageRequest, "objId");
        String content = getColumnFilterValue(pageRequest, "content");
        if (objId != null) {
            if (null != content && content != "" && content.trim().length() > 0) {
                HObjectData hObjectData = new HObjectData();
                hObjectData.setObjid(Integer.valueOf(objId));
                hObjectData.setContent(content);
                return MybatisPageHelper.findPage(pageRequest, hObjectDataMapper, "findPageByData", hObjectData);
            }else{
                return MybatisPageHelper.findPage(pageRequest, hObjectDataMapper, "findPageByPid", objId);
            }

        } else {
            return MybatisPageHelper.findPage(pageRequest, hObjectDataMapper);
        }
    }

    /**
     * 获取过滤字段的值
     *
     * @param filterName
     * @return
     */
    public String getColumnFilterValue(PageRequest pageRequest, String filterName) {
        String value = null;
        ColumnFilter columnFilter = pageRequest.getColumnFilter(filterName);
        if (columnFilter != null) {
            value = columnFilter.getValue();
        }
        return value;
    }

    @Override
    public int getCount(HObjectData hObjectData) {
        return hObjectDataMapper.getCount(hObjectData);
    }
}
