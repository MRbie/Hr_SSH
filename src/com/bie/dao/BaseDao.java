package com.bie.dao;

import java.util.List;


/** 
* @author ����:������
* @version ����ʱ��:2017��5��12�� ����9:36:35 
* ��˵�� 
* �����Ľӿ�dao��:������������ݽ�����
* 
*/

public interface BaseDao<T> {

	/***
	 * ����������Ϣ
	 * @param emp �������
	 */
	public void save(T emp);
	
	/***
	 * ���¶������Ϣ
	 * @param emp �������
	 */
	public void update(T emp);
	
	/**
	 * ɾ���������Ϣ
	 * @param empId ����ı��
	 */
	public void delete(Integer empId);
	
	/***
	 * ���ݶ����Ž��в�ѯ�������Ϣ
	 * @param empId ����ı��
	 * @return ���ض������Ϣ
	 */
	public T findById(Integer empId);
	
	
	/***
	 * ��ѯ�����������Ϣ
	 * @return
	 */
	public List<T> getAll();
	
	
}
