<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Self Management</title>
<link rel="" type="" href="">
</head>
<body>
    <!-- ヘッダー（ここから） -->
    <h1>Self Management</h1>
    <!-- ヘッダー（ここまで） -->

    <!-- メイン（ここから） -->
    <div>
        <p>目標</p>
        <p>目標までの残り月</p>
        <p>家計簿の現在の残高</p>
        <p>貯金目安</p>
        <p>使えるお金</p>
    </div>

    <input type="button" value="変動費登録">
    <input type="button" value="固定費登録">

    <br>
    <br>
    <br>


    <!-- 変動費テーブル -->
    <div>
        (例)2022/06/13
        <input type="text" placeholder="検索したい日付を入力してください">
        <input type="button" value="検索">
        <h2>変動費</h2>
        <table border="1">
            <tr>
                <th>日付</th>
                <th>カテゴリー</th>
                <th>金額</th>
                <th>メモ</th>
                <th>更新</th>
                <th>削除</th>
            </tr>
            <tr>
                <td>2022/06/11</td>
                <td>
                    <select name="v_category" id="v_category">
                        <option value="食費">食費</option>
                        <option value="日用品・衣服">日用品・衣服</option>
                        <option value="交際費">交際費</option>
                        <option value="交通費">交通費</option>
                        <option value="水道・光熱費">水道・光熱費</option>
                        <option value="美容">美容</option>
                        <option value="趣味">趣味</option>
                        <option value="医療費">医療費</option>
                        <option value="教育費">教育費</option>
                        <option value="その他">その他</option>
                    </select>
                </td>
                <td>1,000,000</td>
                <td>割引してもらったよ！</td>
                <td><input type="button" value="更新"></td>
                <td><input type="button" value="削除"></td>
            </tr>
        </table>
    </div>
    <br>

    <!-- 固定費テーブル -->
    <div>
        (例)2022/06/13
        <input type="text" placeholder="検索したい日付を入力してください">
        <input type="button" value="検索">
        <h2>固定費</h2>
        <table border="1">
            <tr>
                <th>日付</th>
                <th>カテゴリー</th>
                <th>金額</th>
                <th>メモ</th>
                <th>更新</th>
                <th>削除</th>
            </tr>
            <tr>
                <td>2022/06/11</td>
                <td>
                    <select name="v_category" id="v_category">
                        <option value="食費">食費</option>
                        <option value="日用品・衣服">日用品・衣服</option>
                        <option value="交際費">交際費</option>
                        <option value="交通費">交通費</option>
                        <option value="水道・光熱費">水道・光熱費</option>
                        <option value="美容">美容</option>
                        <option value="趣味">趣味</option>
                        <option value="医療費">医療費</option>
                        <option value="教育費">教育費</option>
                        <option value="その他">その他</option>
                    </select>
                </td>
                <td>1,000,000</td>
                <td>割引してもらったよ！</td>
                <td><input type="button" value="更新"></td>
                <td><input type="button" value="削除"></td>
            </tr>
        </table>
    </div>
    <!-- メイン（ここまで） -->

    <!-- フッター（ここから） -->
    <p>&copy;Copyright plusDOJO(SE plus). All rights reserved.</p>
    <!-- フッター（ここまで） -->
</body>
</html>
