<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>自己管理アプリ</title>
</head>
<body>
<h1>Self Managment</h1>
<h2></h2>
<nav>
 <ul>
   <li><a href="S_listServlet">スケジュール</a></li>
   <li><a href="H_listServlet">家計簿</a></li>
   <li><a href=U_updateDeleteServlet>ユーザー更新</a></li>
   <li><a href="LogoutServlet">ログアウト</a></li>
 </ul>
</nav>
<div>
<p><c:out value="${result.message}" /></p>
<a href="${result.backTo}">画面へ</a>
<a href="${result.backTo}">戻る</a>
</div>
</body>
<footer>
 <p>川崎.java</p>
 <p>&copy;Copyright plusDOJO(SE plus). All rights reserved.</p>
</footer>