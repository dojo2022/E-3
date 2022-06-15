<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" type="text/css"
	href="/selfManagement/css/common.css">
</head>
<body>
<form method="POST" action="/selfManagement/S_registServlet">
<table>
<tr>
<td>日付</td><td><input type="date"name="s_date"></input></td></tr>
<tr>
<td>カテゴリー</td><td><select name="s_category"size="1">
<option value="遊び">遊び</option>
<option value="休み">休み</option>
<option value="デート">デート</option>
<option value="飲み会">飲み会</option>
<option value="旅行">旅行</option>
<option value="支払い期限">支払い期限</option>
<option value="イベント">イベント</option>
<option value="その他">その他</option>
</select></td>
</tr>
<tr>
<td><input type="text" name="s_memo"></td>
</tr>
<tr>
				<td colspan="2"><input type="submit" name="s_regist" value="登録">
					<input type="reset" name="reset" value="リセット"></td>
			</tr>
		</table>
	</form>
</body>
</html>