<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Self Managment</title>
</head>
<body>
<h1>Self Managment</h1>
 <main>
  <h2>新規登録してください</h2>
   <form method="GET" action="/selfManagement/U_registServlet">
   <p>ID:
   <input type="text" name="name"></p>
   <p>PW:
   <input type="text" name="name"></p>
   <label for="kind">暑がり・寒がり</label><br>
   <select id="kind" name="Kind">
    <option value="heat">暑がり</option>
    <option value="cold">寒がり</option>
    <option value="neither">どちらでもない</option>
   </select>
   <p>全項目入力してください</p>
   <p><input type="button" value="登録">
   <p><input type="button" value="ログインへ">
   </form>
 </main>
</body>
</html>