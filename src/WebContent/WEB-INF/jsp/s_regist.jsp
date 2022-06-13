<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<form method="POST" action="/selfManagement/S_registServlet">
<table>
<tr>
<td>日付<input type="date"></input></td></tr>
<tr>
<td>カテゴリー<select name="s_category"size="1">
<option value="予定1">遊び</option>
<option value="予定2">休み</option>
<option value="予定3">デート</option>
<option value="予定4">飲み会</option>
<option value="予定5">旅行</option>
<option value="予定6">支払い期限</option>
<option value="予定7">イベント</option>
<option value="予定8">その他</option>
</select></td>
</tr>
<tr>
<td>メモ<input type="text" memo="memo"></td>
</tr>
</table>
</form>
<a href="/selfManagement/S_registServlet">登録</a>
<input type="reset">
</body>
</html>