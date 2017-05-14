<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册的页面</title>
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
<h2>管理员注册</h2>

<s:form method="post" action="/admin_register" theme="simple">
	<table class="table table-striped table-bordered table-hover table-condensed">
		<tr>
			<td>
				账号：<input type="text" name="adminName"/> 
				<%-- <s:textfield name="adminName"></s:textfield> --%>
			</td>
		</tr>
		<tr>	
			<td>
				密码：<input type="password" name="adminPwd"/>
				<%-- <s:textfield name="adminPwd"></s:textfield> --%>
				
			</td>	
		</tr>
		<tr>
			<td>
				<input type="submit" value="注册"/> 
				<a class="btn btn-success" href="login.jsp">登陆</a>
				<%-- <s:submit value="登陆"></s:submit> --%>
			</td>
		</tr>
	
	
	</table>
	

</s:form>


</center>

</body>
</html>