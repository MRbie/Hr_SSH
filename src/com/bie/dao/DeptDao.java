package com.bie.dao;

import java.util.List;

import com.bie.po.Dept;

/** 
* @author ����:������
* @version ����ʱ��:2017��5��11�� ����8:26:50 
* ��˵�� 
* ���ŵ�dao��(���ݽ�����)
*/

public interface DeptDao {

	/***
	 * ��ѯ���ŵ�������Ϣ
	 * @return ���ز��ŵ�������Ϣ
	 */
	public List<Dept> getAll();
	
	/***
	 * ���ݲ��ű�Ž��в�ѯ
	 * @param deptId ���ŵı��
	 * @return ���ز�ѯ�Ĳ�����Ϣ
	 */
	public Dept findById(Integer deptId);
}
