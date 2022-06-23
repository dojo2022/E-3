<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/selfManagement/css/common.css">
	<title>Self Management</title>
</head>
<body>
	<!--ヘッダー-->
	<div class="wrapper">
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
	<main>
	 <div class="container">
       <div class="contents">
	<div class="kennsaku"><br>（例）日付で検索：2022-06-30 or 月で検索：2022-06
	 <form method="POST" action="/selfManagement/S_listServlet">
		<input type="text" name="s_day" placeholder="検索したい日付を入力してください">
		<input type="submit" name="submit" value="検索">
	 </form>
   </div>
    <div id="table2">
	<c:forEach var="slist" items="${scheduleList}">
		<form method="POST" action="/selfManagement/S_updateDeleteServlet">
			<table id="list" border="1">
			 <tr>
			  <th>日付</th><th>カテゴリ</th><th>メモ</th><th colspan="2">機能</th>
		     </tr>
			 <tr>
				<td><input type="hidden" name="s_id" value="${slist.s_id}"></input><input type="date" name="s_date" value="${slist.s_date}"></input></td>
				<td><select name="s_category">
				    		<option  value="${slist.s_category}" hidden>${slist.s_category}</option>
				    		<option value="遊び">遊び</option>
							<option value="休み">休み</option>
							<option value="デート">デート</option>
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
	<div class="botton3">
	<button onclick="OnRedirectClick();">予定登録</button>
	</div>
	</div>
	</div>
	</div>
	</main>
	<!--フッター-->
	<hr>
	<footer>
		<p>&copy;Copyright 川崎.java. All rights reserved.</p>
	</footer>
	</div>
	<!--フッターここまで-->
	<script>
    	function OnRedirectClick() {
    		document.location.href = "/selfManagement/S_registServlet";
		}
	</script>
</body>
</html>