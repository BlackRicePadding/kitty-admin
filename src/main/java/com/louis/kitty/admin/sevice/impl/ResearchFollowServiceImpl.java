package com.louis.kitty.admin.sevice.impl;

import java.util.*;

import com.google.gson.Gson;
import com.louis.kitty.admin.core.page.MybatisPageHelper;
import com.louis.kitty.admin.core.page.PageRequest;
import com.louis.kitty.admin.core.page.PageResult;
import com.louis.kitty.admin.model.HObject;
import com.louis.kitty.admin.sevice.HObjectService;
import com.louis.kitty.admin.sevice.ResearchFollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.kitty.admin.model.ResearchFollow;
import com.louis.kitty.admin.dao.ResearchFollowMapper;

@Service
public class ResearchFollowServiceImpl implements ResearchFollowService {

    @Autowired
    private ResearchFollowMapper researchFollowMapper;

    @Autowired
    private HObjectService hObjectService;

    @Override
    public int save(ResearchFollow record) {
        return researchFollowMapper.add(record);
    }

    @Override
    public int delete(ResearchFollow record) {
        return researchFollowMapper.delete(record.getId());
    }

    @Override
    public int delete(List<ResearchFollow> records) {
        for (ResearchFollow record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public ResearchFollow findById(Long id) {
        return researchFollowMapper.findById(Integer.valueOf(String.valueOf(id)));
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest, researchFollowMapper);
    }

    @Override
    public int updateContent(ResearchFollow researchFollow) {
        return researchFollowMapper.update(researchFollow);
    }

    @Override
    public List<Map<String, Object>> followList(ResearchFollow researchFollow) {
        //查询病例
        List<HObject> hObjects = hObjectService.findAll();
        List<HObject> hObjectLinkedList = new LinkedList<>();
        for (HObject hObject : hObjects) {
            HObject hObject1 = new HObject();
            hObject1.setId(hObject.getId());
            hObject1.setFormname(hObject.getFormname());
            hObjectLinkedList.add(hObject1);
        }
        List<Map<String, Object>> resultList = new LinkedList<>();
        List<ResearchFollow> researchFollowList = new ArrayList<>();
        researchFollowList = researchFollowMapper.followList(researchFollow);
        if (researchFollowList.size() > 0) {
            for (ResearchFollow researchFollow1 : researchFollowList) {
                Map<String, Object> map = new LinkedHashMap<>();
                map.put("id", researchFollow1.getId());
                map.put("name", researchFollow1.getName());
                map.put("sort", researchFollow1.getSort());
                map.put("pid", researchFollow1.getPid());
                map.put("content", researchFollow1.getContent());
                ResearchFollow researchFollow2 = new ResearchFollow();
                researchFollow2.setPid(String.valueOf(researchFollow1.getId()));
                List<ResearchFollow> researchFollows = researchFollowMapper.followList(researchFollow2);
                for (ResearchFollow researchFollow3 : researchFollows) {
                    researchFollow3.setRemarks(new Gson().toJson(hObjectLinkedList));
                }
                map.put("child", researchFollows);
                resultList.add(map);
            }
        }
        return resultList;
    }

    @Override
    public int deleteByObjid(ResearchFollow researchFollow) {
        int i = 1;
        try {
            List<ResearchFollow> researchFollowList = new ArrayList<>();
            researchFollowList = researchFollowMapper.followList(researchFollow);
            if (researchFollowList.size() > 0) {
                for (ResearchFollow researchFollow1 : researchFollowList) {
                    ResearchFollow researchFollow2 = new ResearchFollow();
                    researchFollow2.setPid(String.valueOf(researchFollow1.getId()));
                    List<ResearchFollow> researchFollowList1 = researchFollowMapper.followList(researchFollow2);
                    for (ResearchFollow researchFollow3 : researchFollowList1) {
                        researchFollowMapper.delete(researchFollow3.getId());
                    }
                    researchFollowMapper.delete(researchFollow1.getId());
                }
            }
        } catch (Exception e) {
            i = 2;
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public ResearchFollow maxId() {
        return researchFollowMapper.maxId();
    }

    @Override
    public List<Map<String, Object>> findAllFollowContent(ResearchFollow researchFollow) {
        List<Map<String, Object>> resultList = new LinkedList<>();
        List<ResearchFollow> researchFollowList = new ArrayList<>();


        researchFollowList = researchFollowMapper.followList(researchFollow);
        if (researchFollowList.size() > 0) {
            for (ResearchFollow researchFollow1 : researchFollowList) {
                ResearchFollow researchFollow2 = new ResearchFollow();
                researchFollow2.setPid(String.valueOf(researchFollow1.getId()));
                List<ResearchFollow> researchFollows = researchFollowMapper.followList(researchFollow2);
                for (ResearchFollow researchFollow3 : researchFollows) {
                    Map<String, Object> map = new LinkedHashMap<>();
                    map.put("flowId", researchFollow3.getId());
                    map.put("flowContent", researchFollow3.getContent());
                    resultList.add(map);
                }
            }
        }
        return resultList;
    }
}
