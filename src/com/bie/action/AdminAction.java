package com.bie.action;

import com.bie.po.Admin;
import com.bie.service.AdminService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/** 
* @author ����:������
* @version ����ʱ��:2017��5��11�� ����4:57:18 
* ��˵�� 
* ����Ա��action:��½ģ��
*/

public class AdminAction extends ActionSupport implements ModelDriven<Admin>{

	
	private static final long serialVersionUID = 1L;
	//����Աʵ�����ģ������
	private Admin admin = new Admin();
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	//����Ա��service��aop
	private AdminService adminService;
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	
	//ʵ��ģ������������admin
	@Override
	public Admin getModel() {
		return this.admin;
	}

	/***
	 * ����Ա��½�ķ��� 
	 * @return
	 *//*
	public String loginAdmin(){
		System.out.println("��½ҳ�洫������......"+admin.getAdminName()+" "+admin.getAdminPwd());	
		
		
		//����Ա��½����
		Admin adminInfo = adminService.login(admin);
		
		
		System.out.println("adminInfo: " + adminInfo);
		
		if(adminInfo == null){
			System.out.println("adminLogin is null !!!!");
			//��½ʧ��
			return "loginFaild";
		}else{
			//��½�ɹ�,�����½����Ϣ
			ActionContext.getContext().getSession().put("adminInfo", adminInfo);
			
			//��½�ɹ�����ת����ҳ
			return "index";
		}
	}
	*/
	
	
	public String login(){
		
		Admin adminInfo = adminService.login(admin);
		
		if(adminInfo == null){
			//�������Ϊ��
			
			return "loginFaild";
		}else{
			
			//��ֵ���õ�session��
			ActionContext.getContext().getSession().put("adminInfo", adminInfo);
			return "login";
		}
	}
	
	public String register(){
		
		System.out.println("ע��ķ�����"+admin.getAdminName()+" "+admin.getAdminPwd());
		
		//ע�ᱣ��֮����ת����½��ҳ��
		adminService.register(admin);
		
		return "register";
	}
	
}
