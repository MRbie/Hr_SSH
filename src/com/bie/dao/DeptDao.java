package com.bie.dao;

import java.util.List;

import com.bie.po.Dept;

/** 
* @author 作者:别先生
* @version 创建时间:2017年5月11日 上午8:26:50 
* 类说明 
* 部门的dao层(数据交互层)
*/

public interface DeptDao {

	/***
	 * 查询部门的所有信息
	 * @return 返回部门的所有信息
	 */
	public List<Dept> getAll();
	
	/***
	 * 根据部门编号进行查询
	 * @param deptId 部门的编号
	 * @return 返回查询的部门信息
	 */
	public Dept findById(Integer deptId);
}
