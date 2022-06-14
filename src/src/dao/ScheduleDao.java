package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Schedule;

public class ScheduleDao {
	//データ全件取得
	public List<Schedule> display() {
		Connection conn = null;
		List<Schedule> cardList = new ArrayList<Schedule>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SM", "sa", "kawasaki");

			// SQL文を準備する
			String sql = "SELECT s_date,s_category,s_memo FROM Schedule ORDER BY s_date";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while(rs.next()) {
				Schedule card = new Schedule();
				card.setS_date(rs.getString("s_date"));
				card.setS_category(rs.getString("s_category"));
				card.setS_memo(rs.getString("s_memo"));

				cardList.add(card);			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			cardList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
			}
		}

		// 結果を返す
		return cardList;
	}
}
