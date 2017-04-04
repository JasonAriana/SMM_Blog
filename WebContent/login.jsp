<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="stylesheet" href="images/Envision.css" type="text/css" />
</head>
<body>

<script type="text/javascript">
	function isValidate(form){
		name = form.name.value;
		password = form.password.value;
		
		if(name == ""){
			alert("用户姓名不能为空");
			return false;
		}else if(password == ""){
			alert("密码不能为空");
			return false;
		}
		return true;
	}
</script>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div id="wrap">
  <div id="header">
    <h1 id="logo-text">Blog</h1>
    <h2 id="slogan">技术博客</h2>
    <div id="header-links">
      <p> <a href="login.jsp">登录</a> | <a href="register.jsp">注册</a> | <a href="logout.do">退出</a> </p>
    </div>
  </div>
  <div id="content-wrap">
    <div id="main"> 
		<form name="form1" action="login.do" method="POST" onsubmit="return isValidate(form1)">
		<table width="80%" align="center">
			<tr>
				<td>姓名</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>
					<input type="submit" class="button" value="登录">&nbsp;
					<input type="button" onclick="location.href='register.jsp'" value="注册">
				</td>
			</tr>		
		</table>
		</form>
    </div>
  </div>
  <div id="footer">
    <p> &copy; 2017 <strong>Jason Blog</strong> | Github: <a target="_blank" href="https://github.com/JasonAriana">Github</a> </p>
  </div>
</div>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='utf-8'></script></div>
</body>
</html>