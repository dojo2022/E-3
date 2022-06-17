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
	<form method="POST" action="/selfManagement/V_registServlet">
		<table>
			<tr>
				<td>日付</td>
				<td><input type="date" name="v_date"></td>
			</tr>
			<tr>
				<td>カテゴリー</td>
				<td><select name="v_category">
						<option value="食費" selected>食費</option>
						<option value="日用品・衣服">日用品・衣服</option>
						<option value="交際費">交際費</option>
						<option value="交通費">交通費</option>
						<option value="水道・光熱費">水道・光熱費</option>
						<option value="美容">美容</option>
						<option value="趣味">趣味</option>
						<option value="医療費">医療費</option>
						<option value="教育費">教育費</option>
						<option value="その他">その他</option>
				</select></td>
			</tr>
			<tr>
				<td>メモ</td>
				<td><input type="text" name="v_memo"></td>
			</tr>
			<tr>
				<td>金額（必須）</td>
				<td><input type="text" name="v_cost"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="v_regist" value="登録">
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