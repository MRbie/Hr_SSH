package com.bie.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.bie.dao.EmployeeDao;
import com.bie.po.Employee;

/** 
* @author 作者:别先生
* @version 创建时间:2017年5月11日 上午8:37:10 
* 类说明 
*/

public class EmployeeDaoImpl implements EmployeeDao{

	//Ioc容器注入到sessionFactory
	private SessionFactory SessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		SessionFactory = sessionFactory;
	}
	
	@Override
	public void save(Employee emp) {
		//保存员工的信息
		SessionFactory.getCurrentSession().save(emp);
	}

	@Override
	public void update(Employee emp) {
		//修改员工的信息
		SessionFactory.getCurrentSession().update(emp);
	}

	@Override
	public void delete(Integer empId) {
		//删除员工的信息
		//HQL语句区分大小写，对象/对象属性严格区分大小写，数据库关键字不区分
		//删除的时候注意写executeUpdate
		SessionFactory.getCurrentSession()
		.createQuery("delete Employee emp where emp.empId=? ")
		.setParameter(0, empId)
		.executeUpdate();
		
	}

	@Override
	public Employee findById(Integer empId) {
		Employee emp = (Employee) SessionFactory.getCurrentSession()
		.get(Employee.class, empId);
		
		return emp;
	}

	@Override
	public List<Employee> getAll() {
		@SuppressWarnings("unchecked")
		
		List<Employee> list = (List<Employee>) SessionFactory.getCurrentSession()
		.createQuery(" from Employee ")
		.list();
		return list;
	}

	@Override
	public List<Employee> getAll(String empName) {
		//名称模糊查询
		@SuppressWarnings("unchecked")
		List<Employee> list = SessionFactory.getCurrentSession()
		.createQuery("from Employee where empName like ? ")
		.setParameter(0, "%"+empName+"%")
		.list();
		
		return list;
	}



	
}
