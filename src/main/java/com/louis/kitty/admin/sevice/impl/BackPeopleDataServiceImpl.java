package com.louis.kitty.admin.sevice.impl;

import java.util.List;

import com.louis.kitty.admin.core.page.MybatisPageHelper;
import com.louis.kitty.admin.core.page.PageRequest;
import com.louis.kitty.admin.core.page.PageResult;
import com.louis.kitty.admin.sevice.BackPeopleDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.louis.kitty.admin.model.BackPeopleData;
import com.louis.kitty.admin.dao.BackPeopleDataMapper;

@Service
public class BackPeopleDataServiceImpl implements BackPeopleDataService {

	@Autowired
	private BackPeopleDataMapper backPeopleDataMapper;

	@Override
	public int save(BackPeopleData record) {
		if(record.getId() == null || record.getId() == 0) {
			return backPeopleDataMapper.add(record);
		}
		return backPeopleDataMapper.update(record);
	}

	@Override
	public int delete(BackPeopleData record) {
		return backPeopleDataMapper.delete(record.getId());
	}

	@Override
	public int delete(List<BackPeopleData> records) {
		for(BackPeopleData record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public BackPeopleData findById(Long id) {
		return backPeopleDataMapper.findById(Integer.valueOf(String.valueOf(id)));
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, backPeopleDataMapper);
	}
	
}
