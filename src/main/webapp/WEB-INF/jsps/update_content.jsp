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
<h1>修改回复内容</h1>

<form action="<%=path %>/admin/updateCommandContent"  id="addCommandForm" method="post">
<%-- 隐藏两个内容不让用户看见 --%>
<input type="hidden" value="${commandContents.id}" name="id">
<input type="hidden" value="${commandContents.commandId}" name="commandId">
<table>
<tr>
    <td>回复描述:</td><td><input type="text" value="${commandContents.name}" name="name"></td>
    <td>回复内容:</td><td><textarea type="text" name="content" cols="40" rows="4">${commandContents.content}</textarea></td>
</tr>
<tr>
    <td><input type="submit" value="更新"></td>
</tr>
</table>
<span>${status}</span>
<a href="<%=path %>/admin/gotoMessageManage">返回</a>
</form>
</body>
</html>