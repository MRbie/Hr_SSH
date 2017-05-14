package com.bie.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.SessionFactory;

import com.bie.dao.BaseDao;
import com.opensymphony.xwork2.config.entities.Parameterizable;

/** 
* @author 作者:别先生
* @version 创建时间:2017年5月12日 下午9:37:02 
* 类说明 
* 
* 所有dao层的通用操作：所有的dao层都集成此类
* 
*/

public class BaseDaoImpl<T> implements BaseDao<T>{

	//当前操作的实际的bean类型
	private Class<T> clazz;
	
	//获取类的名称
	private String className;
	
	//反射泛型
	//构造函数
	public BaseDaoImpl() {
		Type type = this.getClass().getGenericSuperclass();
		//转换为参数化类型，BaseDao<Employee>
		ParameterizedType pt = (ParameterizedType) type;
		//得到实际类型
		Type[] types = pt.getActualTypeArguments();
		//获取实际类型
		clazz = (Class<T>) types[0];
	
		//获取类的名称
		className = clazz.getSimpleName();
		
	}

	
	//在父类注入sessionFactory
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	
	@Override
	public void save(T t) {
		//提取的公共的保存的方法
		sessionFactory.getCurrentSession().save(t);
		
	}

	@Override
	public void update(T t) {
		//提取公共的修改的方法
		sessionFactory.getCurrentSession().update(t);
	}

	@Override
	public void delete(Integer id) {
		//删除注意最后实现executeUpdate
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
