<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="update.do" method="post">
<table width="80%" align="center">
<tr>
<td>编号</td>
<td>${user.id } <input type="hidden" name="id" value="${user.id }"> </td>
</tr>
<tr>
<td>姓名</td>
<td><input type="text" name="name" value="${user.name }"></td>
</tr>
<tr>
<td>年龄</td>
<td><input type="text" name="age" value="${user.age }"></td>
</tr>
</table>
<input type="submit" value="修改">
</form>
</body>
</html>