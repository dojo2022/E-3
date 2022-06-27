<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/selfManagement/css/common.css">
<title>Self Management</title>
</head>
  <body>
	<!--ヘッダー-->
	<div class="wrapper">
	<header class="header">
	<h1 id="sm"><a href="/selfManagement/MenuServlet"><img src="/selfManagement/img/iii.png" width="400" height="130" alt="Self Managment" ></a></h1>
	<div>
		<p>家計簿一覧ページ</p>
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
	<!-- メイン（ここから） -->
	<main>
	<div class="container">
     <div class="contents">
     <br>
	 <div class="box">
		<div>
			<!-- 目標を表示する -->
			<p>目標:${user.reason}</p>

			<!-- 残り日数を表示する -->
			<c:if test="${date1 == '0001-01-01'}" var="flg" />

			<c:if test="${flg}" >
					(日付データを更新してください) <br>
			</c:if>
			<c:if test="${!flg}" >
				<c:if test="${deadline + 12 * year > 0}">
					<p>残り${deadline + 12 * year}ヵ月</p>
				</c:if>
				<c:if test="${deadline + 12 * year == 0}">
					<p>達成予定は今月です</p>
				</c:if>
				<c:if test="${deadline + 12 * year < 0}">
					<p>目標を更新してください</p>
				</c:if>
			</c:if>

			<!-- deadline +1 する -->
			<c:if test="${deadline == 0}" var="p1" />
			<c:if test="${p1}" >
				<c:set var="deadline" value="${deadline + 1}" />
			</c:if>

			<!-- 変動費の合計を計算する -->
			<c:set var="vTotal" value="${0}" />
			<c:forEach var="vlist" items="${variableAllList}">
			<c:set var="vTotal" value="${vTotal + vlist.v_cost}" />
			</c:forEach>

			<!-- 固定費の合計を計算する -->
			<c:set var="fTotal" value="${0}" />
			<c:forEach var="flist" items="${fixedAllList}">
			<c:set var="fTotal" value="${fTotal + flist.f_cost}" />
			</c:forEach>

			<!-- 現在の残高を表示する -->
			<c:set var="balance" value="${user.salary - fTotal - vTotal}" />
			<p>現在の残高:<fmt:formatNumber maxFractionDigits="0" value="${balance}" />円</p>

			<!-- 貯金目標を表示する -->
			<p>貯金目標：<fmt:formatNumber maxFractionDigits="0" value="${user.goal}"/>円</p>
			<c:set var="savings" value="${user.goal / (deadline + 12 * year)}" />

			<!-- 貯金目安を表示する -->
			<p>今月の貯金目安：<fmt:formatNumber maxFractionDigits="0" value="${savings}" />円</p>

			<!-- 使用可能額を表示する -->
 			<p>使用可能額：<fmt:formatNumber maxFractionDigits="0" value="${balance - savings}" />円</p>
		</div>
     </div>
     <div class="botton2">
	  <input type="button" value="変動費登録" onclick="vRedirectClick();" class="but1">
	  <input type="button" value="固定費登録" onclick="fRedirectClick();" class="but2">
     </div>


	<!-- 変動費テーブル -->
	<div>
		(例)2022-06-13
		<form method="POST" action="/selfManagement/H_listServlet">
			<input type="text" name="h_date" placeholder="検索したい日付を入力してください">
			<input type="submit" name="submit" value="検索">
		</form>

		<h2>変動費</h2>
		<c:set var="vTotal" value="${0}" />
		 <table id="list1">
		         <tr>
				  <th width="125px" height="45px">日付</th>
				  <th width="120px">カテゴリー</th>
				  <th width="170px">メモ</th>
				  <th width="175px">金額</th>
				  <th colspan="2" width="110px">その他</th>
				 </tr>
		 </table>
		 <div id="table3">
		<c:forEach var="vlist" items="${variableList}">
			<c:set var="vTotal" value="${vTotal + vlist.v_cost}" />
			<form method="POST" action="/selfManagement/V_updateDeleteServlet"id ="v_form">
				<table id="list1" border="1">
				 <tr>
						<td width="122px" height="35px"><input type="hidden" name="v_id" value="${vlist.v_id}">
							<input type="date" name="v_date" value="${vlist.v_date}"></td>
						<td width="115px">
							<select name="v_category">
								<option hidden>${vlist.v_category}</option>
								<option value="食費">食費</option>
								<option value="日用品・衣服">日用品・衣服</option>
								<option value="交際費">交際費</option>
								<option value="交通費">交通費</option>
								<option value="美容">美容</option>
								<option value="趣味">趣味</option>
								<option value="医療費">医療費</option>
								<option value="教育費">教育費</option>
								<option value="その他">その他</option>
							</select>
						</td>
						<td width="50px"><input type="text" name="v_memo" value="${vlist.v_memo}"></td>
						<td><input type="text" name="v_cost" value="${vlist.v_cost}"></td>
						<td width="50px"><input type="submit" name="submit" value="更新"></td>
						<td width="50px"><input type="submit" name="submit" value="削除"></td>
				    </tr>
				</table>
				<span id="error_message"></span>
			</form>
		</c:forEach>
	</div>
	変動費合計： ${vTotal}
	<br>
    <br>
    <br>
	<!-- 固定費テーブル -->
	<div>
		<h2>固定費</h2>

		<c:set var="fTotal" value="${0}" />
		       <table id="list2">
         		<tr>
				  <th width="119px" height="45px">日付</th>
				  <th width="145px">カテゴリー</th>
				  <th width="170px">メモ</th>
				  <th width="175px">金額</th>
				  <th colspan="2" width="94px">その他</th>
				 </tr>
				</table>
		   <div id="table4">
			<c:forEach var="flist" items="${fixedList}">
			<c:set var="fTotal" value="${fTotal + flist.f_cost}" />
			<form method="POST" action="/selfManagement/F_updateDeleteServlet">

                <table id="list1" border="1">

					<tr>
						<td width="115px" height="35px">
							<input type="hidden" name="f_id" value="${flist.f_id}">
							<input type="date" name="f_dheight="35px"ate" value="${flist.f_date}">
						</td>
						<td width="145px">
							<select name="f_category">
								<option hidden>${flist.f_category}</option>
								<option value="住居費">住居費</option>
								<option value="水道光熱費">水道光熱費</option>
								<option value="通信費">通信費</option>
								<option value="生命保険">生命保険</option>
								<option value="自動車関係費">自動車関係費</option>
								<option value="サブスクリプション">サブスクリプション</option>
								<option value="習い事等">習い事等</option>
								<option value="その他">その他</option>
							</select>
						</td>
						<td width="50px"><input type="text" name="f_memo" value="${flist.f_memo}"></td>
						<td><input type="text" name="f_cost" value="${flist.f_cost}"></td>
						<td width="50px"><input type="submit" name="submit" value="更新"></td>
						<td width="50px"><input type="submit" name="submit" value="削除"></td>
					</tr>

				</table>

			</form>
		</c:forEach>
      </div>
		固定費合計： ${fTotal}
	</div>
	合計支出: ${vTotal + fTotal}
	<br>
	<br>
	  </div>
	  </div>
	  </div>
	 </main>
	<!-- メイン（ここまで） -->
	<!--フッター-->
	<hr>
	<footer>
		<p>&copy;Copyright 川崎.java. All rights reserved.</p>
	</footer>
	</div>
	<!--フッターここまで-->
	<script>
		function vRedirectClick() {
			document.location.href = "/selfManagement/V_registServlet";
		}
		function fRedirectClick() {
			document.location.href = "/selfManagement/F_registServlet";
		}
		 var formObj = document.getElementById('v_form');
	        var errorMessageObj = document.getElementById('error_message');
	        /* [実行]ボタンをクリックしたときの処理 */
	        formObj.onsubmit = function() {
	          /* 氏名を必須入力項目とします */
	           if (!formObj.v_date.value || !formObj.v_cost.value) {
	            errorMessageObj.textContent = '※日付と金額を入力してください！';
	            return false;
	          }
	          errorMessageObj.textContent = null;
	        };
	</script>
</body>
</html>
