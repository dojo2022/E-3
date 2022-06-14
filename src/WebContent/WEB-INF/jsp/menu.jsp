<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Self Management</title>
</head>
<body>
		<!--ヘッダー-->
		<header class="header">
		<h1 class="title"><a href="/selfManagement/MenuServlet">Self Management</a></h1>
		ユーザー更新
		<hr>
		<!--カテゴリー-->

		<ul>
			<li><a href="/selfManagement/S_listServlet">スケジュール</a></li>
			<li><a href="/selfManagement/H_listServlet">家計簿</a></li>
			<li><a href="/selfManagement/U_updateServlet">ユーザー更新</a></li>
			<li><a href="/selfManagement/LogoutServlet">ログアウト</a></li>
		</ul>

		<hr>
		</header>
		<!--ヘッダーここまで-->
<main>


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