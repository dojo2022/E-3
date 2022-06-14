<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<form method="POST" action="/selfManagement/S_updateDeleteServlet">
		<table border="1">
				<tr>
				    <td><input type="date" name="s_date" value="${card.s_date}"></input></td>
				    <td>
				    	<select name="s_category">
				    		<option hidden>${userList[0]}</option>
				    		<option>遊び</option>
							<option>休み</option>
							<option>デート</option>
							<option>飲み会</option>
							<option>旅行</option>
							<option>支払期限</option>
							<option>イベント</option>
							<option>その他</option>
						</select>
				    </td>
				    <td><input type="text" name="s_memo" value="${user.salary}"></td>
				    <td><input type="submit" name="update" value="更新"></td>
				    <td><input type="submit" name="delete" value="削除"></td>
			    </tr>
		</table>
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