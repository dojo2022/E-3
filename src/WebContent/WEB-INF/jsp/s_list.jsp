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
	<div class="kennsaku"><br>（例）2022-06-30 or 2022-06 or 2022
	 <form method="POST" action="/selfManagement/S_listServlet">
		<input type="text" name="s_day" placeholder="検索したい日付を入力してください" pattern="\d{4}-?\d{0,2}-?\d{0,2}">
		<input type="submit" name="submit" value="検索">
	 </form>
   </div>

    		<table id="list">
			 <tr>
			  <th width="115px" height="45px">日付</th><th width="97px">カテゴリ</th><th width="175px">メモ</th><th colspan="2" width="95px">機能</th>
		     </tr>
		    </table>
		   <div id="table2">
	<c:forEach var="slist" items="${scheduleList}">

		<form method="POST" action="/selfManagement/S_updateDeleteServlet"id="s_form">
			<table id="list" border="1">
			 <tr>
				<td width="111px" height="40px"><input type="hidden" name="s_id" value="${slist.s_id}"></input><input type="date" name="s_date" value="${slist.s_date}"></input></td>
				<td width="100px"><select name="s_category">
				    		<option value="${slist.s_category}" hidden>${slist.s_category}</option>
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
				 <td width="175px"><input type="text" name="s_memo" value="${slist.s_memo}"></td>
				 <td><input type="submit" name="submit" value="更新"></td>
				 <td><input type="submit" name="submit" value="削除"></td>
			    </tr>
			</table>
			<span id="error_message"></span>
		</form>
	</c:forEach>
	</div>
	<div class="botton2" class="but1">
	 <button onclick="OnRedirectClick();" class="but3">予定登録</button>
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
    	var formObj = document.getElementById('s_form');
        var errorMessageObj = document.getElementById('error_message');
        /* [実行]ボタンをクリックしたときの処理 */
        formObj.onsubmit = function() {
          /* 氏名を必須入力項目とします */
          if (!formObj.s_date.value) {
            errorMessageObj.textContent = '※日付を入力してください！';
            return false;
          }
          errorMessageObj.textContent = null;
        };
	</script>
</body>
</html>