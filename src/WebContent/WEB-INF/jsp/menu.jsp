<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<header class="header">
		<h1 id="sm"><a href="/selfManagement/MenuServlet"><img src="/selfManagement/img/iii.png" width="400" height="130" alt="Self Managment" ></a></h1>
		<div>
		 <p>トップページ</p>
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
 		  <div class="background-color">
 		  <img src="/selfManagement/img/iii.png" width="400" height="130" alt="Self Managment" >
 		   <c:forEach var="slist" items="${scheduleList}">
 		    <table>
 		     <tr>
 		      <th>日付</th>
 		      <th>予定</th>
 		     </tr>
 		     <tr>
 		      <td>${slist.s_date} </td>
 		      <td>${slist.s_category} </td>
 		     </tr>
 		    </table>
 		   </c:forEach>
 		   ${today}
 		   ${month}
          </div>
        </main>
		<!--フッター-->
		<hr>
		<footer>
		<p>
		&copy;Copyright 川崎.java. All rights reserved.
		</p>
		</footer>
		<!--フッターここまで-->
</body>
</html>