package com.bie.dao.impl;

import org.hibernate.SessionFactory;

import com.bie.dao.AdminDao;
import com.bie.po.Admin;

/** 
* @author 作者:别先生
* @version 创建时间:2017年5月11日 上午8:37:38 
* 类说明 
*/

public class AdminDaoImpl implements AdminDao{

	//Ioc容器注入到sessionFactory对象
	private SessionFactory SessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		SessionFactory = sessionFactory;
	}
	
	@Override
	public void save(Admin admin) {
		//保存的方法
		SessionFactory.getCurrentSession().save(admin);
	}

	@Override
	public Admin findByAdmin(Admin admin) {
		//登陆的方法，一定返回一个唯一的结果，但是需要确定数据库值的唯一
		Admin adminSession = (Admin) SessionFactory.getCurrentSession()
		.createQuery("from Admin admin where admin.adminName=? and admin.adminPwd = ? ")
		.setParameter(0, admin.getAdminName())
		.setParameter(1, admin.getAdminPwd())
		.uniqueResult();
		
		return adminSession;
	}

	
}
