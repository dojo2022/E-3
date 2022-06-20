<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Self Management</title>
<link rel="stylesheet" type="text/css" href="/selfManagement/css/common.css">
</head>
  <body>
	<!--ヘッダー-->
	<header class="header">
		<h1 id="sm"><a href="/selfManagement/MenuServlet"><img src="/selfManagement/img/iii.png" width="400" height="130" alt="Self Managment" ></a></h1>
		<div>
		 <p>ユーザー更新ページ</p>
		</div>
	<hr>
	<!--カテゴリー-->
    <nav class="nav">
	<ul>
		<li><a href="/selfManagement/S_listServlet">スケジュール</a></li>
		<li><a href="/selfManagement/H_listServlet">家計簿</a></li>
		<li><a href="/selfManagement/U_updateServlet">ユーザー更新</a></li>
		<li><a href="/selfManagement/LogoutServlet">ログアウト</a></li>
	</ul>
    </nav>
	<hr>
	</header>

<!--ヘッダーここまで-->
  <main>
	<div class="container">
	 <div class="contents">
      <form method="POST" action="/selfManagement/U_updateServlet">
      <input type="hidden" value="${user.user_id}">

		<h2>貯金理由</h2>
		<input type="text" value="" readonly>
		&#9654;
		<input type="text" name="reason">

      <br>
     <h2>達成期限</h2>

     <input type="date" value="${user.deadline}" readonly>
     &#9654;
     <input type="date" name="deadline">

      <br>
		<h2>目標金額</h2>
		<input type="text" value="${user.goal}" readonly>
		&#9654;
		<input type="text" name="goal">

      <br>
	    <h2>給料</h2>
		<input type="text" value="${user.salary}" readonly>
		&#9654;
		<input type="text" name="salary">
      <br>
	   <h2>暑がり寒がり</h2>
		<input type="text" value="${user.constitution}" readonly>
		&#9654;

			<select name="constitution">
				<option hidden> ${user.constitution}</option>
				<option>普通</option>
				<option>暑がり</option>
				<option>寒がり</option>
			</select>

      <div class="button1"><input type="button" name="update" value="更新"></div>
     </form>
   </div>
  </div>
 </main>
		<!--フッター-->
		<hr>
		<footer>
		<p>
		&copy;Copyright 川崎.java. All rights reserved.
		</p>
		</footer>
		<!--フッターここまで-->
</body>
</html>