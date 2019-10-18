package com.louis.kitty.admin.controller;

import java.util.List;

import com.louis.kitty.admin.core.http.HttpResult;
import com.louis.kitty.admin.core.page.PageRequest;
import com.louis.kitty.admin.sevice.ResearchTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.louis.kitty.admin.model.ResearchTypes;


@RestController
@RequestMapping("/api/researchTypes")
public class ResearchTypesController {

	@Autowired
	private ResearchTypesService researchTypesService;

	/**
	 * 保存科研类型表
	 * @param record
	 * @return
	 */	
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody ResearchTypes record) {
		return HttpResult.ok(researchTypesService.save(record));
	}

    /**
     * 删除科研类型表
     * @param records
     * @return
     */
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<ResearchTypes> records) {
		return HttpResult.ok(researchTypesService.delete(records));
	}

    /**
     * 基础分页查询
     * @param pageRequest
     * @return
     */    
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(researchTypesService.findPage(pageRequest));
	}
	
    /**
     * 根据主键查询
     * @param id
     * @return
     */ 	
	@GetMapping(value="/findById")
	public HttpResult findById(@RequestParam Integer id) {
		return HttpResult.ok(researchTypesService.findById(Long.valueOf(id)));
	}
}
