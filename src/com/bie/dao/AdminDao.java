package com.bie.dao;

import com.bie.po.Admin;

/** 
* @author ����:������
* @version ����ʱ��:2017��5��11�� ����8:23:30 
* ��˵�� 
* ����Ա��dao��(���ݽ�����)
*/

public interface AdminDao {

	/***
	 * ����Ա����ķ���
	 * @param admin ����Ա����
	 */
	public void save(Admin admin);
	
	
	/***
	 * ���ݹ���Ա��Ϣ���в�ѯ�ķ��� 
	 * @param admin ����Ա����
	 * @return ���ز�ѯ��Ľ��
	 */
	public Admin findByAdmin(Admin admin);
	
}
