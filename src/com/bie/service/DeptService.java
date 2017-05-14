package com.bie.service;

import java.util.List;

import com.bie.po.Dept;

/** 
* @author 作者:别先生
* @version 创建时间:2017年5月11日 上午9:33:50 
* 类说明 
* 部门的业务逻辑层
*/

public interface DeptService {

	/***
	 * 获取所有部门的信息
	 * @param dept 部门的对象
	 * @return 返回所有部门的信息
	 */
	public List<Dept> getAll();
	
	/***
	 * 根据部门编号进行查询
	 * @param deptId 部门的编号
	 * @return 返回查询的部门的信息
	 */
	public Dept findById(Integer deptId);
	
}
