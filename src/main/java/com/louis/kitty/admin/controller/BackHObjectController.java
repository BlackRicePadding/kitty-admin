package com.louis.kitty.admin.controller;

import com.louis.kitty.admin.core.http.HttpResult;
import com.louis.kitty.admin.core.page.PageRequest;
import com.louis.kitty.admin.model.BackHObject;
import com.louis.kitty.admin.sevice.BackHObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/backHObject")
public class BackHObjectController {

	@Autowired
	private BackHObjectService backHObjectService;

	/**
	 * 保存表单项目表_备份数据
	 * @param record
	 * @return
	 */	
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody BackHObject record) {
		return HttpResult.ok(backHObjectService.save(record));
	}

    /**
     * 删除表单项目表_备份数据
     * @param records
     * @return
     */
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<BackHObject> records) {
		return HttpResult.ok(backHObjectService.delete(records));
	}

    /**
     * 基础分页查询
     * @param pageRequest
     * @return
     */    
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(backHObjectService.findPage(pageRequest));
	}
	
    /**
     * 根据主键查询
     * @param id
     * @return
     */ 	
	@GetMapping(value="/findById")
	public HttpResult findById(@RequestParam Integer id) {
		return HttpResult.ok(backHObjectService.findById(Long.valueOf(id)));
	}
}
