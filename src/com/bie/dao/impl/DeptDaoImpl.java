package com.bie.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.bie.dao.DeptDao;
import com.bie.po.Dept;

/** 
* @author ����:������
* @version ����ʱ��:2017��5��11�� ����8:38:31 
* ��˵�� 
*/

public class DeptDaoImpl implements DeptDao{

	//Ioc����ע�뵽sessionFactory������
	private SessionFactory SessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		SessionFactory = sessionFactory;
	}
	
	
	@Override
	public List<Dept> getAll() {
		@SuppressWarnings("unchecked")
		List<Dept> list = SessionFactory.getCurrentSession()
				.createQuery("from Dept")
				.list();
		
		return list;
	}

	@Override
	public Dept findById(Integer deptId) {
		//���ݱ�Ž��в�ѯ���������Ż�ȡ���ص���Ϣ
		Dept dept = (Dept) SessionFactory.getCurrentSession().get(Dept.class, deptId);
		
		return dept;
	}

}
