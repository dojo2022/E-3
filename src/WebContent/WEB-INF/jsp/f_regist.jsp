<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/selfManagement/css/common.css">
<title>Self Management</title>
</head>
<body>
	<!--ヘッダー-->
	<header class="header">
		<h1 id="sm"><a href="/selfManagement/MenuServlet"><img src="/selfManagement/img/iii.png" width="400" height="130" alt="Self Managment" ></a></h1>
		<div>
			<p>スケジュール一覧ページ</p>
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
	<form method="POST" action="/selfManagement/F_registServlet">
		<table>
			<tr>
				<td>日付</td>
				<td><input type="date" name="f_date"></td>
			</tr>
			<tr>
				<td>カテゴリー</td>
				<td><select name="f_category">
						<option value="家賃" selected>家賃</option>
						<option value="保険">保険</option>
						<option value="通信費">通信費</option>
						<option value="定期代">定期代</option>
						<option value="税金">税金</option>
						<option value="ローン">ローン</option>
						<option value="その他">その他</option>
				</select></td>
			</tr>
			<tr>
				<td>メモ</td>
				<td><input type="text" name="f_memo"></td>
			</tr>
			<tr>
				<td>金額（必須）</td>
				<td><input type="text" name="f_cost"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="f_regist" value="登録">
					<input type="reset" name="reset" value="リセット"></td>
			</tr>
		</table>
	</form>
	<!--フッター-->
	<hr>
	<footer>
		<p>&copy;Copyright 川崎.java. All rights reserved.</p>
	</footer>
	<!--フッターここまで-->
</body>
</html>