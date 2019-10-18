package com.louis.kitty.admin.sevice.impl;

import com.louis.kitty.admin.core.page.MybatisPageHelper;
import com.louis.kitty.admin.core.page.PageRequest;
import com.louis.kitty.admin.core.page.PageResult;
import com.louis.kitty.admin.dao.BackHObjectDataMapper;
import com.louis.kitty.admin.model.BackHObjectData;
import com.louis.kitty.admin.model.HObject;
import com.louis.kitty.admin.sevice.BackHObjectDataService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BackHObjectDataServiceImpl implements BackHObjectDataService {

	@Autowired
	private BackHObjectDataMapper backHObjectDataMapper;

	@Override
	public int save(BackHObjectData record) {
		if(record.getId() == null || record.getId() == 0) {
			return backHObjectDataMapper.add(record);
		}
		return backHObjectDataMapper.update(record);
	}

	@Override
	public int delete(BackHObjectData record) {
		return backHObjectDataMapper.delete(record.getId());
	}

	@Override
	public int delete(List<BackHObjectData> records) {
		for(BackHObjectData record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public BackHObjectData findById(Long id) {
		return backHObjectDataMapper.findById(Integer.valueOf(String.valueOf(id)));
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, backHObjectDataMapper);
	}

	@Override
	public int getCount(BackHObjectData backHObjectData) {
		return backHObjectDataMapper.getCount(backHObjectData);
	}
}
