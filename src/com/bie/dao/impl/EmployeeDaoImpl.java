package com.bie.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.bie.dao.EmployeeDao;
import com.bie.po.Employee;

/** 
* @author ����:������
* @version ����ʱ��:2017��5��11�� ����8:37:10 
* ��˵�� 
*/

public class EmployeeDaoImpl implements EmployeeDao{

	//Ioc����ע�뵽sessionFactory
	private SessionFactory SessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		SessionFactory = sessionFactory;
	}
	
	@Override
	public void save(Employee emp) {
		//����Ա������Ϣ
		SessionFactory.getCurrentSession().save(emp);
	}

	@Override
	public void update(Employee emp) {
		//�޸�Ա������Ϣ
		SessionFactory.getCurrentSession().update(emp);
	}

	@Override
	public void delete(Integer empId) {
		//ɾ��Ա������Ϣ
		//HQL������ִ�Сд������/���������ϸ����ִ�Сд�����ݿ�ؼ��ֲ�����
		//ɾ����ʱ��ע��дexecuteUpdate
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
		//����ģ����ѯ
		@SuppressWarnings("unchecked")
		List<Employee> list = SessionFactory.getCurrentSession()
		.createQuery("from Employee where empName like ? ")
		.setParameter(0, "%"+empName+"%")
		.list();
		
		return list;
	}



	
}
