package com.bie.action;

import com.bie.po.Admin;
import com.bie.service.AdminService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/** 
* @author 作者:别先生
* @version 创建时间:2017年5月11日 下午4:57:18 
* 类说明 
* 管理员的action:登陆模块
*/

public class AdminAction extends ActionSupport implements ModelDriven<Admin>{

	
	private static final long serialVersionUID = 1L;
	//管理员实体类的模型驱动
	private Admin admin = new Admin();
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	//管理员的service的aop
	private AdminService adminService;
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	
	//实现模型驱动，返回admin
	@Override
	public Admin getModel() {
		return this.admin;
	}

	/***
	 * 管理员登陆的方法 
	 * @return
	 *//*
	public String loginAdmin(){
		System.out.println("登陆页面传过来了......"+admin.getAdminName()+" "+admin.getAdminPwd());	
		
		
		//管理员登陆操作
		Admin adminInfo = adminService.login(admin);
		
		
		System.out.println("adminInfo: " + adminInfo);
		
		if(adminInfo == null){
			System.out.println("adminLogin is null !!!!");
			//登陆失败
			return "loginFaild";
		}else{
			//登陆成功,保存登陆的信息
			ActionContext.getContext().getSession().put("adminInfo", adminInfo);
			
			//登陆成功，跳转到首页
			return "index";
		}
	}
	*/
	
	
	public String login(){
		
		Admin adminInfo = adminService.login(admin);
		
		if(adminInfo == null){
			//如果返回为空
			
			return "loginFaild";
		}else{
			
			//将值设置到session中
			ActionContext.getContext().getSession().put("adminInfo", adminInfo);
			return "login";
		}
	}
	
	public String register(){
		
		System.out.println("注册的方法："+admin.getAdminName()+" "+admin.getAdminPwd());
		
		//注册保存之后跳转到登陆的页面
		adminService.register(admin);
		
		return "register";
	}
	
}
