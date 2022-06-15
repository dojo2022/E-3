package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Fixed;

public class FixedDao {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Fixed> select(Fixed param) {
		Connection conn = null;
		List<Fixed> fixedList = new ArrayList<Fixed>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SM", "sa", "kawasaki");

			// SQL文を準備する
			String sql = "SELECT f_date, f_category, f_memo, f_cost FROM Fixed WHERE f_date LIKE ? ORDER BY f_date DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getF_date() != null) {
				pStmt.setString(1, "%" + param.getF_date() + "%");
			} else {
				pStmt.setString(1, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Fixed list = new Fixed(
						0, rs.getString("f_date"),
						rs.getString("f_category"),
						rs.getString("f_memo"),
						rs.getInt("f_cost"));
				fixedList.add(list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			fixedList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			fixedList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					fixedList = null;
				}
			}
		}

		// 結果を返す
		return fixedList;
	}

	public List<Fixed> select() {
		Connection conn = null;
		List<Fixed> fixedList = new ArrayList<Fixed>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SM", "sa", "kawasaki");

			// SQL文を準備する
			String sql = "SELECT * FROM Fixed ORDER BY f_date DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Fixed list = new Fixed(
						0, rs.getString("f_date"),
						rs.getString("f_category"),
						rs.getString("f_memo"),
						rs.getInt("f_cost"));
				fixedList.add(list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			fixedList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			fixedList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					fixedList = null;
				}
			}
		}

		// 結果を返す
		return fixedList;
	}

	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Fixed param) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SM", "sa", "kawasaki");

			// SQL文を準備する
			String sql = "INSERT INTO Fixed(f_date, f_category, f_memo, f_cost) VALUES(?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getF_date() != null && !param.getF_date().equals("")) {
				pStmt.setString(1, param.getF_date());
			} else {
				pStmt.setString(1, null);
			}
			if (param.getF_category() != null && !param.getF_category().equals("")) {
				pStmt.setString(2, param.getF_category());
			} else {
				pStmt.setString(2, null);
			}
			if (param.getF_memo() != null && !param.getF_memo().equals("")) {
				pStmt.setString(3, param.getF_memo());
			} else {
				pStmt.setString(3, null);
			}
			if (param.getF_cost() != 0) {
				pStmt.setInt(4, param.getF_cost());
			} else {
				pStmt.setInt(4, 0);
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
	public boolean update(Fixed param) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SM", "sa", "kawasaki");

			// SQL文を準備する
			String sql = "UPDATE Fixed SET f_date=?, f_category=?, f_memo=?,f_cost=? WHERE f_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getF_date() != null && !param.getF_date().equals("")) {
				pStmt.setString(1, param.getF_date());
			} else {
				pStmt.setString(1, null);
			}
			if (param.getF_category() != null && !param.getF_category().equals("")) {
				pStmt.setString(2, param.getF_category());
			} else {
				pStmt.setString(2, null);
			}
			if (param.getF_memo() != null && !param.getF_memo().equals("")) {
				pStmt.setString(3, param.getF_memo());
			} else {
				pStmt.setString(3, null);
			}
			if (param.getF_cost() != 0) {
				pStmt.setInt(4, param.getF_cost());
			} else {
				pStmt.setInt(4, 0);
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

	// 引数numberで指定されたレコードを削除し、成功したらtrueを返す
		public boolean delete(int f_id) {

			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SM", "sa", "kawasaki");

				// SQL文を準備する
				String sql = "delete from Fixed where f_id=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				pStmt.setInt(1, f_id);

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
