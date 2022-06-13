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
<form method="POST" action="/selfManagement/U_updateServlet">
<!--
初期値を表示するやつのメモ
<items="${user？？？}">
入力欄にもvalue=""で初期値を入れるはず
-->
<table>
	<tr>
	<td><h2>貯金理由</h2></td>
	</tr>
	<tr>
	<td><input type="text" value="フェス！！！" readonly></td><td>&#9654;</td><td><input type="text" name="reason"></td>
	</tr>
	<tr>
</table>
<br>
<table>
	<tr>
	<td><h2>達成期限</h2></td>
	</tr>
	<tr>
	<td><input type="month" value="" readonly></td><td>&#9654;</td><td><input type="month" name="deadline"></td>
	</tr>
	<tr>
</table>
<br>
<table>
	<tr>
	<td><h2>目標金額</h2></td>
	</tr>
	<tr>
	<td><input type="text" value="" readonly></td><td>&#9654;</td><td><input type="text" name="goal"></td>
	</tr>
	<tr>
</table>
<br>
<table>
	<tr>
	<td><h2>給料</h2></td>
	</tr>
	<tr>
	<td><input type="text" value="" readonly></td><td>&#9654;</td><td><input type="text" name="salary"></td>
	</tr>
	<tr>
</table>
<br>
<table>
	<tr>
	<td><h2>暑がり寒がり</h2></td>
	</tr>
	<tr>
	<td><input type="text" value="" readonly></td><td>&#9654;</td><td><select name="constitution"><option>普通</option><option>暑がり</option><option>寒がり</option></select></td>
	</tr>
</table>
<input type="button" name="update" value="更新">
</form>
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