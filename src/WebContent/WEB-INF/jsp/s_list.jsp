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
		トップページ
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
	<p>（例）2022/06/09</p>
	<form method="POST" action="/selfManagement/S_listServlet">
		<input type="text" name="s_day" placeholder="検索したい日付を入力してください">
		<input type="submit" name="surch" value="検索">
	</form>

	<table border="1">
		<tr>
			<th>日付</th><th>カテゴリ</th><th>メモ</th><th>機能</th>
		</tr>
	</table>
	<c:forEach var="slist" items="${scheduleList}">
		<form method="POST" action="/selfManagement/S_updateDeleteServlet">
			<table border="1">
				<tr>
					<td><input type="hidden" name="s_id" value="${slist.s_id}"></input></td>
				    <td><input type="date" name="s_date" value="${slist.s_date}"></input></td>
				    <td><select name="s_category">
				    		<option  value="${slist.s_category}" hidden>${slist.s_category}</option>
				    		<option value="遊び">遊び</option>
							<option value="休み">休み</option>
							<option value="でーす">デート</option>
							<option value="飲み会">飲み会</option>
							<option value="旅行">旅行</option>
							<option value="支払">支払期限</option>
							<option value="イベント">イベント</option>
							<option value="その他">その他</option>
						</select>
				    </td>
				    <td><input type="text" name="s_memo" value="${slist.s_memo}"></td>
				    <td><input type="submit" name="submit" value="更新"></td>
				    <td><input type="submit" name="submit" value="削除"></td>
			    </tr>
			</table>
		</form>
	</c:forEach>
	<button onclick="OnRedirectClick();">予定登録</button>
	<!--フッター-->
	<hr>
	<footer>
		<p>
		&copy;Copyright 川崎.java. All rights reserved.
		</p>
	</footer>
	<!--フッターここまで-->
	<script>
    	function OnRedirectClick() {
    		document.location.href = "/selfManagement/S_registServlet";
		}
	</script>
</body>
</html>