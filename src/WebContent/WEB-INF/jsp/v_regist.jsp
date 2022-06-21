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
	<form method="POST" action="/selfManagement/V_registServlet" id ="v_form">
		<table>
			<tr>
				<td>日付</td>
				<td><input type="date" id="today" name="v_date"></td>
			</tr>
			<tr>
				<td>カテゴリー</td>
				<td><select name="v_category">
						<option value="食費" selected>食費</option>
						<option value="日用品・衣服">日用品・衣服</option>
						<option value="通信費">通信費</option>
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
		<span id="error_message"></span>
	</form>
	<!--フッター-->
	<hr>
	<footer>
		<p>&copy;Copyright 川崎.java. All rights reserved.</p>
	</footer>
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
        var formObj = document.getElementById('v_form');
        var errorMessageObj = document.getElementById('error_message');
        /* [実行]ボタンをクリックしたときの処理 */
        formObj.onsubmit = function() {
          /* 氏名を必須入力項目とします */
          if (!formObj.v_cost.value) {
            errorMessageObj.textContent = '※金額を入力してください！';
            return false;
          }
          errorMessageObj.textContent = null;
        };
</script>
</body>
</html>