package com.louis.kitty.admin.sevice.impl;

import java.util.Date;
import java.util.List;

import com.louis.kitty.admin.core.page.ColumnFilter;
import com.louis.kitty.admin.core.page.MybatisPageHelper;
import com.louis.kitty.admin.core.page.PageRequest;
import com.louis.kitty.admin.core.page.PageResult;
import com.louis.kitty.admin.dao.BackPeopleDataMapper;
import com.louis.kitty.admin.model.BackPeopleData;
import com.louis.kitty.admin.model.ResearchFollow;
import com.louis.kitty.admin.sevice.PeopleDataService;
import com.louis.kitty.admin.sevice.ResearchFollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.louis.kitty.admin.model.PeopleData;
import com.louis.kitty.admin.dao.PeopleDataMapper;

@Service
public class PeopleDataServiceImpl implements PeopleDataService {

    @Autowired
    private PeopleDataMapper peopleDataMapper;

    @Autowired
    private ResearchFollowService researchFollowService;

    @Autowired
    private BackPeopleDataMapper backPeopleDataMapper;

    @Override
    public int save(PeopleData record) {
        //先备份
        BackPeopleData backPeopleData = new BackPeopleData();
        backPeopleData.setAddtime(new Date());
        backPeopleData.setContent(record.getContent());
        backPeopleData.setFalg(record.getFalg());
        backPeopleData.setFollowid(record.getFollowid());
        backPeopleData.setHobjectid(record.getHobjectid());
        backPeopleData.setObjid(record.getObjid());
        backPeopleData.setRemarks(record.getRemarks());
        backPeopleData.setPeopleid(record.getPeopleid());
        backPeopleDataMapper.add(backPeopleData);
        if (record.getId() == null || record.getId() == 0) {
            record.setAddtime(new Date());
            return peopleDataMapper.add(record);
        }
        return peopleDataMapper.update(record);
    }

    @Override
    public int delete(PeopleData record) {
        return peopleDataMapper.delete(record.getId());
    }

    @Override
    public int delete(List<PeopleData> records) {
        for (PeopleData record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public PeopleData findById(Long id) {
        return peopleDataMapper.findById(Integer.valueOf(String.valueOf(id)));
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {

        return MybatisPageHelper.findPage(pageRequest, peopleDataMapper);

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
    public int getEntityTotal(PeopleData peopleData) {
        return peopleDataMapper.getEntityTotal(peopleData);
    }

    @Override
    public PeopleData findByObjEntity(PeopleData peopleData) {
        return peopleDataMapper.findByObjEntity(peopleData);
    }
}
