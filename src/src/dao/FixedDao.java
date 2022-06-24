package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import model.Fixed;

public class FixedDao {

	//日付検索
	//月固定費合計取得
	//一覧表示に出力
	public List<Fixed> fixed(Fixed param) {
		Connection conn = null;
		List<Fixed> fixedList = new ArrayList<Fixed>();
		//デフォルトのカレンダークラスを宣言、下のDateはセット
		SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM");
		//Calendar calendar = Calendar.getInstance();
		Date date = new Date();
		String d3 = df2.format(date);

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SM", "sa", "kawasaki");

			// SQL文を準備する
			String sql = "SELECT * FROM Fixed WHERE (f_date LIKE ?) AND (user_id = ?) ORDER BY f_date DESC ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL文を完成させる
			if (param.getF_date() != null && !param.getF_date().equals("")) {
				pStmt.setString(1, param.getF_date() + "%");
			}
			else {
				pStmt.setString(1, d3 + "%");
			}
			pStmt.setInt(2, param.getUser_id());

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Fixed list = new Fixed(
					rs.getInt("f_id"),
					rs.getString("f_date"),
					rs.getString("f_category"),
					rs.getString("f_memo"),
					rs.getInt("f_cost"),
					rs.getInt("user_id"));
					//rs.getInt("f_sorting")

					fixedList.add(list);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				fixedList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				fixedList = null;
			}
			finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					fixedList = null;
				}
			}
		}

		// 結果を返す
		return fixedList;
	}

	//再登録する固定費のデータを取得
	public List<Fixed> select(Fixed param) {
		Connection conn = null;
		List<Fixed> fixedList = new ArrayList<Fixed>();

		//デフォルトのカレンダークラスを宣言、下のDateはセット
		SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM");
		Calendar calendar = Calendar.getInstance();
		Date date = new Date();
		calendar.add(Calendar.MONTH, -1);
		date = calendar.getTime();
		String d3 = df2.format(date);

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SM", "sa", "kawasaki");

			// SQL文を準備する
			String sql = "SELECT * FROM Fixed WHERE (f_date LIKE ?) AND (f_date NOT LIKE ?) AND (user_id = ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			//前月
			pStmt.setString(1,  d3 + "%");
			//当月
			pStmt.setString(2, param.getF_date() + "%");
			pStmt.setInt(3, param.getUser_id());

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Fixed list = new Fixed(
						rs.getInt("f_id"),
						rs.getString("f_date"),
						rs.getString("f_category"),
						rs.getString("f_memo"),
						rs.getInt("f_cost"),
						rs.getInt("user_id"));
						//rs.getInt("f_sorting")
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
			String sql = "INSERT INTO Fixed(f_date, f_category, f_memo, f_cost, user_id) VALUES(?,?,?,?,?)";
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
			pStmt.setInt(5, param.getUser_id());

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}


	// selectで取得したデータを日付を一か月後にして再登録する
		public boolean f_insert(Fixed param) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SM", "sa", "kawasaki");

				// SQL文を準備する
				String sql = "INSERT INTO Fixed(f_date, f_category, f_memo, f_cost, user_id) VALUES(ADD_MONTHS(?, 1),?,?,?,?)";
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
				pStmt.setInt(5, param.getUser_id());

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
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
			if (param.getF_id() != 0) {
				pStmt.setInt(5, param.getF_id());
			} else {
				pStmt.setInt(5, 0);
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
