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
		List<Schedule> scheduleList = new ArrayList<Schedule>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SM", "sa", "kawasaki");

			// SQL文を準備する
			String sql = "SELECT s_id, s_date,s_category,s_memo FROM Schedule WHERE s_date >= CURDATE() ORDER BY s_date";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Schedule schedule = new Schedule();
				schedule.setS_id(rs.getInt("s_id"));
				schedule.setS_date(rs.getString("s_date"));
				schedule.setS_category(rs.getString("s_category"));
				schedule.setS_memo(rs.getString("s_memo"));

				scheduleList.add(schedule);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			scheduleList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			scheduleList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					scheduleList = null;
				}
			}
		}

		// 結果を返す
		return scheduleList;
	}
			//データ5件取得
		public List<Schedule> display5() {
			Connection conn = null;
			List<Schedule> scheduleList = new ArrayList<Schedule>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SM", "sa", "kawasaki");

				// SQL文を準備する
				String sql = "SELECT s_id, s_date,s_category,s_memo FROM Schedule WHERE s_date >= CURDATE() ORDER BY s_date LIMIT 5";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Schedule schedule = new Schedule();
					schedule.setS_id(rs.getInt("s_id"));
					schedule.setS_date(rs.getString("s_date"));
					schedule.setS_category(rs.getString("s_category"));
					schedule.setS_memo(rs.getString("s_memo"));

					scheduleList.add(schedule);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				scheduleList = null;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				scheduleList = null;
			} finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
						scheduleList = null;
					}
				}
			}

			// 結果を返す
			return scheduleList;
		}

	//引数paramで検索項目を指定し、検索結果のリストを返す
		public List<Schedule> select(Schedule param) {
			Connection conn = null;
			List<Schedule> cardList = new ArrayList<Schedule>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SM", "sa", "kawasaki");

				// SQL文を準備する
				String sql = "SELECT s_id, s_date,s_category,s_memo FROM Schedule WHERE s_date LIKE ? ORDER BY s_date";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				//SQL分を完成させる
				if (param.getS_date() != null) {
					pStmt.setString(1, param.getS_date() + "%");
				}
				else {
					pStmt.setString(1, "%");
				}

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Schedule card = new Schedule();
					card.setS_id(rs.getInt("s_id"));
					card.setS_date(rs.getString("s_date"));
					card.setS_category(rs.getString("s_category"));
					card.setS_memo(rs.getString("s_memo"));

					cardList.add(card);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				cardList = null;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				cardList = null;
			} finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
						cardList = null;
					}
				}
			}

			// 結果を返す
			return cardList;
		}



	//登録
	public boolean insert(Schedule param) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SM", "sa", "kawasaki");

			// SQL文を準備する
			String sql = "INSERT INTO Schedule(s_date, s_category, s_memo) VALUES(?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getS_date() != null && !param.getS_date().equals("")) {
				pStmt.setString(1, param.getS_date());
			} else {
				pStmt.setString(1, null);
			}
			if (param.getS_category() != null && !param.getS_category().equals("")) {
				pStmt.setString(2, param.getS_category());
			} else {
				pStmt.setString(2, null);
			}
			if (param.getS_memo() != null && !param.getS_memo().equals("")) {
				pStmt.setString(3, param.getS_memo());
			} else {
				pStmt.setString(3, null);
			}
			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}

	// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
	public boolean update(Schedule param) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SM", "sa", "kawasaki");


			// SQL文を準備する
			String sql = "UPDATE Schedule SET s_date=?, s_category=?, s_memo=? WHERE s_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);


			// SQL文を完成させる
			if (param.getS_date() != null && !param.getS_date().equals("")) {
				pStmt.setString(1, param.getS_date());
			} else {
				pStmt.setString(1, null);
			}
			if (param.getS_category() != null && !param.getS_category().equals("")) {
				pStmt.setString(2, param.getS_category());
			} else {
				pStmt.setString(2, null);
			}
			if (param.getS_memo() != null && !param.getS_memo().equals("")) {
				pStmt.setString(3, param.getS_memo());
			} else {
				pStmt.setString(3, null);
			}
			pStmt.setInt(4, param.getS_id());


			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}

	// 引数numberで指定されたレコードを削除し、成功したらtrueを返す
	public boolean delete(int s_id) {

		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SM", "sa", "kawasaki");


			// SQL文を準備する
			String sql = "delete from Schedule where s_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, s_id);

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}

}
