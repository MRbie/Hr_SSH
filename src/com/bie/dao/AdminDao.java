package com.bie.dao;

import com.bie.po.Admin;

/** 
* @author 作者:别先生
* @version 创建时间:2017年5月11日 上午8:23:30 
* 类说明 
* 管理员的dao层(数据交互层)
*/

public interface AdminDao {

	/***
	 * 管理员保存的方法
	 * @param admin 管理员对象
	 */
	public void save(Admin admin);
	
	
	/***
	 * 根据管理员信息进行查询的方法 
	 * @param admin 管理员对象
	 * @return 返回查询后的结果
	 */
	public Admin findByAdmin(Admin admin);
	
}
