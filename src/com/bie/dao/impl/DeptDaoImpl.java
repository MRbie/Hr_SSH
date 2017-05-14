package com.bie.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.bie.dao.DeptDao;
import com.bie.po.Dept;

/** 
* @author 作者:别先生
* @version 创建时间:2017年5月11日 上午8:38:31 
* 类说明 
*/

public class DeptDaoImpl implements DeptDao{

	//Ioc容器注入到sessionFactory对象中
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
		//根据编号进行查询，即传入编号获取返回的信息
		Dept dept = (Dept) SessionFactory.getCurrentSession().get(Dept.class, deptId);
		
		return dept;
	}

}
