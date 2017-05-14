package com.bie.po;

/** 
* @author 作者:别先生
* @version 创建时间:2017年5月10日 下午7:52:58 
* 类说明 
* 管理员的实体类
*/

public class Admin {

	private Integer adminId;//管理员编号
	private String adminName;//管理员账号
	private String adminPwd;//管理员密码
	
	
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPwd() {
		return adminPwd;
	}
	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}
	
	
	
}
