package com.louis.kitty.admin.sevice.impl;

import java.util.List;

import com.louis.kitty.admin.core.page.ColumnFilter;
import com.louis.kitty.admin.core.page.MybatisPageHelper;
import com.louis.kitty.admin.core.page.PageRequest;
import com.louis.kitty.admin.core.page.PageResult;
import com.louis.kitty.admin.dao.HDictionryMapper;
import com.louis.kitty.admin.model.HDictionry;
import com.louis.kitty.admin.sevice.HDictionryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HDictionryServiceImpl implements HDictionryService {

	@Autowired
	private HDictionryMapper hDictionryMapper;

	@Override
	public int save(HDictionry record) {
		if(record.getId() == null || record.getId() == 0) {
			return hDictionryMapper.add(record);
		}
		return hDictionryMapper.update(record);
	}

	@Override
	public int delete(HDictionry record) {
		return hDictionryMapper.delete(record.getId());
	}

	@Override
	public int delete(List<HDictionry> records) {
		for(HDictionry record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public HDictionry findById(Long id) {
		return hDictionryMapper.findById(Integer.valueOf(String.valueOf(id)));
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		String pid = getColumnFilterValue(pageRequest, "pid");
		if(pid!=null){
			return MybatisPageHelper.findPage(pageRequest, hDictionryMapper,"findPageByPid",pid);
		}
		return MybatisPageHelper.findPage(pageRequest, hDictionryMapper);
	}
	/**
	 * 获取过滤字段的值
	 *
	 * @param filterName
	 * @return
	 */
	public String getColumnFilterValue(PageRequest pageRequest, String filterName) {
		String value = null;
		ColumnFilter columnFilter = pageRequest.getColumnFilter(filterName);
		if (columnFilter != null) {
			value = columnFilter.getValue();
		}
		return value;
	}

}
