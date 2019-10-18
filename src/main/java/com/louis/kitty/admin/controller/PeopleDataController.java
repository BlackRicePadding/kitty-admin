package com.louis.kitty.admin.controller;

import java.util.List;

import com.louis.kitty.admin.core.http.HttpResult;
import com.louis.kitty.admin.core.page.PageRequest;
import com.louis.kitty.admin.sevice.PeopleDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.louis.kitty.admin.model.PeopleData;


@RestController
@RequestMapping("/api/peopleData")
public class PeopleDataController {

    @Autowired
    private PeopleDataService peopleDataService;

    /**
     * 保存人员数据表
     *
     * @param record
     * @return
     */
    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody PeopleData record) {
        return HttpResult.ok(peopleDataService.save(record));
    }

    /**
     * 删除人员数据表
     *
     * @param records
     * @return
     */
    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<PeopleData> records) {
        return HttpResult.ok(peopleDataService.delete(records));
    }

    /**
     * 基础分页查询
     *
     * @param pageRequest
     * @return
     */
    @PostMapping(value = "/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(peopleDataService.findPage(pageRequest));
    }

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/findById")
    public HttpResult findById(@RequestParam Integer id) {
        return HttpResult.ok(peopleDataService.findById(Long.valueOf(id)));
    }

    @GetMapping(value = "/findByObj")
    public HttpResult findByObj(String objid, String hid, String fid, String pid) {
        PeopleData peopleData = new PeopleData();
        peopleData.setPeopleid(pid);
        peopleData.setHobjectid(hid);
        peopleData.setFollowid(fid);
        peopleData.setObjid(objid);
        return HttpResult.ok(peopleDataService.findByObjEntity(peopleData));
    }
}
