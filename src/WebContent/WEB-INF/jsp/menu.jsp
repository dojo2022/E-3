<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="/selfManagement/css/common.css">
<title>Self Management</title>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.0.0.min.js"></script>
<script src="weather.js"></script>
</head>
<body>
	<!--ヘッダー-->
	<header class="header">
		<h1 id="sm">
			<a href="/selfManagement/MenuServlet"><img
				src="/selfManagement/img/iii.png" width="400" height="130"
				alt="Self Managment"></a>
		</h1>
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
		<div class="city-wrap">
			<h4 id="city-name" class="city-name"></h4>
			<div id="weather-date" class="weather-date"></div>
			気温
			<div id="weather-temp" class="weather-temp big"></div>
			<div class="detail-list">
				<div class="detail-item">
					<div class="text">最高気温</div>
					<div id="tempMax" class="value tempMin"></div>
				</div>
				<div class="detail-item">
					<div class="text">最低気温</div>
					<div id="tempMin" class="value tempMax"></div>
				</div>
				<div class="detail-item">
					<div class="text">体感気温</div>
					<div id="feelsLike" class="value feelsLike"></div>
				</div>
			</div>
			<div id="weather-discription" class="weather-discription"></div>
			<img id="weather-icon" src="img/01d.png">
			<div id="weather-cloth" class="weather-cloth"></div>
			<div class="weather-reportWrap">
				<div id="weather-report" class="weather-report"></div>
			</div>
		</div>

		<div class="container">
			<div class="contents">
				<img src="/selfManagement/img/iii.png" width="400" height="130"
					alt="Self Managment"> <br>
				<!-- スケジュール -->
				<img src="/selfManagement/img/kari1.png" width="480" height="273"
					alt="仮イメージ1">

				<table>
					<tr>
						<th>日付</th>
						<th>予定</th>
					</tr>
				</table>
				<c:forEach var="slist" items="${scheduleList}">
					<table>
						<tr>
							<td>${slist.s_date}</td>
							<td>${slist.s_category}</td>
						</tr>
					</table>
				</c:forEach>
				<a href="/selfManagement/S_listServlet">スケジュール管理へ</a> <br>

				<!-- 家計簿 -->
				<img src="/selfManagement/img/copymaedauniverse.png" width="480"
					height="273" alt="仮イメージ2"> <br> 目標：${user.reason} <br>
				残り${deadline}ヵ月 <br>
				<c:set var="vTotal" value="${0}" />
				<c:forEach var="vlist" items="${variableList}">
					<c:set var="vTotal" value="${vTotal + vlist.v_cost}" />
				</c:forEach>

				<c:set var="fTotal" value="${0}" />
				<c:forEach var="flist" items="${fixedList}">
					<c:set var="fTotal" value="${fTotal + flist.f_cost}" />
				</c:forEach>
				<c:set var="balance" value="${user.salary - fTotal - vTotal}" />
				現在の残高：
				<fmt:formatNumber maxFractionDigits="0" value="${balance}" />
				円 <br>
				<!-- ↓本当はsavings使って計算します -->
				<c:set var="savings" value="${user.goal / deadline}" />
				貯金目標：
				<fmt:formatNumber maxFractionDigits="0" value="${savings}" />
				円 <br> 使用可能額：
				<fmt:formatNumber maxFractionDigits="0" value="${balance - savings}" />
				円 <br> <a href="/selfManagement/H_listServlet">家計簿管理へ</a>
			</div>
		</div>

	</main>
	<!--フッター-->
	<hr>
	<footer>
		<p>&copy;Copyright 川崎.java. All rights reserved.</p>
	</footer>
	<!--フッターここまで-->
</body>
</html>