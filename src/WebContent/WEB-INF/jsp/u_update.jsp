<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Self Management</title>
<link rel="stylesheet" type="text/css" href="/selfManagement/css/common.css">
</head>
  <body>
	<!--ヘッダー-->
	<div class="wrapper">
	<header class="header">
		<h1 id="sm"><a href="/selfManagement/MenuServlet"><img src="/selfManagement/img/iii.png" width="400" height="130" alt="Self Managment" ></a></h1>
		<div>
		 <p>ユーザー更新ページ</p>
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
	    <form method="POST" action="/selfManagement/U_updateServlet" id="u_form">
		    <input type="hidden" value="${user.user_id}">
            <br>
			<h2>貯金理由</h2>
			<input type="text" value="${user.reason}" readonly>
			&#9654;
			<input type="text" name="reason" value="${user.reason}">
		     <br>
             <br>
		     <h2>達成期限</h2>
		     <input type="date" value="${user.deadline}" readonly>
		     &#9654;
		     <input type="date" name="deadline" value="${user.deadline}" id="today">
		     <br>
             <br>
			<h2>目標金額</h2>
			<input type="text" value="${user.goal}" readonly>
			&#9654;
			<input type="text" name="goal" value="${user.goal}" pattern="(0|[1-9][0-9]*)">
		    <br>
            <br>
			<h2>給料</h2>
			<input type="text" value="${user.salary}" readonly>
			&#9654;
			<input type="text" name="salary" value="${user.salary}" pattern="(0|[1-9][0-9]*)">
		    <br>
            <br>
		   	<h2>暑がり寒がり</h2>
			<input type="text" value="${user.constitution}" readonly>
			&#9654;
			<select name="constitution" style="width:177px">
				<option hidden> ${user.constitution}</option>
				<option>暑がり</option>
				<option>寒がり</option>
				<option>どちらでもない</option>
			</select>
	    	<br>
	    	<br>
	    	<div class="button1">
	    	 <input type=submit name="submit" value="更新">
	    	</div>
 		</form>
	    <span id="error_message"></span>
	   </div>
  	</div>
 </main>
		<!--フッター-->
		<hr>
		<footer>
		<p>
		&copy;Copyright 川崎.java. All rights reserved.
		</p>
		</footer>
		</div>
		<!--フッターここまで-->
		<script>
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
        var formObj = document.getElementById('u_form');
        var errorMessageObj = document.getElementById('error_message');
        /* [更新]ボタンをクリックしたときの処理 */
        formObj.onsubmit = function() {
          /* 氏名を必須入力項目とします */
          if (!formObj.deadline.value || !formObj.goal.value ) {
            errorMessageObj.textContent = '※達成期限,目標金額,給料を入力してください！';
            return false;
          }
          errorMessageObj.textContent = null;
        };
    </script>

</body>
</html>