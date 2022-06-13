<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="/selfManagement/css/common.css">
</head>
<body>
	<form method="POST" action="/selfManagement/F_registServlet">
		<table>
			<tr>
				<td>日付</td>
				<td><input type="date" name="f_date"></td>
			</tr>
			<tr>
				<td>カテゴリー</td>
				<td><select name="f_category">
						<option value="家賃" selected>家賃</option>
						<option value="保険">保険</option>
						<option value="通信費">通信費</option>
						<option value="定期代">定期代</option>
						<option value="税金">税金</option>
						<option value="ローン">ローン</option>
						<option value="その他">その他</option>
				</select></td>
			</tr>
			<tr>
				<td>メモ</td>
				<td><input type="text" name="f_memo"></td>
			</tr>
			<tr>
				<td>金額（必須）</td>
				<td><input type="text" name="f_cost"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="f_regist" value="登録">
					<input type="reset" name="reset" value="リセット"></td>
			</tr>
		</table>
	</form>
</body>
</html>