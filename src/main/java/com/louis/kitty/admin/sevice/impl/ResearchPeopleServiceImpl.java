package com.louis.kitty.admin.sevice.impl;

import java.lang.reflect.Type;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.louis.kitty.admin.core.page.ColumnFilter;
import com.louis.kitty.admin.core.page.MybatisPageHelper;
import com.louis.kitty.admin.core.page.PageRequest;
import com.louis.kitty.admin.core.page.PageResult;
import com.louis.kitty.admin.dao.ResearchFollowMapper;
import com.louis.kitty.admin.model.*;
import com.louis.kitty.admin.sevice.HObjectService;
import com.louis.kitty.admin.sevice.PeopleDataService;
import com.louis.kitty.admin.sevice.ResearchFollowService;
import com.louis.kitty.admin.sevice.ResearchPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.louis.kitty.admin.dao.ResearchPeopleMapper;

@Service
public class ResearchPeopleServiceImpl implements ResearchPeopleService {

    @Autowired
    private ResearchPeopleMapper researchPeopleMapper;

    @Autowired
    private HObjectService hObjectService;

    @Autowired
    private PeopleDataService peopleDataService;

    @Autowired
    private ResearchFollowMapper researchFollowMapper;


    @Override
    public int save(ResearchPeople record) {
        if (record.getId() == null || record.getId() == 0) {
            //flowid=0表示，这个人是从本系统添加的；
            //写服务的时候，注意下，把这个值给1
            record.setFlowId("0");
            //封装周期
            List<Map<String, Object>> resultList = new LinkedList<>();
            ResearchFollow researchFollow = new ResearchFollow();
            researchFollow.setObjid(record.getResearchId());
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
            record.setFlowContent(new Gson().toJson(resultList).toString());
            record.setFalg("0");
            record.setAddtime(new Date());
            return researchPeopleMapper.add(record);
        }
        return researchPeopleMapper.update(record);
    }

    @Override
    public int delete(ResearchPeople record) {
        return researchPeopleMapper.delete(record.getId());
    }

    @Override
    public int delete(List<ResearchPeople> records) {
        for (ResearchPeople record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public ResearchPeople findById(Long id) {
        return researchPeopleMapper.findById(Integer.valueOf(String.valueOf(id)));
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        ResearchPeople researchPeople = new ResearchPeople();
        String objID = getColumnFilterValue(pageRequest, "researchId");
        if (null != objID && objID.length() > 0) {
            researchPeople.setResearchId(objID);
            String falg = getColumnFilterValue(pageRequest, "falg");
            if (null != falg && falg.length() > 0 && falg.equals("0")) {
                researchPeople.setFalg(falg);
                PageResult pageResult = new PageResult();
                pageResult.setPageNum(pageRequest.getPageNum());
                pageResult.setPageSize(pageRequest.getPageSize());
                researchPeople.setLimitOne(((pageRequest.getPageNum() - 1) * pageRequest.getPageSize()));
                researchPeople.setLimitTwo((pageRequest.getPageSize()));
                int total = researchPeopleMapper.getTotal(researchPeople);
                List<ResearchPeople> researchPeopleList = researchPeopleMapper.findByFalgPage(researchPeople);

                //获取全部表单
                Map<String, Object> hobjectMap = new HashMap<>();
                List<HObject> hObjectList = hObjectService.findAll();
                for (HObject hObject : hObjectList) {
                    hobjectMap.put(String.valueOf(hObject.getId()), hObject.getFormname());
                }

                //封装数据
                List<ResearchPeople> researchPeopleReslt = new LinkedList<>();
                for (ResearchPeople researchPeople1 : researchPeopleList) {
                    ResearchPeople researchPeople2 = new ResearchPeople();
                    researchPeople2.setId(researchPeople1.getId());
                    researchPeople2.setName(researchPeople1.getName());
                    researchPeople2.setSex(researchPeople1.getSex());
                    researchPeople2.setXtNum(researchPeople1.getXtNum());
                    researchPeople2.setYjNum(researchPeople1.getYjNum());
                    researchPeople2.setZyNum(researchPeople1.getZyNum());
                    researchPeople2.setMzNum(researchPeople1.getMzNum());
                    researchPeople2.setFlowId(researchPeople1.getFlowId());
                    researchPeople2.setFlowContent(researchPeople1.getFlowContent());
                    researchPeople2.setAddtime(researchPeople1.getAddtime());
                    researchPeople2.setFalg(researchPeople1.getFalg());
                    researchPeople2.setResearchId(researchPeople1.getResearchId());
                    //基线判断
                    Type type = new TypeToken<List<ResearchPeople>>() {
                    }.getType();
                    List<ResearchPeople> flowContentList = new Gson().fromJson(researchPeople1.getFlowContent(), type);
                    for (int i = 0; i < flowContentList.size(); i++) {
                        ResearchPeople researchPeople3 = flowContentList.get(i);
                        String[] contetnArr = researchPeople3.getFlowContent().split(",");
                        List<Map<String, Object>> sortList = new LinkedList<>();
                        for (String str : contetnArr) {
                            if (null != str || str.length() > 0) {
                                Map<String, Object> map = new HashMap<>();
                                map.put("id", str);
                                map.put("name", hobjectMap.get(str));
                                PeopleData peopleData = new PeopleData();
                                peopleData.setObjid(objID);
                                peopleData.setFollowid(researchPeople3.getFlowId());
                                peopleData.setHobjectid(str);
                                peopleData.setPeopleid(String.valueOf(researchPeople1.getId()));
                                map.put("sort", peopleDataService.getEntityTotal(peopleData));
                                sortList.add(map);
                            }
                        }
                        if (i == 0) {
                            researchPeople2.setRemarks(new Gson().toJson(sortList));
                        } else if (i == 1) {
                            researchPeople2.setRemarksOne(new Gson().toJson(sortList));
                        } else if (i == 2) {
                            researchPeople2.setRemarksTwo(new Gson().toJson(sortList));
                        } else if (i == 3) {
                            researchPeople2.setRemarksThree(new Gson().toJson(sortList));
                        } else if (i == 4) {
                            researchPeople2.setRemarksFour(new Gson().toJson(sortList));
                        } else if (i == 5) {
                            researchPeople2.setRemarksFive(new Gson().toJson(sortList));
                        } else if (i == 6) {
                            researchPeople2.setRemarksSix(new Gson().toJson(sortList));
                        } else if (i == 7) {
                            researchPeople2.setRemarksSeven(new Gson().toJson(sortList));
                        }
                    }
                    researchPeopleReslt.add(researchPeople2);
                }
                pageResult.setTotalSize(total);
                pageResult.setTotalPages(total);
                pageResult.setContent(researchPeopleReslt);
                return pageResult;
            } else {
                researchPeople.setResearchId(objID);
                researchPeople.setFalg(falg);
                researchPeople.setLimitOne(((pageRequest.getPageNum() - 1) * pageRequest.getPageSize()));
                researchPeople.setLimitTwo((pageRequest.getPageSize()));
                PageResult pageResult = new PageResult();
                pageResult.setPageNum(pageRequest.getPageNum());
                pageResult.setPageSize(pageRequest.getPageSize());
                int total = researchPeopleMapper.getTotal(researchPeople);
                List<ResearchPeople> researchPeopleList = researchPeopleMapper.findByFalgPage(researchPeople);
                pageResult.setTotalSize(total);
                pageResult.setTotalPages(total);
                pageResult.setContent(researchPeopleList);
                return pageResult;
            }
        } else {
            researchPeople.setResearchId("-1");
            return MybatisPageHelper.findPage(pageRequest, researchPeopleMapper, "findByFalgPage", researchPeople);
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
    public int updateFalg(String ids) {
        String ss[] = ids.split(",");
        for (String s1 : ss) {
            ResearchPeople researchPeople = new ResearchPeople();
            researchPeople.setId(Integer.valueOf(s1));
            researchPeople.setFalg("0");
            researchPeopleMapper.update(researchPeople);
        }
        return ss.length;
    }

    @Override
    public List<Map<String, Object>> findFollowById(ResearchPeople researchPeople) {
        List<Map<String, Object>> result = new LinkedList<>();
        researchPeople = findById(Long.valueOf(researchPeople.getId()));
        Type type = new TypeToken<List<FollowContentItem>>() {
        }.getType();
        List<FollowContentItem> flowContentList = new Gson().fromJson(researchPeople.getFlowContent(), type);
        if (flowContentList.size() > 0) {
            for (FollowContentItem followContentItem : flowContentList) {
                Map<String, Object> mapOne = new LinkedHashMap<>();
                mapOne.clear();
                mapOne.put("id", followContentItem.getFlowId());
                mapOne.put("name", getFollowName(String.valueOf(followContentItem.getFlowId())));
                String[] followID = followContentItem.getFlowContent().split(",");
                List<Map<String, Object>> followChild = new LinkedList<>();
                followChild.clear();
                for (String str : followID) {
                    if (str.length() > 0) {
                        HObject hObject = hObjectService.findById(Long.valueOf(str));
                        if (null != hObject) {
                            Map<String, Object> mapTwo = new LinkedHashMap<>();
                            mapTwo.put("id", hObject.getId());
                            mapTwo.put("name", hObject.getFormname());
                            followChild.add(mapTwo);
                        }
                    }
                }
                mapOne.put("child", followChild);
                result.add(mapOne);
            }

        }
        return result;
    }

    @Override
    public List<Map<String, Object>> findFollowSortById(ResearchPeople researchPeople) {
        List<Map<String, Object>> resultList = new LinkedList<>();
        researchPeople = researchPeopleMapper.findById(researchPeople.getId());
        if (null != researchPeople && null != researchPeople.getResearchId()) {
            //先处理map
            Map<String, Object> mapFollow = new LinkedHashMap<>();
            Type type = new TypeToken<List<ResearchPeople>>() {
            }.getType();
            List<ResearchPeople> flowContentList = new Gson().fromJson(researchPeople.getFlowContent(), type);
            for (ResearchPeople researchPeople1 : flowContentList) {
                mapFollow.put(researchPeople1.getFlowId(), researchPeople1.getFlowContent());
            }
            //
            ResearchFollow researchFollow = new ResearchFollow();
            researchFollow.setObjid((researchPeople.getResearchId()));
            List<HObject> hObjects = hObjectService.findAll();
            Map<String, Object> hobjectMap = new LinkedHashMap<>();
            for (HObject hObject : hObjects) {
                hobjectMap.put(String.valueOf(hObject.getId()), hObject.getFormname());
            }
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
                        List<Map<String, Object>> hobjectList = new LinkedList<>();
                        String content[] = researchFollow3.getContent().split(",");
                        for (String str : content) {
                            Map<String, Object> mapTemp = new HashMap<>();
                            mapTemp.put("id", str);
                            mapTemp.put("name", hobjectMap.get(str));
                            if (null != mapFollow.get(String.valueOf(researchFollow3.getId()))) {
                                if (String.valueOf(mapFollow.get(String.valueOf(researchFollow3.getId()))).indexOf(str)>-1) {
                                    mapTemp.put("falg", 1);
                                }else{
                                    mapTemp.put("falg", 0);
                                }
                            } else {
                                mapTemp.put("falg", 0);
                            }
                            hobjectList.add(mapTemp);
                        }
                        researchFollow3.setChild((hobjectList));
                    }
                    map.put("child", researchFollows);
                    resultList.add(map);
                }
            }
        }
        return resultList;
    }

    public String getFollowName(String id) {
        String name = "";
        ResearchFollow researchFollow = researchFollowMapper.findById(Integer.valueOf(id));
        if (null != researchFollow) {
            name = researchFollow.getName();
        }
        /*if (null != researchFollow) {
            ResearchFollow researchFollowOne = researchFollowMapper.findById(Integer.valueOf(researchFollow.getPid()));
            name = name + "," + researchFollowOne.getName();
        }*/
        return name;
    }

}
