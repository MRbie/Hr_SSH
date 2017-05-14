package com.bie.po;

/** 
* @author 作者:别先生
* @version 创建时间:2017年5月10日 下午7:29:31 
* 类说明 
* 部门的实体类
*/

public class Dept {

	private Integer deptId;//部门编号
	private String deptName;//部门名称
	
	
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
