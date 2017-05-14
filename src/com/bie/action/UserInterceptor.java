package com.bie.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/** 
* @author 作者:别先生
* @version 创建时间:2017年5月14日 上午10:47:06 
* 类说明 
* 拦截器，主要检验用户是否登陆:
* 	只有登陆了才能进行操作，插入，删除，更新，查询
* 
*/

public class UserInterceptor extends AbstractInterceptor{

	
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) 
			throws Exception {
		//得到当前执行的方法 
		String methodName = invocation.getProxy().getMethod();
		
		//得到ActionContext对象
		ActionContext ac = invocation.getInvocationContext();
		
		//获取session,从session中获取登陆的管理员账号
		Object obj = ac.getSession().get("adminInfo");
		
		//判断是否登陆
		//判断login.jsp页面和list.jsp页面
		if(!"login".equals(methodName) && !"list".equals(methodName)){
			//如果没登陆，就进行验证
			if(obj == null){
				//没有登陆的返回到登陆页面
				return "loginGlobal";
			}else{
				//如果登陆，放行
				return invocation.invoke();
			}
			
		}else{
			//如果登陆了，允许访问登陆，列表展示
			return invocation.invoke();
		}
	
	}

	
}
