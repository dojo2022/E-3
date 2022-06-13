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
<td>日付</td><td><input type="s_date"></input></td></tr>
<tr>
<td>カテゴリー</td><td><select name="s_category"size="1">
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