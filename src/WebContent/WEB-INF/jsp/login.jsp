<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Self Management</title>
<link rel="stylesheet" type="text/css" href="/selfManagement/css/common.css">
</head>
<body>
	<!--ヘッダー-->
	<header class="header">
	 <h1 id="sm"><img src="/selfManagement/img/iii.png" width="400" height="130" alt="Self Managment" ></h1>
	  <hr>
	</header>
	<hr>
	<div class="container">
	 <div class="contents">
	<h2>ログインしてください</h2>
	<form id="login_form" method="POST" action="/selfManagement/LoginServlet">
      <div id="p">ID:<input type="text" class="textbox" name="ID"></div>
	  <div id="p">PW:<input type="password" class="textbox" name="PW"></div>
		<div class="button"><input type="submit" name="login" value="ログイン">
		<span id="error_message"></span>
		<a href="/selfManagement/U_registServlet">新規登録</a></div>
	</form>
	</div>
	</div>
	<footer>
		<p>&copy;Copyright 川崎.java. All rights reserved.</p>
	</footer>
	<script>
	var formObj = document.getElementById('login_form');
	var errorMessageObj = document.getElementById('error_message');
	formObj.onsubmit = function() {
	  if (!formObj.ID.value || !formObj.PW.value) {
	    errorMessageObj.textContent = '※IDとパスワードを入力してください！';
	    return false;
	  }
	  errorMessageObj.textContent = null;
	};
	</script>
</body>
</html>
