<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Self Managment</title>
<link rel="stylesheet" type="text/css" href="/selfManagement/css/common.css">
</head>
  <body>
  <div class="wrapper">
   <header class="header">
     <h1 id="sm"><img src="/selfManagement/img/iii.png" width="400" height="130" alt="Self Managment" ></h1>
	  <hr>
	  </header>
	  <main>
	  <hr>
	  <div class="container">
	   <div class="contents">
        <h2>新規登録してください</h2>
         <form method="POST" action="/selfManagement/U_registServlet">
         <div id="p">ID:
          <input type="text" name="login_id"></div>
         <div id="p">PW:
          <input type="password" name="password"></div>
          <label for="kind">暑がり・寒がり:</label>
          <select id="kind" name="constitution">
          <option>暑がり</option>
          <option>寒がり</option>
          <option>どちらでもない</option>
          </select>
         <div id="p">全項目入力してください</div>
         <div class="button"><input type="submit" name="regist" value="登録">
         <input type="button" onclick="location.href='/selfManagement/LoginServlet'" value="ログインへ"></div>
         </form>
         </div>
         </div>
        </main>


     <hr>
     <footer>
		<p>&copy;Copyright 川崎.java. All rights reserved.</p>
	 </footer>
	 </div>
  </body>
</html>