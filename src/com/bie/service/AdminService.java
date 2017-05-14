package com.bie.service;

import com.bie.po.Admin;

/** 
* @author 作者:别先生
* @version 创建时间:2017年5月11日 上午9:33:40 
* 类说明 
* 管理员的业务逻辑层
*/

public interface AdminService {

	/***
	 * 管理员注册
	 * @param admin 管理员对象
	 */
	public void register(Admin admin);
	
	/***
	 * 管理员登陆
	 * @param admin 管理员对象
	 * @return 返回登陆的信息
	 */
	public Admin login(Admin admin);

}
