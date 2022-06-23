<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="UTF-8">
<title>自己管理アプリ</title>
<link rel="stylesheet" type="text/css" href="/selfManagement/css/common.css">
</head>
 <body>
   <div class="wrapper">
	<header class="header">
	<h1 id="sm"><a href="/selfManagement/MenuServlet"><img src="/selfManagement/img/iii.png" width="400" height="130" alt="Self Managment" ></a></h1>
    <hr>
<nav>
 <ul>
   <li><a href="S_listServlet">スケジュール</a></li>
   <li><a href="H_listServlet">家計簿</a></li>
   <li><a href=U_updateServlet>ユーザー更新</a></li>
   <li><a href="LogoutServlet">ログアウト</a></li>
 </ul>
</nav>
<hr>
</header>
  <div class="container">
   <div class="contents">
   <h2><c:out value="${result.title}" /><br>
    <a href="${result.backTo}"><c:out value="${result.backToWhere}" /></a><br>
    <a href="${result.back}"><c:out value="${result.backWhere}" /></a><br>
   </h2>
   </div>
   </div>

<hr>
<footer>
 <p>&copy;Copyright 川崎.java. All rights reserved.</p>
</footer>
</div>
</body>
</html>