package com.louis.kitty.admin.sevice.impl;

import java.util.List;

import com.louis.kitty.admin.core.page.MybatisPageHelper;
import com.louis.kitty.admin.core.page.PageRequest;
import com.louis.kitty.admin.core.page.PageResult;
import com.louis.kitty.admin.sevice.BackResearchPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.louis.kitty.admin.model.BackResearchPeople;
import com.louis.kitty.admin.dao.BackResearchPeopleMapper;

@Service
public class BackResearchPeopleServiceImpl implements BackResearchPeopleService {

	@Autowired
	private BackResearchPeopleMapper backResearchPeopleMapper;

	@Override
	public int save(BackResearchPeople record) {
		if(record.getId() == null || record.getId() == 0) {
			return backResearchPeopleMapper.add(record);
		}
		return backResearchPeopleMapper.update(record);
	}

	@Override
	public int delete(BackResearchPeople record) {
		return backResearchPeopleMapper.delete(record.getId());
	}

	@Override
	public int delete(List<BackResearchPeople> records) {
		for(BackResearchPeople record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public BackResearchPeople findById(Long id) {
		return backResearchPeopleMapper.findById(Integer.valueOf(String.valueOf(id)));
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, backResearchPeopleMapper);
	}
	
}
