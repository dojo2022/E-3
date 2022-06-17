<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/selfManagement/css/common.css">
<title>Self Management</title>
<link rel="" type="" href="">
</head>
<body>
	<!--ヘッダー-->
	<header class="header">
	<h1 id="sm"><a href="/selfManagement/MenuServlet"><img src="/selfManagement/img/iii.png" width="400" height="130" alt="Self Managment" ></a></h1>
	<div>
		<p>家計簿一覧ページ</p>
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
	<!-- メイン（ここから） -->
	<div>
		<p>目標</p>
		<p>目標までの残り月</p>
		<p>家計簿の現在の残高</p>
		<p>貯金目安</p>
		<p>使えるお金</p>
	</div>

	<input type="button" value="変動費登録" onclick="vRedirectClick();">
	<input type="button" value="固定費登録" onclick="fRedirectClick();">

	<br>
	<br>
	<br>


	<!-- 変動費テーブル -->
	<div>
		(例)2022/06/13
		<form method="POST" action="/selfManagement/H_listServlet">
			<input type="text" name="h_date" placeholder="検索したい日付を入力してください">
			<input type="submit" name="submit" value="検索">
		</form>
		<h2>変動費</h2>
		<table border="1">
			<tr>
				<th>日付</th>
				<th>カテゴリー</th>
				<th>メモ</th>
				<th>金額</th>
				<th>更新</th>
				<th>削除</th>
			</tr>
		</table>
		<c:forEach var="vlist" items="${variableList}">
			<form method="POST" action="/selfManagement/V_updateDeleteServlet">
				<table>
					<tr>
						<td><input type="hidden" name="v_id" value="${vlist.v_id}"><input
							type="text" name="v_date" value="${vlist.v_date}"></td>
						<td><select name="v_category">
								<option hidden>${vlist.v_category}</option>
								<option value="食費">食費</option>
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
						<td><input type="text" name="v_memo" value="${vlist.v_memo}"></td>
						<td><input type="text" name="v_cost" value="${vlist.v_cost}"></td>
						<td><input type="submit" name="submit" value="更新"></td>
						<td><input type="submit" name="submit" value="削除"></td>
					</tr>
				</table>
			</form>
		</c:forEach>
	</div>
	<br>

	<!-- 固定費テーブル -->
	<div>
		<h2>固定費</h2>
		<table border="1">
			<tr>
				<th>日付</th>
				<th>カテゴリー</th>
				<th>メモ</th>
				<th>金額</th>
				<th>更新</th>
				<th>削除</th>
			</tr>
		</table>
		<form method="POST" action="/selfManagement/F_updateDeleteServlet">
			<c:forEach var="flist" items="${fixedList}">
				<table>
					<tr>
						<td><input type="hidden" name="f_id" value="${flist.f_id}"><input
							type="text" name="f_date" value="${flist.f_date}"></td>
						<td><select name="f_category">
								<option hidden>${flist.f_category}</option>
								<option value="食費">食費</option>
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
						<td><input type="text" name="f_memo" value="${flist.f_memo}"></td>
						<td><input type="text" name="f_cost" value="${flist.f_cost}"></td>
						<td><input type="submit" name="submit" value="更新"></td>
						<td><input type="submit" name="submit" value="削除"></td>
					</tr>
				</table>
			</c:forEach>
		</form>
	</div>
	<!-- メイン（ここまで） -->
	<!--フッター-->
	<hr>
	<footer>
		<p>&copy;Copyright 川崎.java. All rights reserved.</p>
	</footer>
	<!--フッターここまで-->
	<script>
		function vRedirectClick() {
			document.location.href = "/selfManagement/V_registServlet";
		}
		function fRedirectClick() {
			document.location.href = "/selfManagement/F_registServlet";
		}
	</script>
</body>
</html>
