package com.louis.kitty.admin.sevice;

import java.util.List;

import com.louis.kitty.admin.model.SysDept;
import com.louis.kitty.admin.core.service.CurdService;

/**
 * 机构管理
 * @author Louis
 * @date Oct 29, 2018
 */
public interface SysDeptService extends CurdService<SysDept> {

	/**
	 * 查询机构树
	 * @return
	 */
	List<SysDept> findTree();
}
