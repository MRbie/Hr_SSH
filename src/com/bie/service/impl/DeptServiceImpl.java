package com.bie.service.impl;

import java.util.List;

import com.bie.dao.DeptDao;
import com.bie.po.Dept;
import com.bie.service.DeptService;

/** 
* @author 作者:别先生
* @version 创建时间:2017年5月11日 上午9:45:31 
* 类说明 
*/

public class DeptServiceImpl implements DeptService{

	private DeptDao deptDao;
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}
	
	@Override
	public List<Dept> getAll() {
	
		return deptDao.getAll();
	}

	@Override
	public Dept findById(Integer deptId) {
		Dept dept = null;
		if(deptId!= null){
			dept = deptDao.findById(deptId);
		}
		return dept;
	}

	
}
