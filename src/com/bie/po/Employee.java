package com.bie.po;

/** 
* @author ����:������
* @version ����ʱ��:2017��5��10�� ����7:31:16 
* ��˵�� 
* Ա����ʵ����
*/

public class Employee {

	private Integer empId;//Ա���ı��
	private String empName;//Ա��������
	private String salary;//Ա����н��
	
	private Dept dept;//���һ�����Ա������һ�����ţ���������name=dept
	
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
