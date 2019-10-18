package com.louis.kitty.admin.controller;

import java.util.List;

import com.google.gson.Gson;
import com.louis.kitty.admin.core.http.HttpResult;
import com.louis.kitty.admin.core.page.PageRequest;
import com.louis.kitty.admin.model.PeopleFollow;
import com.louis.kitty.admin.sevice.ResearchPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.louis.kitty.admin.model.ResearchPeople;

@RestController
@RequestMapping("/api/researchPeople")
public class ResearchPeopleController {

	@Autowired
	private ResearchPeopleService researchPeopleService;

	/**
	 * 保存随访人员表
	 * @param record
	 * @return
	 */
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody ResearchPeople record) {
		return HttpResult.ok(researchPeopleService.save(record));
	}

    /**
     * 删除随访人员表
     * @param records
     * @return
     */
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<ResearchPeople> records) {
		return HttpResult.ok(researchPeopleService.delete(records));
	}

    /**
     * 基础分页查询
     * @param pageRequest
     * @return
     */
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(researchPeopleService.findPage(pageRequest));
	}

    /**
     * 根据主键查询
     * @param id
     * @return
     */
	@GetMapping(value="/findById")
	public HttpResult findById(@RequestParam Integer id) {
		return HttpResult.ok(researchPeopleService.findById(Long.valueOf(id)));
	}

	/**
	 * 批量修改状态
	 * @param ids
	 * @return
	 */
	@GetMapping(value="/pichFalg")
	public HttpResult pichFalg(@RequestParam String ids) {

		return HttpResult.ok(researchPeopleService.updateFalg(ids));
	}

	/**
	 *获取整个项目的周期
	 * @param id
	 * @return
	 */
	@GetMapping(value="/findFollowById")
	public HttpResult findFollowById(@RequestParam Integer id) {
		ResearchPeople researchPeople = new ResearchPeople();
		researchPeople.setId(id);
		return HttpResult.ok(researchPeopleService.findFollowById(researchPeople));
	}

	/**
	 * 获取具体某一个用户的周期，
	 * @param id
	 * @return
	 */
	@GetMapping(value="/findFollowSortById")
	public HttpResult findFollowSortById(@RequestParam Integer id) {
		ResearchPeople researchPeople = new ResearchPeople();
		researchPeople.setId(id);
		return HttpResult.ok(researchPeopleService.findFollowSortById(researchPeople));
	}

	@PostMapping(value="/updatePeopleFollow")
	public HttpResult updatePeopleFollow(@RequestBody PeopleFollow record) {
		ResearchPeople researchPeople = new ResearchPeople();
		researchPeople.setId(record.getId());
		researchPeople.setFlowContent(new Gson().toJson(record.getFlowContent()));
		return HttpResult.ok(researchPeopleService.save(researchPeople));
	}
}
