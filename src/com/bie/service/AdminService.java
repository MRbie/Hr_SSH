package com.bie.service;

import com.bie.po.Admin;

/** 
* @author ����:������
* @version ����ʱ��:2017��5��11�� ����9:33:40 
* ��˵�� 
* ����Ա��ҵ���߼���
*/

public interface AdminService {

	/***
	 * ����Աע��
	 * @param admin ����Ա����
	 */
	public void register(Admin admin);
	
	/***
	 * ����Ա��½
	 * @param admin ����Ա����
	 * @return ���ص�½����Ϣ
	 */
	public Admin login(Admin admin);

}
