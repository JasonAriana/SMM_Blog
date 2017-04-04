<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body onload="getPro.do">
<table width="80%" align="center">
	<tr>
		<td>编号</td>
		<td>省</td>
		<td>status</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${pros }" var="bean">
	<tr>
		<td>${bean.id }</td>
		<td>${bean.name }</td>
		<td>${bean.status }</td>
		<td>
		<a href="getCity.do?id=${bean.id }">获取 市</a>
		<!-- <a href="modify.do?id=${bean.id }">编辑</a><a href="delete.do?id=${bean.id }">删除</a> -->
		 </td>
	</tr>
	</c:forEach>
</table>

<table width="80%" align="center">
	<tr>
		<td>编号</td>
		<td>市</td>
		<td>status</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${cities }" var="bean">
	<tr>
		<td>${bean.id }</td>
		<td>${bean.name }</td>
		<td>${bean.status }</td>
		<td><a href="getArea.do?proId=${bean.status }&cityId=${bean.id }">获取 区</a></td>
	</tr>
	</c:forEach>
</table>

<table width="80%" align="center">
	<tr>
		<td>编号</td>
		<td>区</td>
		<td>status</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${areas }" var="bean">
	<tr>
		<td>${bean.id }</td>
		<td>${bean.name }</td>
		<td>${bean.status }</td>
		<td></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>