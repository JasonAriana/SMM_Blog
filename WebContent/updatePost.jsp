<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Blog</title>
<link rel="stylesheet" href="images/Envision.css" type="text/css" />
</head>
<body>

<script type="text/javascript">
	function isValidate(form){
		title = form.title.value;
		content = form.content.value;
		
		if(title == ""){
			alert("文章标题不能为空");
			return false;
		}else if(content == ""){
			alert("文章内容不能为空");
			return false;
		}
		return true;
	}
</script>

<div id="wrap">
  <div id="header">
    <h1 id="logo-text">Blog</h1>
    <h2 id="slogan">技术博客</h2>
    <div id="header-links">
      <p> <a href="login.jsp">登录</a> | <a href="register.jsp">注册</a> | <a href="logout.do">退出</a> </p>
    </div>
  </div>
  <div  id="menu">
    <ul>
      <li id="current"><a href="getNewPost.do">首页</a></li>
      <li><a href="userhome.do">个人中心</a></li>
      <li class="last"><a href="aboutus.do">关于Blog</a></li>
    </ul>
  </div>
  <div id="content-wrap">
    <div id="sidebar">
      <h1>Search Box</h1>
      <form action="" class="searchform">
        <p>
          <input name="search_query" class="textbox" type="text" />
          <input name="search" class="button" value="Search" type="submit" />
        </p>
      </form>
      <h1>Sidebar Menu</h1>
      <ul class="sidemenu">
        <li><a href="toAddPost.do">写文章</a></li>
      </ul>
      <h1>Wise Words</h1>
      <div class="left-box">
        <p>&quot;Evaluation of the past is the first step toward vision for the future.&quot; </p>
        <p class="align-right">- Chris Widener</p>
      </div>
    </div>
    <div id="main"> 
      <form name="form1" action="updatePost.do" method="POST" onsubmit="return isValidate(form1)">
	      <table width="80%" align="center">
	      	<tr>
	      		<td>标题：</td>
	      		<td><input type="hidden" name="id" value="${post.id}"><input type="text" name="title" value="${post.title}"></td>
	      	</tr>
	      	<tr>
	      		<td>内容：</td>
	      		<td><textarea rows="36" name="content"><c:out value="${post.content}"></c:out> </textarea></td>
	      	</tr>
	      	<tr>
	      		<td>&nbsp;</td>
	      		<td><input class="button" type="submit" value="修改"></td>
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