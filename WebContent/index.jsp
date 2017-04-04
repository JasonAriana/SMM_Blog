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
<body onload="newpost.do">
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
      <a name="TemplateInfo"></a>
      <c:forEach  items="${posts }" var="bean" varStatus="status">
      <h1>${bean.title }</h1>
      <p><c:out value="${fn:substring(bean.content, 0, 80) }"></c:out> </p>
      <p class="post-footer align-right"> <a href="viewPost.do?id=${bean.id }" class="readmore">阅读全文</a> <a href="viewPost.do?id=${bean.id }" class="comments">评论 (${comNum[status.index]})</a>  <c:if test="${not empty user && user.id == bean.author}"> <a href="modifyPost.do?id=${bean.id }" class="readmore">编辑文章</a> <a href="deletePost.do?id=${bean.id }" class="readmore">删除文章</a> </c:if> <span class="date">${bean.addDate}</span> </p>
      </c:forEach>
    </div>
  </div>
  <div id="footer">
    <p> &copy; 2017 <strong>Jason Blog</strong> | Github: <a target="_blank" href="https://github.com/JasonAriana">Github</a> </p>
  </div>
</div>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='utf-8'></script></div>
</body>
</html>