package com.bie.po;

/** 
* @author ����:������
* @version ����ʱ��:2017��5��10�� ����7:29:31 
* ��˵�� 
* ���ŵ�ʵ����
*/

public class Dept {

	private Integer deptId;//���ű��
	private String deptName;//��������
	
	
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	@Override
	public String toString() {
		return "Dept [deptId=" + deptId + ", deptName=" + deptName + "]";
	}
	
	
	
}
