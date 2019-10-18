package com.louis.kitty.admin.controller;

import java.util.List;

import com.louis.kitty.admin.core.http.HttpResult;
import com.louis.kitty.admin.core.page.PageRequest;
import com.louis.kitty.admin.sevice.BackResearchPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.louis.kitty.admin.model.BackResearchPeople;

/**
 * ---------------------------
 * 随访人员表 (BackResearchPeopleController)         
 * ---------------------------
 */
@RestController
@RequestMapping("/api/backResearchPeople")
public class BackResearchPeopleController {

	@Autowired
	private BackResearchPeopleService backResearchPeopleService;

	/**
	 * 保存随访人员表
	 * @param record
	 * @return
	 */	
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody BackResearchPeople record) {
		return HttpResult.ok(backResearchPeopleService.save(record));
	}

    /**
     * 删除随访人员表
     * @param records
     * @return
     */
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<BackResearchPeople> records) {
		return HttpResult.ok(backResearchPeopleService.delete(records));
	}

    /**
     * 基础分页查询
     * @param pageRequest
     * @return
     */    
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(backResearchPeopleService.findPage(pageRequest));
	}
	
    /**
     * 根据主键查询
     * @param id
     * @return
     */ 	
	@GetMapping(value="/findById")
	public HttpResult findById(@RequestParam Integer id) {
		return HttpResult.ok(backResearchPeopleService.findById(Long.valueOf(id)));
	}
}
