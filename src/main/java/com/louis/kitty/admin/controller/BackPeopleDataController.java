package com.louis.kitty.admin.controller;

import java.util.List;

import com.louis.kitty.admin.core.http.HttpResult;
import com.louis.kitty.admin.core.page.PageRequest;
import com.louis.kitty.admin.sevice.BackPeopleDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.louis.kitty.admin.model.BackPeopleData;

@RestController
@RequestMapping("backPeopleData")
public class BackPeopleDataController {

    @Autowired
    private BackPeopleDataService backPeopleDataService;

    /**
     * 保存人员数据表-备份
     *
     * @param record
     * @return
     */
    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody BackPeopleData record) {
        return HttpResult.ok(backPeopleDataService.save(record));
    }

    /**
     * 删除人员数据表-备份
     *
     * @param records
     * @return
     */
    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<BackPeopleData> records) {
        return HttpResult.ok(backPeopleDataService.delete(records));
    }

    /**
     * 基础分页查询
     *
     * @param pageRequest
     * @return
     */
    @PostMapping(value = "/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(backPeopleDataService.findPage(pageRequest));
    }

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/findById")
    public HttpResult findById(@RequestParam Integer id) {
        return HttpResult.ok(backPeopleDataService.findById(Long.valueOf(id)));
    }
}
