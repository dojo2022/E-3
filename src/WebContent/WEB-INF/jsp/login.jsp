<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Self Management</title>
</head>
<body>
		<!--ヘッダー-->
		<header class="header">
		<h1 class="title"><a href="/selfManagement/LoginServlet">Self Management</a></h1>
<hr>
		</header>
<h2>ログインしてください</h2>
<form method="POST" action="/selfManagement/LoginServlet">
<table>
	<tr>
	<td><input type="text" class="textbox" name="ID"></td>
	</tr>
	<tr>
	<td><input type="password" class="textbox" name="PW"></td>
	</tr>
	<tr>
	</tr>
</table>
<input type="submit" name="login" value="ログイン">
<p><a href="/selfManagement/U_registServlet">新規登録</a></p>
</form>
<footer>
<p>
&copy;Copyright 川崎.java. All rights reserved.
</p>
</footer>
</body>
</html>
