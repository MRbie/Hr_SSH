package com.bie.service.impl;

import com.bie.dao.AdminDao;
import com.bie.po.Admin;
import com.bie.service.AdminService;

/** 
* @author ����:������
* @version ����ʱ��:2017��5��11�� ����9:44:58 
* ��˵�� 
*/

public class AdminServiceImpl implements AdminService{

	//ע��dao��һ��Ҫʹ�ýӿڽ���
	private AdminDao adminDao;
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	@Override
	public void register(Admin admin) {
		if(admin != null){
			adminDao.save(admin);
		}
	}

	@Override
	public Admin login(Admin admin) {
		Admin adminInfo = adminDao.findByAdmin(admin);
		
		System.out.println("service�㣺"+adminInfo.getAdminName()+" "+adminInfo.getAdminPwd());
		return adminInfo;
	}

	
}
