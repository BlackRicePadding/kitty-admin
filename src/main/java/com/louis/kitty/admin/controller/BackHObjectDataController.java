package com.louis.kitty.admin.controller;


import com.louis.kitty.admin.core.http.HttpResult;
import com.louis.kitty.admin.core.page.PageRequest;
import com.louis.kitty.admin.model.BackHObjectData;
import com.louis.kitty.admin.sevice.BackHObjectDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/backHObjectData")
public class BackHObjectDataController {

	@Autowired
	private BackHObjectDataService backHObjectDataService;

	/**
	 * 保存表单数据表_备份表
	 * @param record
	 * @return
	 */	
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody BackHObjectData record) {
		return HttpResult.ok(backHObjectDataService.save(record));
	}

    /**
     * 删除表单数据表_备份表
     * @param records
     * @return
     */
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<BackHObjectData> records) {
		return HttpResult.ok(backHObjectDataService.delete(records));
	}

    /**
     * 基础分页查询
     * @param pageRequest
     * @return
     */    
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(backHObjectDataService.findPage(pageRequest));
	}
	
    /**
     * 根据主键查询
     * @param id
     * @return
     */ 	
	@GetMapping(value="/findById")
	public HttpResult findById(@RequestParam Integer id) {
		return HttpResult.ok(backHObjectDataService.findById(Long.valueOf(id)));
	}
}
