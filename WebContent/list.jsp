<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工信息列表展示的页面</title>

<!-- 使用bootstrap优化页面 -->
<script type="text/javascript" src="resource/js/jquery.js"></script>
<script type="text/javascript" src="resource/js/bootstrap.min.js"></script>

<link href="resource/css/bootstrap.min.css" rel="stylesheet" />

<style type="text/css">
	tr th,td{text-align:center;}
</style>

</head>
<body>

<center>
<h1>企业人事管理系统</h1>

<s:if test="#session.adminInfo != null">
<%-- <h2 align="right">欢迎您管理员：${adminInfo.adminName }</h2> --%>

<h2 align="right">欢迎您管理员：
	<s:property value="#session.adminInfo.adminName"/>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<s:a href="#">退出</s:a>
</h2>

</s:if>
<s:else>
	<s:a href="login.jsp">登陆</s:a>
	<s:a href="register.jsp">注册</s:a>
</s:else>



<s:form method="post" action="/emp_selectEmp.action"> 
	<div class="row alert alert-info" style="margin:0px;padding:5px;">
		<div style="width:250px;">
			<label>员工姓名:</label> 
			<input type="text" name="empName" value="${empName }"  class="form-control" placeholder="请输入员工姓名查询"/>
			
		</div>
		<input type="submit" class="btn btn-danger" value="查询">
		<!-- href跳转到struts2的result -->
		<s:a href="emp_addEmp">
			<span class="btn btn-success">添加员工</span>
		</s:a>
			
	</div>
	
</s:form>


<table class="table table-striped table-bordered table-hover table-condensed">
	<tr>
		<th>序号</th>
		<th>员工编号</th>
		<th>员工姓名</th>
		<th>员工薪资</th>
		<th colspan="2">操作</th>
	</tr>
	<s:if test="#request.listEmp != null">
		<s:iterator var="emp" value="#request.listEmp" status="st">
			<tr>
				<td><s:property value="#st.count"/></td>
				<td><s:property value="#emp.empId +1000"/></td>
				<td><s:property value="#emp.empName"/></td>
				<td><s:property value="#emp.salary"/></td>
				<td>
					<!-- 点击修改，提交到action的updateEmp的方法
						  和之前的servlet一样，修改的时候提交到servlet
					 -->
					<s:a href="emp_updateEmp?empId=%{#emp.empId }">修改</s:a>
				</td>
				<td>
					<s:a href="emp_empDelete?empId=%{#emp.empId }">删除</s:a> 
				</td>
				
			</tr>
		</s:iterator>
	</s:if>
	<s:else>
		<tr>
			<td colspan="4">对不起，请先录入数据哦~~~</td>
		</tr>
	</s:else>

</table>


</center>
</body>
</html>