package com.louis.kitty.admin.controller;

import java.util.Date;
import java.util.List;

import com.louis.kitty.admin.core.http.HttpResult;
import com.louis.kitty.admin.core.page.PageRequest;
import com.louis.kitty.admin.model.HObjectData;
import com.louis.kitty.admin.sevice.HObjectDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/hObjectData")
public class HObjectDataController {

    @Autowired
    private HObjectDataService hObjectDataService;

    /**
     * 保存表单数据表
     *
     * @param record
     * @return
     */
    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody HObjectData record) {
        if (record.getId() == null || record.getId() == 0) {
            record.setAddtime(new Date());
        }
        record.setUpdatetime(new Date());
        return HttpResult.ok(hObjectDataService.save(record));
    }

    /**
     * 删除表单数据表
     *
     * @param records
     * @return
     */
    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<HObjectData> records) {
        return HttpResult.ok(hObjectDataService.delete(records));
    }

    /**
     * 基础分页查询
     *
     * @param pageRequest
     * @return
     */
    @PostMapping(value = "/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(hObjectDataService.findPage(pageRequest));
    }
    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/findById")
    public HttpResult findById(@RequestParam Integer id) {
        return HttpResult.ok(hObjectDataService.findById(Long.valueOf(id)));
    }
}
