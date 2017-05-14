package com.bie.dao;

import java.util.List;

import com.bie.po.Dept;
import com.bie.po.Employee;

/** 
* @author ����:������
* @version ����ʱ��:2017��5��11�� ����8:30:08 
* ��˵�� 
* Ա����Ϣ��dao��(���ݽ�����)
*/

public interface EmployeeDao {

	/***
	 * ����Ա������Ϣ
	 * @param emp Ա������
	 */
	public void save(Employee emp);
	
	/***
	 * ����Ա������Ϣ
	 * @param emp Ա������
	 */
	public void update(Employee emp);
	
	/**
	 * ɾ��Ա������Ϣ
	 * @param empId Ա���ı��
	 */
	public void delete(Integer empId);
	
	/***
	 * ����Ա����Ž��в�ѯԱ������Ϣ
	 * @param empId Ա���ı��
	 * @return ����Ա������Ϣ
	 */
	public Employee findById(Integer empId);
	
	
	/***
	 * ��ѯԱ����������Ϣ
	 * @return
	 */
	public List<Employee> getAll();
	
	/***
	 * ����Ա�����������в�ѯ
	 * @param empName Ա��������
	 * @return ����Ա������Ϣ
	 */
	public List<Employee> getAll(String empName);
	
	
	
}
