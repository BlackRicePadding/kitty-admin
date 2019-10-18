package com.louis.kitty.admin.sevice.impl;

import com.louis.kitty.admin.core.page.MybatisPageHelper;
import com.louis.kitty.admin.core.page.PageRequest;
import com.louis.kitty.admin.core.page.PageResult;
import com.louis.kitty.admin.dao.BackHObjectMapper;
import com.louis.kitty.admin.model.BackHObject;
import com.louis.kitty.admin.model.HObject;
import com.louis.kitty.admin.sevice.BackHObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BackHObjectServiceImpl implements BackHObjectService {

	@Autowired
	private BackHObjectMapper backHObjectMapper;

	@Override
	public int save(BackHObject record) {
		if(record.getId() == null || record.getId() == 0) {
			return backHObjectMapper.add(record);
		}
		return backHObjectMapper.update(record);
	}

	@Override
	public int delete(BackHObject record) {
		return backHObjectMapper.delete(record.getId());
	}

	@Override
	public int delete(List<BackHObject> records) {
		for(BackHObject record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public BackHObject findById(Long id) {
		return backHObjectMapper.findById(Integer.valueOf(String.valueOf(id)));
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, backHObjectMapper);
	}

	@Override
	public int getCount(BackHObject backHObject) {
		return backHObjectMapper.getCount(backHObject);
	}
}
