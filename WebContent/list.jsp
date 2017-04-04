<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SSM List</title>
</head>
<body>
<form action="add.do" method="post">
<table width="80%" align="center">
<tr>
<td>编号</td>
<td><input type="text" name="id"></td>
</tr>
<tr>
<td>姓名</td>
<td><input type="text" name="name"></td>
</tr>
<tr>
<td>年龄</td>
<td><input type="text" name="age"></td>
</tr>
</table>
<input type="hidden" name="password" value="123456">
<input type="hidden" name="gender" value="1">
<input type="hidden" name="bio" value="123456">
<input type="hidden" name="avatar" value="0">
<input type="hidden" name="regdate" value="2017-04-03 13:37:00">
<input type="submit" value="添加">
</form>
<table width="80%" align="center">
	<tr>
		<td>编号</td>
		<td>姓名</td>
		<td>年龄</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${list }" var="bean">
	<tr>
		<td>${bean.id }</td>
		<td>${bean.name }</td>
		<td>${bean.age }</td>
		<td><a href="modify.do?id=${bean.id }">编辑</a><a href="delete.do?id=${bean.id }">删除</a> </td>
	</tr>
	</c:forEach>
</table>
</body>
</html>