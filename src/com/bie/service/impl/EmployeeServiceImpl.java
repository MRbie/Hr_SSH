package com.bie.service.impl;

import java.util.List;

import com.bie.dao.EmployeeDao;
import com.bie.po.Employee;
import com.bie.service.EmployeeService;

/** 
* @author ����:������
* @version ����ʱ��:2017��5��11�� ����9:46:16 
* ��˵�� 
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
		//��ý����ж�һ�£������Ƿ�Ϊ��
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
			//ѭ������
			for(int id : ids){
				//����ɾ��
				empDao.delete(id);
			}
		}
		
	}


	
}
