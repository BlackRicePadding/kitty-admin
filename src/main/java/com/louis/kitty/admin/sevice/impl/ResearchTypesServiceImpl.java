package com.louis.kitty.admin.sevice.impl;

import java.util.List;

import com.louis.kitty.admin.core.page.MybatisPageHelper;
import com.louis.kitty.admin.core.page.PageRequest;
import com.louis.kitty.admin.core.page.PageResult;
import com.louis.kitty.admin.sevice.ResearchTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.louis.kitty.admin.model.ResearchTypes;
import com.louis.kitty.admin.dao.ResearchTypesMapper;

@Service
public class ResearchTypesServiceImpl implements ResearchTypesService {

	@Autowired
	private ResearchTypesMapper researchTypesMapper;

	@Override
	public int save(ResearchTypes record) {
		if(record.getId() == null || record.getId() == 0) {
			return researchTypesMapper.add(record);
		}
		return researchTypesMapper.update(record);
	}

	@Override
	public int delete(ResearchTypes record) {
		return researchTypesMapper.delete(record.getId());
	}

	@Override
	public int delete(List<ResearchTypes> records) {
		for(ResearchTypes record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public ResearchTypes findById(Long id) {
		return researchTypesMapper.findById(Integer.valueOf(String.valueOf(id)));
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, researchTypesMapper);
	}
	
}
