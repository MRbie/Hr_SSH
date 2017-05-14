package com.bie.po;

/** 
* @author 作者:别先生
* @version 创建时间:2017年5月10日 下午7:31:16 
* 类说明 
* 员工的实体类
*/

public class Employee {

	private Integer empId;//员工的编号
	private String empName;//员工的名称
	private String salary;//员工的薪资
	
	private Dept dept;//多对一，多个员工对用一个部门，所以配置name=dept
	
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	
	
	
	
	
}
