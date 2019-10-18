package com.louis.kitty.admin.controller;

import java.util.*;

import com.google.gson.Gson;
import com.louis.kitty.admin.core.http.HttpResult;
import com.louis.kitty.admin.core.page.PageRequest;
import com.louis.kitty.admin.model.*;
import com.louis.kitty.admin.sevice.HObjectService;
import com.louis.kitty.admin.sevice.ResearchFollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/researchFollow")
public class ResearchFollowController {

    @Autowired
    private ResearchFollowService researchFollowService;

    /**
     * 保存项目周期表
     *
     * @param record
     * @return
     */
    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody ResearchFollow record) {
        return HttpResult.ok(researchFollowService.save(record));
    }

    /**
     * 删除项目周期表
     *
     * @param records
     * @return
     */
    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<ResearchFollow> records) {
        return HttpResult.ok(researchFollowService.delete(records));
    }

    /**
     * 基础分页查询
     *
     * @param pageRequest
     * @return
     */
    @PostMapping(value = "/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(researchFollowService.findPage(pageRequest));
    }

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/findById")
    public HttpResult findById(@RequestParam Integer id) {
        return HttpResult.ok(researchFollowService.findById(Long.valueOf(id)));
    }

    /**
     * 根据项目ID去查询
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/findByObjid")
    public HttpResult findByObjid(@RequestParam Integer id) {
        ResearchFollow researchFollow = new ResearchFollow();
        researchFollow.setObjid(String.valueOf(id));
        return HttpResult.ok(researchFollowService.followList(researchFollow));
    }

    /**
     * 根据项目ID，去执行删除
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/deleteByObjid")
    public HttpResult deleteByObjid(@RequestParam Integer id) {
        ResearchFollow researchFollow = new ResearchFollow();
        researchFollow.setObjid(String.valueOf(id));
        return HttpResult.ok(researchFollowService.deleteByObjid(researchFollow));
    }

    @PostMapping(value = "/saveFollow")
    public HttpResult saveFollow(@RequestBody FollowOne record) {
        int resultFalg = 1;
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
                    researchFollow2.setContent(new Gson().toJson(followTwoList.get(i).getChild().get(j).getContent()));
                    researchFollowService.save(researchFollow2);
                }
            }

        } catch (Exception e) {
            resultFalg = 2;
            e.printStackTrace();
        }
        return HttpResult.ok(resultFalg);
    }

    @GetMapping(value = "/findByObjFollow")
    public HttpResult findByObjFollow(@RequestParam Integer id) {
        ResearchFollow researchFollow = new ResearchFollow();
        researchFollow.setObjid(String.valueOf(id));
        return HttpResult.ok(researchFollowService.findAllFollowContent(researchFollow));
    }

    @PostMapping(value = "/saveFollowContent")
    public HttpResult saveFollowContent(@RequestBody FollowContent record) {
        List<FollowContentItem> list = record.getContent();
        for (FollowContentItem followContentItem : list) {
            ResearchFollow researchFollow = new ResearchFollow();
            researchFollow.setId(followContentItem.getFlowId());
            researchFollow.setContent(followContentItem.getFlowContent());
            researchFollowService.updateContent(researchFollow);
        }
        return HttpResult.ok(list);
    }
}
