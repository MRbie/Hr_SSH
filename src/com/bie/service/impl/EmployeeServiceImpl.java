package com.bie.service.impl;

import java.util.List;

import com.bie.dao.EmployeeDao;
import com.bie.po.Employee;
import com.bie.service.EmployeeService;

/** 
* @author 作者:别先生
* @version 创建时间:2017年5月11日 上午9:46:16 
* 类说明 
*/

public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDao empDao ;
	public void setEmpDao(EmployeeDao empDao) {
		this.empDao = empDao;
	}
	
	@Override
	public void save(Employee emp) {
		if(emp != null && !"".equals(emp)){
			empDao.save(emp);
		}
	}

	@Override
	public void update(Employee emp) {
		if(emp != null && !"".equals(emp)){
			empDao.update(emp);
		}
		
	}

	@Override
	public void delete(Integer empId) {
		//最好进行判断一下，参数是否为空
		empDao.delete(empId);
		
		
	}

	@Override
	public Employee findById(Integer empId) {
		Employee emp = null;
		if(empId != null){
			emp = empDao.findById(empId);
		}
		return emp;
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> list = null;
		list = empDao.getAll();
		return list;
	}

	@Override
	public List<Employee> getAll(String empName) {
		List<Employee> list = null;
		if(empName != null){
			list = empDao.getAll(empName);
		}
		return list;
	}

	@Override
	public void deleteMany(int[] ids) {
		if(ids != null && ids.length > 0){
			//循环遍历
			for(int id : ids){
				//依次删除
				empDao.delete(id);
			}
		}
		
	}


	
}
