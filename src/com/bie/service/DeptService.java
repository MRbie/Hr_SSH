package com.bie.service;

import java.util.List;

import com.bie.po.Dept;

/** 
* @author ����:������
* @version ����ʱ��:2017��5��11�� ����9:33:50 
* ��˵�� 
* ���ŵ�ҵ���߼���
*/

public interface DeptService {

	/***
	 * ��ȡ���в��ŵ���Ϣ
	 * @param dept ���ŵĶ���
	 * @return �������в��ŵ���Ϣ
	 */
	public List<Dept> getAll();
	
	/***
	 * ���ݲ��ű�Ž��в�ѯ
	 * @param deptId ���ŵı��
	 * @return ���ز�ѯ�Ĳ��ŵ���Ϣ
	 */
	public Dept findById(Integer deptId);
	
}
