package com.louis.kitty.admin.sevice.impl;

import java.util.Date;
import java.util.List;

import com.louis.kitty.admin.core.page.MybatisPageHelper;
import com.louis.kitty.admin.core.page.PageRequest;
import com.louis.kitty.admin.core.page.PageResult;
import com.louis.kitty.admin.dao.BackHObjectMapper;
import com.louis.kitty.admin.dao.HObjectMapper;
import com.louis.kitty.admin.model.BackHObject;
import com.louis.kitty.admin.model.HObject;
import com.louis.kitty.admin.sevice.HObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HObjectServiceImpl implements HObjectService {

    @Autowired
    private HObjectMapper hObjectMapper;
    @Autowired
    private BackHObjectMapper backHObjectMapper;

    @Override
    public int save(HObject record) {
        if (record.getId() == null || record.getId() == 0) {
            return hObjectMapper.add(record);
        } else {
            BackHObject backHObject = new BackHObject();
            backHObject.setObjId(record.getId());
            backHObject.setFormname(record.getFormname());
            backHObject.setFormcode("");
            backHObject.setContent(record.getContent());
            backHObject.setAddtime(new Date());
            backHObjectMapper.add(backHObject);
            return hObjectMapper.update(record);
        }
    }

    @Override
    public int delete(HObject record) {
        return hObjectMapper.delete(record.getId());
    }

    @Override
    public int delete(List<HObject> records) {
        for (HObject record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public HObject findById(Long id) {
        return hObjectMapper.findById(Integer.valueOf(String.valueOf(id)));
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest, hObjectMapper);
    }

    @Override
    public int getCount(HObject hObject) {
        return hObjectMapper.getCount(hObject);
    }

    @Override
    public List<HObject> findAll() {
        return hObjectMapper.findPage();
    }
}
