<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>欢迎进入</title>
<script type="text/javascript" src="<%=basePath %>resources/js/jquery-1.8.0.min.js"></script>

<body>
<h1>添加新的机器人回复消息</h1>

<form action="<%=path %>/admin/addNewCommand"  id="addCommandForm" method="get">
<table>
<tr>
    <td>指令:</td><td><input type="text" value="" name="name"></td>

</tr>
<tr>
    <td>描述:</td><td><input type="text" value="" name="description"></td>
</tr>
<tr>
    <td>回复描述:</td><td><input type="text" value="" name="contentdescription"></td>
    <td>回复内容:</td><td><input type="text" value="" name="content"></td>
</tr>
<tr>
    <td><input type="submit" value="添加"></td>
</tr>
</table>
<span>${status}</span>
<a href="<%=path %>/admin/gotoMessageManage">返回</a>
</form>
</body>
</html>