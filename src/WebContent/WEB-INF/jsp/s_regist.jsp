<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Self Management</title>
<link rel="stylesheet" type="text/css"
	href="/selfManagement/css/common.css">
</head>
<body>
	<!--ヘッダー-->
	<div class="wrapper">
	<header class="header">
		<h1 id="sm"><a href="/selfManagement/MenuServlet"><img src="/selfManagement/img/iii.png" width="400" height="130" alt="Self Managment" ></a></h1>
		<div>
			<p>スケジュールページ</p>
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
	<form method="POST" action="/selfManagement/S_registServlet"id="s_form">
		<table>
			<tr>
				<td>日付（必須）</td><td><input type="date" id="today" name="s_date"></input></td></tr>
			<tr>
			<td>カテゴリー</td>
			<td>
				<select name="s_category"size="1">
					<option value="遊び">遊び</option>
					<option value="休み">休み</option>
					<option value="デート">デート</option>
					<option value="飲み会">飲み会</option>
					<option value="旅行">旅行</option>
					<option value="支払い期限">支払い期限</option>
					<option value="イベント">イベント</option>
					<option value="その他">その他</option>
				</select>
			</td>
			</tr>
			<tr>
				<td>メモ</td>
				<td><input type="text" name="s_memo" maxlength="100"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="s_regist" value="登録">
					<input type="reset" name="reset" value="リセット">
				</td>
			</tr>
		</table>
		<span id="error_message"></span>
	</form>
	<!--フッター-->
	<hr>
	<footer>
		<p>&copy;Copyright 川崎.java. All rights reserved.</p>
	</footer>
	</div>
	<!--フッターここまで-->
	<script type="text/javascript">
    //今日の日時を表示
        window.onload = function () {
            //今日の日時を表示
            var date = new Date()
            var year = date.getFullYear()
            var month = date.getMonth() + 1
            var day = date.getDate()

            var toTwoDigits = function (num, digit) {
              num += ''
              if (num.length < digit) {
                num = '0' + num
              }
              return num
            }

            var yyyy = toTwoDigits(year, 4)
            var mm = toTwoDigits(month, 2)
            var dd = toTwoDigits(day, 2)
            var ymd = yyyy + "-" + mm + "-" + dd;

            document.getElementById("today").value = ymd;
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