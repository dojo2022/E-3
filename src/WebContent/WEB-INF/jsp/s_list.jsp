<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Self Management</title>
</head>
<body>
	<header>
		<h1>Self Management</h1>
		<nav class="nav">
            <ul id="nav">
                <li>スケジュール</li>
                <li>家計簿</li>
                <li>ユーザ更新</li>
                <li>ログアウト</li>
            </ul>
		</nav>
	</header>
	<p>（例）2022/06/09</p>
	<form method="POST" action="/selfManagement/S_listServlet">
		<input type="text" name="day" placeholder="検索したい日付を入力してください">
		<input type="submit" value="検索">
	</form>

	<table border="1">
		<tr>
			<th>日付</th><th>カテゴリ</th><th>メモ</th><th>機能</th>
		</tr>
	</table>

	<form method="POST" action="/selfManagement/S_updateDeleteServlet">
		<table border="1">
	 		<c:forEach var="card" items="${cardList}">
				<tr>
					<td><input type="text" name="s_date" value="${card.s_id}"></input></td>
				    <td><input type="date" name="s_date" value="${card.s_date}"></input></td>
				    <td>
				    	<select name="s_category">
				    		<option hidden>${card.s_category}</option>
				    		<option>遊び</option>
							<option>休み</option>
							<option>デート</option>
							<option>飲み会</option>
							<option>旅行</option>
							<option>支払期限</option>
							<option>イベント</option>
							<option>その他</option>
						</select>
				    </td>
				    <td><input type="text" name="s_memo" value="${card.s_memo}"></td>
				    <td><input type="submit" name="update" value="更新"></td>
				    <td><input type="submit" name="delete" value="削除"></td>
			    </tr>
		    </c:forEach>
		</table>
	</form>

	<!--  コメントアウト開始

			<tr>
				<td>${card.s_date}</td>
				<td>${card.s_memo}</td>
				<td><button type="submit">詳細</button></td>
			</tr>

	-->

		<button>予定登録</button>
	<footer>

	</footer>
</body>
</html>