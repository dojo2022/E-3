<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Self Management</title>
</head>
<body>
<h2>ログインしてください</h2>
<hr>
<form method="POST" action="/selfManagement/LoginServlet">
<table>
	<tr>
	<td><input type="text" name="login_id"></td>
	</tr>
	<tr>
	<td><input type="password" name="password"></td>
	</tr>
</table>
<input type="button" name="login" value="ログイン">
<p><a href="/selfManagement/U_registServlet">新規登録</a></p>
</form>
</body>
<footer>
<p>
&copy;Copyright 川崎.java. All rights reserved.
</p>
</footer>
</html>