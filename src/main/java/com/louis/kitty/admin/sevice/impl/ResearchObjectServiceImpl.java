package com.louis.kitty.admin.sevice.impl;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.louis.kitty.admin.core.page.MybatisPageHelper;
import com.louis.kitty.admin.core.page.PageRequest;
import com.louis.kitty.admin.core.page.PageResult;
import com.louis.kitty.admin.model.FollowOne;
import com.louis.kitty.admin.model.FollowTwo;
import com.louis.kitty.admin.model.ResearchFollow;
import com.louis.kitty.admin.sevice.ResearchFollowService;
import com.louis.kitty.admin.sevice.ResearchObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.louis.kitty.admin.model.ResearchObject;
import com.louis.kitty.admin.dao.ResearchObjectMapper;


@Service
public class ResearchObjectServiceImpl implements ResearchObjectService {

    @Autowired
    private ResearchObjectMapper researchObjectMapper;

    @Autowired
    private ResearchFollowService researchFollowService;

    @Override
    public int save(ResearchObject records) {
        if (records.getId() == null || records.getId() == 0) {
            records.setAddtime(new Date());
            //先保存
            researchObjectMapper.add(records);
            //获取最大ID
            int id = 1;
            ResearchObject researchObject = researchObjectMapper.getMaxID();
            if (null != researchObject && researchObject.getId() > 0) {
                id = researchObject.getId();
            }
            //添加周期
            FollowOne record = new FollowOne();
            record.setObjid(String.valueOf(id));
            Type type =new TypeToken<List<FollowTwo>>() {}.getType();
            String string = "[{\"id\":1,\"name\":\"基线期\",\"sort\":\"1\",\"pid\":null,\"content\":null,\"child\":[{\"id\":2,\"objid\":null,\"name\":\"基线期一\",\"sort\":\"1\",\"pid\":\"1\",\"addtime\":\"2019-10-10T09:03:58.000+0000\",\"falg\":null,\"remarks\":null,\"remarksOne\":null,\"content\": null}]},{\"id\":3,\"name\":\"治疗期\",\"sort\":\"2\",\"pid\":null,\"content\":null,\"child\":[{\"id\":4,\"objid\":null,\"name\":\"治疗期一\",\"sort\":\"1\",\"pid\":\"3\",\"addtime\":\"2019-10-10T09:03:58.000+0000\",\"falg\":null,\"remarks\":null,\"remarksOne\":null,\"content\":null},{\"id\":5,\"objid\":null,\"name\":\"治疗期二\",\"sort\":\"2\",\"pid\":\"3\",\"addtime\":\"2019-10-10T09:03:58.000+0000\",\"falg\":null,\"remarks\":null,\"remarksOne\":null,\"content\":null},{\"id\":6,\"objid\":null,\"name\":\"治疗期三\",\"sort\":\"3\",\"pid\":\"3\",\"addtime\":\"2019-10-10T09:03:58.000+0000\",\"falg\":null,\"remarks\":null,\"remarksOne\":null,\"content\":null},{\"id\":7,\"objid\":null,\"name\":\"治疗期四\",\"sort\":\"4\",\"pid\":\"3\",\"addtime\":\"2019-10-10T09:03:58.000+0000\",\"falg\":null,\"remarks\":null,\"remarksOne\":null,\"content\":null}]},{\"id\":8,\"name\":\"随访期\",\"sort\":\"3\",\"pid\":null,\"content\":null,\"child\":[{\"id\":9,\"objid\":null,\"name\":\"随访期一\",\"sort\":\"1\",\"pid\":\"8\",\"addtime\":\"2019-10-10T09:03:58.000+0000\",\"falg\":null,\"remarks\":null,\"remarksOne\":null,\"content\":null},{\"id\":10,\"objid\":null,\"name\":\"随访期二\",\"sort\":\"2\",\"pid\":\"8\",\"addtime\":\"2019-10-10T09:03:58.000+0000\",\"falg\":null,\"remarks\":null,\"remarksOne\":null,\"content\":null},{\"id\":11,\"objid\":null,\"name\":\"随访期三\",\"sort\":\"3\",\"pid\":\"8\",\"addtime\":\"2019-10-10T09:03:58.000+0000\",\"falg\":null,\"remarks\":null,\"remarksOne\":null,\"content\":null}]}]";
            List<FollowTwo> remarks = new Gson().fromJson(string, type);
            LinkedList<FollowTwo> list = new LinkedList<>();
            for(FollowTwo followTwo:remarks){
                list.add(followTwo);
            }
            record.setRemarks(list);
            try {
                //先删除
                ResearchFollow researchFollow3 = new ResearchFollow();
                researchFollow3.setObjid(String.valueOf(record.getObjid()));
                researchFollowService.deleteByObjid(researchFollow3);
                //step 一 获取最大ID
                ResearchFollow researchFollow = researchFollowService.maxId();
                int startID = 0;
                if (null != researchFollow && researchFollow.getId() != null) {
                    startID = researchFollow.getId();
                }
                //step 二  添加一级线
                List<FollowTwo> followTwoList = record.getRemarks();
                for (int i = 0; i < followTwoList.size(); i++) {
                    ResearchFollow researchFollow1 = new ResearchFollow();
                    startID = startID + 1;
                    int pid = startID;
                    researchFollow1.setId(startID);
                    researchFollow1.setObjid(record.getObjid());
                    researchFollow1.setAddtime(new Date());
                    researchFollow1.setSort(followTwoList.get(i).getSort());
                    researchFollow1.setName(followTwoList.get(i).getName());
                    researchFollowService.save(researchFollow1);
                    //step 三 添加二级线
                    for (int j = 0; j < followTwoList.get(i).getChild().size(); j++) {
                        startID = startID + 1;
                        ResearchFollow researchFollow2 = new ResearchFollow();
                        researchFollow2.setId(startID);
                        researchFollow2.setPid(String.valueOf(pid));
                        researchFollow2.setName(followTwoList.get(i).getChild().get(j).getName());
                        researchFollow2.setSort(followTwoList.get(i).getChild().get(j).getSort());
                        researchFollow2.setAddtime(new Date());
                        //content
                        researchFollow2.setContent("");
                        researchFollowService.save(researchFollow2);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return 1;
        }
        return researchObjectMapper.update(records);
    }

    @Override
    public int delete(ResearchObject record) {
        return researchObjectMapper.delete(record.getId());
    }

    @Override
    public int delete(List<ResearchObject> records) {
        for (ResearchObject record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public ResearchObject findById(Long id) {
        return researchObjectMapper.findById(Integer.valueOf(String.valueOf(id)));
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest, researchObjectMapper);
    }

}
