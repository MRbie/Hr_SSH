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
* @author ����:������
* @version ����ʱ��:2017��5��11�� ����4:57:09 
* ��˵�� 
* Ա����action:Ա���Ŀ���������
* 
*/

public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>,RequestAware{

	private static final long serialVersionUID = 1L;
	
	//ʹ��struts2��ģ���������봴��Ա������
	private Employee employee = new Employee();
	
	//��addEmp���������ŵ�deptId���з�װ
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
		// struts2ģ��������ʹ��
		return employee;
		//����ʵ������Ա������
	}
	
	
	//����ÿ�ζ�д��ȡrequest
	private Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	//ע��service
	private EmployeeService empService ;
	public void setEmpService(EmployeeService empService) {
		this.empService = empService;
	}
	
	//ע�벿��service
	private DeptService deptService;
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}
	
	
	/***
	 * Ա��չʾ�Ŀ��Ʋ㷽��
	 * @return
	 */
	public String list(){
		//����ѯ�Ľ�����ݱ��浽������
		List<Employee> listEmp = empService.getAll();
		
		//ʹ��ActonContext��ȡ��request,���浽request��
		//Map<String, Object> requestMap = (Map<String, Object>) ActionContext.getContext().get("request");
		//ʹ�û�ȡ����request�����ѯ�Ľ��
		//requestMap.put("listEmp", listEmp);
		
		
		request.put("listEmp", listEmp);
		return "list";
	}
	
	
	/***
	 * ���Ա�������뵽���ҳ��
	 * @return
	 */
	public String addEmp(){
		//��ѯ���в��ŵ���Ϣ
		List<Dept> listDept = deptService.getAll();
		
		//����ѭ��������ŵ���Ϣ
		request.put("listDept", listDept);
		
		return "addEmp";
	}
	
	/***
	 * ���Ա�������Ա������
	 * @return
	 */
	public String save(){
		
		//���ݲ��ű�Ž��в�ѯ����
		Dept dept = deptService.findById(deptId);
		
		//Ȼ�����õ�Ա����
		employee.setDept(dept);
		
		//����employee��service������Ա������
		//����Ĳ���������ģ�������Ĳ���
		empService.save(employee);
		
		//�ض���action
		return "listAction";
	}


	
	//�޸�Ա����Ϣ�������޸���ͼ
	public String updateEmp(){
		//��ȡҪ�޸ĵ�Ա���ı��
		int id = employee.getEmpId();
		
		//����Ա����������ѯԱ������Ϣ(lazy="false")
		Employee emp = empService.findById(id);
		
		//��ѯ���еĲ��ŵ���Ϣ
		//�Ѿ��в�����Ϣ
		List<Dept> listDept = deptService.getAll();
		
		//���ݻ���
		ValueStack vs = ActionContext.getContext().getValueStack();
		//�Ƴ�ջ��Ԫ��
		vs.pop();
		//��ջ
		vs.push(emp);
		
		//����
		request.put("listDept", listDept);
		
		
		return "updateEmp";
	}
	
	//�޸�Ա����Ϣ��ȷ���޸�
	public String update(){
		
		//1���ȸ��ݲ��ű�ţ���ѯ���Ŷ��������õ�Ա��������
		Dept dept = deptService.findById(deptId);
		
		employee.setDept(dept);
		//2������Ա��
		empService.update(employee);
		
		//����ض����б�
		return "listAction";
	}
	
	
	//ɾ��Ա����Ϣ
	public String empDelete(){
		//��ȡҪɾ��Ա��������
		int empId = employee.getEmpId();
		
		System.out.println("empId:"+empId);
		
		//����ɾ���ķ���
		empService.delete(empId);
		
		return "listAction";
	}
	
	
	//��ѯ�û�
	public String selectEmp(){
		
		//��ȡҳ�洫����Ա������
		String empName = employee.getEmpName();
		
		System.out.println("empName: "+empName);
		
		//����Ա�����������в�ѯ
		List<Employee> list =  empService.getAll(empName);
		
		//����ѯ�Ľ�����浽request��
		//ֻ�б����listEmp�������һ�£����ܲ�ѯ������
		request.put("listEmp", list);
		
		return "list";
	}
	
	
	
}



