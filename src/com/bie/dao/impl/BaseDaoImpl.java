package com.bie.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.SessionFactory;

import com.bie.dao.BaseDao;
import com.opensymphony.xwork2.config.entities.Parameterizable;

/** 
* @author ����:������
* @version ����ʱ��:2017��5��12�� ����9:37:02 
* ��˵�� 
* 
* ����dao���ͨ�ò��������е�dao�㶼���ɴ���
* 
*/

public class BaseDaoImpl<T> implements BaseDao<T>{

	//��ǰ������ʵ�ʵ�bean����
	private Class<T> clazz;
	
	//��ȡ�������
	private String className;
	
	//���䷺��
	//���캯��
	public BaseDaoImpl() {
		Type type = this.getClass().getGenericSuperclass();
		//ת��Ϊ���������ͣ�BaseDao<Employee>
		ParameterizedType pt = (ParameterizedType) type;
		//�õ�ʵ������
		Type[] types = pt.getActualTypeArguments();
		//��ȡʵ������
		clazz = (Class<T>) types[0];
	
		//��ȡ�������
		className = clazz.getSimpleName();
		
	}

	
	//�ڸ���ע��sessionFactory
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	
	@Override
	public void save(T t) {
		//��ȡ�Ĺ����ı���ķ���
		sessionFactory.getCurrentSession().save(t);
		
	}

	@Override
	public void update(T t) {
		//��ȡ�������޸ĵķ���
		sessionFactory.getCurrentSession().update(t);
	}

	@Override
	public void delete(Integer id) {
		//ɾ��ע�����ʵ��executeUpdate
		sessionFactory.getCurrentSession()
		.createQuery("delete from " + className + " where id = ? ")
		.setParameter(0, id)
		.executeUpdate();
		
	}

	@Override
	public T findById(Integer id) {
		T t= (T) sessionFactory.getCurrentSession().get(clazz, id);
		return t;
	}

	@Override
	public List<T> getAll() {
		List<T> list = sessionFactory.getCurrentSession()
		.createQuery("from " + className)
		.list();	
		
		return list;
	}

	
}
