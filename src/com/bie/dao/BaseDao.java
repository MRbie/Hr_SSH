package com.bie.dao;

import java.util.List;


/** 
* @author 作者:别先生
* @version 创建时间:2017年5月12日 下午9:36:35 
* 类说明 
* 公共的接口dao层:提出公共的数据交互层
* 
*/

public interface BaseDao<T> {

	/***
	 * 保存对象的信息
	 * @param emp 对象对象
	 */
	public void save(T emp);
	
	/***
	 * 更新对象的信息
	 * @param emp 对象对象
	 */
	public void update(T emp);
	
	/**
	 * 删除对象的信息
	 * @param empId 对象的编号
	 */
	public void delete(Integer empId);
	
	/***
	 * 根据对象编号进行查询对象的信息
	 * @param empId 对象的编号
	 * @return 返回对象的信息
	 */
	public T findById(Integer empId);
	
	
	/***
	 * 查询对象的所有信息
	 * @return
	 */
	public List<T> getAll();
	
	
}
