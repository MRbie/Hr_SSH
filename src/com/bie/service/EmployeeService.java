package com.bie.service;

import java.util.List;

import com.bie.po.Employee;

/** 
* @author 作者:别先生
* @version 创建时间:2017年5月11日 上午9:34:05 
* 类说明 
* 员工的业务逻辑层
*/

public interface EmployeeService {

	/***
	 * 保存员工的信息
	 * @param emp 员工对象
	 */
	public void save(Employee emp);
	
	/***
	 * 更新员工的信息
	 * @param emp 员工对象
	 */
	public void update(Employee emp);
	
	/**
	 * 删除员工的信息
	 * @param empId 员工的编号
	 */
	public void delete(Integer empId);
	
	/***
	 * 根据员工编号进行查询员工的信息
	 * @param empId 员工的编号
	 * @return 返回员工的信息
	 */
	public Employee findById(Integer empId);
	
	
	/***
	 * 查询员工的所有信息
	 * @return
	 */
	public List<Employee> getAll();
	
	/***
	 * 根据员工的姓名进行查询
	 * @param empName 员工的姓名
	 * @return 返回员工的信息
	 */
	public List<Employee> getAll(String empName);
	
	/***
	 * 删除多个用户
	 * @param ids
	 */
	public void deleteMany(int[] ids);
	
	
}
