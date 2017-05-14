package com.bie.dao.impl;

import org.hibernate.SessionFactory;

import com.bie.dao.AdminDao;
import com.bie.po.Admin;

/** 
* @author ����:������
* @version ����ʱ��:2017��5��11�� ����8:37:38 
* ��˵�� 
*/

public class AdminDaoImpl implements AdminDao{

	//Ioc����ע�뵽sessionFactory����
	private SessionFactory SessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		SessionFactory = sessionFactory;
	}
	
	@Override
	public void save(Admin admin) {
		//����ķ���
		SessionFactory.getCurrentSession().save(admin);
	}

	@Override
	public Admin findByAdmin(Admin admin) {
		//��½�ķ�����һ������һ��Ψһ�Ľ����������Ҫȷ�����ݿ�ֵ��Ψһ
		Admin adminSession = (Admin) SessionFactory.getCurrentSession()
		.createQuery("from Admin admin where admin.adminName=? and admin.adminPwd = ? ")
		.setParameter(0, admin.getAdminName())
		.setParameter(1, admin.getAdminPwd())
		.uniqueResult();
		
		return adminSession;
	}

	
}
