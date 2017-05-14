package com.bie.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/** 
* @author ����:������
* @version ����ʱ��:2017��5��14�� ����10:47:06 
* ��˵�� 
* ����������Ҫ�����û��Ƿ��½:
* 	ֻ�е�½�˲��ܽ��в��������룬ɾ�������£���ѯ
* 
*/

public class UserInterceptor extends AbstractInterceptor{

	
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) 
			throws Exception {
		//�õ���ǰִ�еķ��� 
		String methodName = invocation.getProxy().getMethod();
		
		//�õ�ActionContext����
		ActionContext ac = invocation.getInvocationContext();
		
		//��ȡsession,��session�л�ȡ��½�Ĺ���Ա�˺�
		Object obj = ac.getSession().get("adminInfo");
		
		//�ж��Ƿ��½
		//�ж�login.jspҳ���list.jspҳ��
		if(!"login".equals(methodName) && !"list".equals(methodName)){
			//���û��½���ͽ�����֤
			if(obj == null){
				//û�е�½�ķ��ص���½ҳ��
				return "loginGlobal";
			}else{
				//�����½������
				return invocation.invoke();
			}
			
		}else{
			//�����½�ˣ�������ʵ�½���б�չʾ
			return invocation.invoke();
		}
	
	}

	
}
