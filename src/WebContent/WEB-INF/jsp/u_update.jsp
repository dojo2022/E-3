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
<c:forEach var="user" items="${userList}">
<h1><%= request.getAttribute("userList[0]") %>a</h1>
</c:forEach>
<form method="POST" action="/selfManagement/U_updateServlet">
<input type="hidden" value="${user.user_id}">
<table>
	<tr>
		<td><h2>貯金理由</h2></td>
	</tr>
	<tr>
		<td><input type="text" value="" readonly></td>
		<td>&#9654;</td>
		<td><input type="text" name="reason"></td>
	</tr>
	<tr>
</table>
<br>
<table>
	<tr>
	<td><h2>達成期限</h2></td>
	</tr>
	<tr>
		<td><input type="date" value="${user.deadline}" readonly></td>
		<td>&#9654;</td>
		<td><input type="date" name="deadline"></td>
	</tr>
	<tr>
</table>
<br>
<table>
	<tr>
		<td><h2>目標金額</h2></td>
	</tr>
	<tr>
		<td><input type="text" value="${user.goal}" readonly></td>
		<td>&#9654;</td>
		<td><input type="text" name="goal"></td>
	</tr>
	<tr>
</table>
<br>
<table>
	<tr>
	<td><h2>給料</h2></td>
	</tr>
	<tr>
		<td><input type="text" value="${user.salary}" readonly></td>
		<td>&#9654;</td>
		<td><input type="text" name="salary"></td>
	</tr>
	<tr>
</table>
<br>
<table>
	<tr>
	<td><h2>暑がり寒がり</h2></td>
	</tr>
	<tr>
		<td><input type="text" value="${user.constitution}" readonly></td>
		<td>&#9654;</td>
		<td>
			<select name="constitution">
				<option hidden> ${user.constitution}</option>
				<option>普通</option>
				<option>暑がり</option>
				<option>寒がり</option>
			</select>
		</td>
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