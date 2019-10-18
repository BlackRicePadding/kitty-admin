package com.louis.kitty.admin.controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.louis.kitty.admin.core.http.HttpResult;
import com.louis.kitty.admin.core.page.PageRequest;
import com.louis.kitty.admin.model.HObject;
import com.louis.kitty.admin.sevice.HObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/hObject")
public class HObjectController {

    @Autowired
    private HObjectService hObjectService;

    /**
     * 保存表单项目表
     *
     * @param record
     * @return
     */
    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody HObject record) {
        record.setAddtime(new Date());
        record.setUpdatetime(new Date());
        record.setSorttime(new Date());
        return HttpResult.ok(hObjectService.save(record));
    }

    /**
     * 删除表单项目表
     *
     * @param records
     * @return
     */
    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<HObject> records) {
        return HttpResult.ok(hObjectService.delete(records));
    }

    /**
     * 基础分页查询
     *
     * @param pageRequest
     * @return
     */
    @PostMapping(value = "/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(hObjectService.findPage(pageRequest));
    }

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/findById")
    public HttpResult findById(@RequestParam Integer id) {
        return HttpResult.ok(hObjectService.findById(Long.valueOf(id)));
    }

    @GetMapping(value = "/findAll")
    public HttpResult findAll(@RequestParam Integer id) {
        LinkedList<HObject> list = new LinkedList();
        List<HObject> ss = hObjectService.findAll();
        for (HObject hObject : ss) {
            HObject hObject1 = new HObject();
            hObject1.setId(hObject.getId());
            hObject1.setFormname(hObject.getFormname());
            list.add(hObject1);
        }
        return HttpResult.ok(list);
    }

    @PostMapping(value = "/copyHobj")
    public HttpResult copyHobj(@RequestBody HObject record) {
        HObject hObject = hObjectService.findById(Long.valueOf(record.getId()));
        if (hObject != null) {
            HObject hObject1 = new HObject();
            hObject1.setFormname(record.getFormname());
            hObject1.setContent(hObject.getContent());
            hObject1.setAddtime(new Date());
            hObject1.setUpdatetime(new Date());
            hObject1.setSorttime(new Date());
            return HttpResult.ok(hObjectService.save(hObject1));
        } else {
            return HttpResult.error("id错误");
        }
    }
}
