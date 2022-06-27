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
	<form method="POST" action="/selfManagement/F_registServlet" id="f_form">
		<table>
			<tr>
				<td>日付</td>
				<td><input id="datefield" type='date' min='1899-01-01' max='2000-13-13'></input></td>
			</tr>
			<tr>
				<td>カテゴリー</td>
				<td>
					<select name="f_category">
						<option value="住居費">住居費</option>
						<option value="水道光熱費">水道光熱費</option>
						<option value="通信費">通信費</option>
						<option value="生命保険">生命保険</option>
						<option value="自動車関係費">自動車関係費</option>
						<option value="サブスクリプション">サブスクリプション</option>
						<option value="習い事等">習い事等</option>
						<option value="その他">その他</option>
					</select>
				</td>
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

            document.getElementById("datefield").value = ymd;
        }
        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth()+1; //January is 0!
        var yyyy = today.getFullYear();
         if(dd<10){
                dd='0'+dd
            }
            if(mm<10){
                mm='0'+mm
            }

        today = yyyy+'-'+mm+'-'+dd;
        document.getElementById("datefield").setAttribute("max", today);
        var formObj = document.getElementById('f_form');
        var errorMessageObj = document.getElementById('error_message');
        /* [実行]ボタンをクリックしたときの処理 */
        formObj.onsubmit = function() {
          /* 氏名を必須入力項目とします */
          if (!formObj.f_date.value || !formObj.f_cost.value) {
            errorMessageObj.textContent = '※日付と金額を入力してください！';
            return false;
          }
          errorMessageObj.textContent = null;
        };
</script>
</body>
</html>