package com.bie.service.impl;

import com.bie.dao.AdminDao;
import com.bie.po.Admin;
import com.bie.service.AdminService;

/** 
* @author 作者:别先生
* @version 创建时间:2017年5月11日 上午9:44:58 
* 类说明 
*/

public class AdminServiceImpl implements AdminService{

	//注入dao，一定要使用接口接受
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
		
		System.out.println("service层："+adminInfo.getAdminName()+" "+adminInfo.getAdminPwd());
		return adminInfo;
	}

	
}
