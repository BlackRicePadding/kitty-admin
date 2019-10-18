package com.louis.kitty.admin.controller;

import java.util.Date;
import java.util.List;

import com.louis.kitty.admin.core.http.HttpResult;
import com.louis.kitty.admin.core.page.PageRequest;
import com.louis.kitty.admin.model.HDictionry;
import com.louis.kitty.admin.sevice.HDictionryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/hDictionry")
public class HDictionryController {

    @Autowired
    private HDictionryService hDictionryService;

    /**
     * 保存字典表
     *
     * @param record
     * @return
     */
    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody HDictionry record) {
        record.setAddtime(new Date());
        return HttpResult.ok(hDictionryService.save(record));
    }

    /**
     * 删除字典表
     *
     * @param records
     * @return
     */
    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<HDictionry> records) {
        return HttpResult.ok(hDictionryService.delete(records));
    }

    /**
     * 基础分页查询
     *
     * @param pageRequest
     * @return
     */
    @PostMapping(value = "/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(hDictionryService.findPage(pageRequest));
    }

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/findById")
    public HttpResult findById(@RequestParam Integer id) {
        return HttpResult.ok(hDictionryService.findById(Long.valueOf(id)));
    }
}
