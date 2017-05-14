package com.bie.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.bie.po.Admin;
import com.bie.po.Dept;
import com.bie.po.Employee;
import com.bie.service.DeptService;
import com.bie.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

/** 
* @author 作者:别先生
* @version 创建时间:2017年5月11日 下午4:57:09 
* 类说明 
* 员工的action:员工的控制器开发
* 
*/

public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>,RequestAware{

	private static final long serialVersionUID = 1L;
	
	//使用struts2的模型驱动必须创建员工对象
	private Employee employee = new Employee();
	
	//对addEmp的下拉部门的deptId进行封装
	private int deptId;
	
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public int getDeptId() {
		return deptId;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Employee getEmployee() {
		return employee;
	}
	@Override
	public Employee getModel() {
		// struts2模型驱动的使用
		return employee;
		//返回实例化的员工对象
	}
	
	
	//避免每次都写获取request
	private Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	//注入service
	private EmployeeService empService ;
	public void setEmpService(EmployeeService empService) {
		this.empService = empService;
	}
	
	//注入部门service
	private DeptService deptService;
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}
	
	
	/***
	 * 员工展示的控制层方法
	 * @return
	 */
	public String list(){
		//讲查询的结果内容保存到集合中
		List<Employee> listEmp = empService.getAll();
		
		//使用ActonContext获取到request,保存到request中
		//Map<String, Object> requestMap = (Map<String, Object>) ActionContext.getContext().get("request");
		//使用获取到的request保存查询的结果
		//requestMap.put("listEmp", listEmp);
		
		
		request.put("listEmp", listEmp);
		return "list";
	}
	
	
	/***
	 * 添加员工，进入到添加页面
	 * @return
	 */
	public String addEmp(){
		//查询所有部门的信息
		List<Dept> listDept = deptService.getAll();
		
		//用于循环输出部门的信息
		request.put("listDept", listDept);
		
		return "addEmp";
	}
	
	/***
	 * 添加员工，添加员工数据
	 * @return
	 */
	public String save(){
		
		//根据部门编号进行查询部门
		Dept dept = deptService.findById(deptId);
		
		//然后设置到员工中
		employee.setDept(dept);
		
		//调用employee的service，保存员工数据
		//传入的参数是上面模型驱动的参数
		empService.save(employee);
		
		//重定向到action
		return "listAction";
	}


	
	//修改员工信息，进入修改视图
	public String updateEmp(){
		//获取要修改的员工的编号
		int id = employee.getEmpId();
		
		//根据员工的主键查询员工的信息(lazy="false")
		Employee emp = empService.findById(id);
		
		//查询所有的部门的信息
		//已经有部门信息
		List<Dept> listDept = deptService.getAll();
		
		//数据回显
		ValueStack vs = ActionContext.getContext().getValueStack();
		//移除栈顶元素
		vs.pop();
		//入栈
		vs.push(emp);
		
		//保存
		request.put("listDept", listDept);
		
		
		return "updateEmp";
	}
	
	//修改员工信息，确认修改
	public String update(){
		
		//1：先根据部门编号，查询部门对象，再设置到员工属性中
		Dept dept = deptService.findById(deptId);
		
		employee.setDept(dept);
		//2：更新员工
		empService.update(employee);
		
		//最后重定向到列表
		return "listAction";
	}
	
	
	//删除员工信息
	public String empDelete(){
		//获取要删除员工的主键
		int empId = employee.getEmpId();
		
		System.out.println("empId:"+empId);
		
		//调用删除的方法
		empService.delete(empId);
		
		return "listAction";
	}
	
	
	//查询用户
	public String selectEmp(){
		
		//获取页面传来的员工姓名
		String empName = employee.getEmpName();
		
		System.out.println("empName: "+empName);
		
		//根据员工的姓名进行查询
		List<Employee> list =  empService.getAll(empName);
		
		//将查询的结果保存到request中
		//只有保存的listEmp和上面的一致，才能查询初内容
		request.put("listEmp", list);
		
		return "list";
	}
	
	
	
}



