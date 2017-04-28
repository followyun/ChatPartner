<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>欢迎进入</title>
<script type="text/javascript" src="<%=basePath %>resources/js/normal/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=basePath %>resources/js/message_manage.js"></script>
<body>
<h1 align="center">聊天内容管理</h1>

<div align="center">
<form action="/admin/queryCommandList" method="get">
<table>
<tr>
    <td>指令:</td><td><input type="text" value="" name="command"></td>
    <td>描述:</td><td><input type="text" value="" name="description"></td>
    <td><input type="submit" value="查询"></td>
</tr>
</table>
</form>
<form action="" id="commandlistForm" method="get">
<table border="1">
<tr>
    <th>选定</th>
    <th>编号</th>
    <th>指令</th>
    <th>描述</th>
    <th>内容</th>
</tr>
<tbody>
<c:forEach items="${commandlist}" var="command" varStatus="status">
<tr>
    <td><input type="checkbox" name="commandid" value="${command.id}"></td>
    <td>${status.index+1}</td>
    <td>${command.name}</td>
    <td>${command.description}</td>
   <td>
   <table border="1" width="100%">
	   <tr>
	    <th>回复描述</th>
	    <th>回复内容</th>
	    <th></th>
	    <th></th>
	   </tr>
    <c:forEach items="${command.contentList}" var="content">
    <tr>
     <td>${content.name}</td>
     <td><textarea cols="40">${content.content}</textarea></td>
      <td><a href="javascript:deleteOneCommandContent('${path}','${content.id}');">删除</a></td>
    <td><a href="<%=basePath %>/admin/gotoUpdateCommandContent?id=${content.id}">修改</a></td>
    </tr>
    </c:forEach>
    </table>
    </td>
</tr>
</c:forEach>
</tbody>
</table>
   </form> 
    <button onclick="javascript:deletecommands('<%=basePath %>');">删除</button>
    <a href="<%=path %>/admin/gotoAddNewCommand">新增</a>
   当前第<span>${page.currentPage}/${page.totalPage}</span>页
    <c:if test="${page.currentPage != 1}">
    <a href="<%=path %>/admin/queryMessageByPage?currentPage=${page.currentPage-1}">上一页</a>
   </c:if>
   <c:if test="${page.currentPage < page.totalPage}">
    <a href="<%=path %>/admin/queryMessageByPage?currentPage=${page.currentPage+1}">下一页</a>
    </c:if>
	    <input id="inputPage" type="text" name="currentPage">	     
	    <button onclick="javascript:gotoThePage('${path}');">跳转</button>

</div>
</body>
</html>