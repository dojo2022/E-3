package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Variable;

public class VariableDao {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
		public List<Variable> select(Variable param) {
			Connection conn = null;
			List<Variable> variableList = new ArrayList<Variable>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SM", "sa", "kawasaki");

				// SQL文を準備する
				String sql = "SELECT v_date, v_category, v_memo, v_cost FROM Varoable WHERE v_date LIKE ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (param.getV_date() != null) {
					pStmt.setString(1, "%" + param.getV_date() + "%");
				} else {
					pStmt.setString(1, "%");
				}

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Variable list = new Variable(
							rs.getString("v_date"),
							rs.getString("v_category"),
							rs.getString("v_memo"),
							rs.getInt("v_cost"));
					variableList.add(list);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				variableList = null;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				variableList = null;
			} finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
						variableList = null;
					}
				}
			}

			// 結果を返す
			return variableList;
		}

		public List<Variable> select() {
			Connection conn = null;
			List<Variable> variableList = new ArrayList<Variable>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SM", "sa", "kawasaki");

				// SQL文を準備する
				String sql = "SELECT * FROM Variable";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Variable list = new Variable(
							rs.getString("v_date"),
							rs.getString("v_category"),
							rs.getString("v_memo"),
							rs.getInt("v_cost"));
					variableList.add(list);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				variableList = null;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				variableList = null;
			} finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
						variableList = null;
					}
				}
			}

			// 結果を返す
			return variableList;
		}

		// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
		public boolean insert(Variable param) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SM", "sa", "kawasaki");

				// SQL文を準備する
				String sql = "INSERT INTO Variable(v_date, v_category, v_memo, v_cost) VALUES(?,?,?,?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (param.getV_date() != null && !param.getV_date().equals("")) {
					pStmt.setString(1, param.getV_date());
				} else {
					pStmt.setString(1, null);
				}
				if (param.getV_category() != null && !param.getV_category().equals("")) {
					pStmt.setString(2, param.getV_category());
				} else {
					pStmt.setString(2, null);
				}
				if (param.getV_memo() != null && !param.getV_memo().equals("")) {
					pStmt.setString(3, param.getV_memo());
				} else {
					pStmt.setString(3, null);
				}
				if (param.getV_cost() != 0) {
					pStmt.setInt(4, param.getV_cost());
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
		public boolean update(Variable param) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SM", "sa", "kawasaki");

				// SQL文を準備する
				String sql = "UPDATE Variable SET v_date=?, v_category=?, v_memo=?,v_cost=? WHERE v_id=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (param.getV_date() != null && !param.getV_date().equals("")) {
					pStmt.setString(1, param.getV_date());
				} else {
					pStmt.setString(1, null);
				}
				if (param.getV_category() != null && !param.getV_category().equals("")) {
					pStmt.setString(2, param.getV_category());
				} else {
					pStmt.setString(2, null);
				}
				if (param.getV_memo() != null && !param.getV_memo().equals("")) {
					pStmt.setString(3, param.getV_memo());
				} else {
					pStmt.setString(3, null);
				}
				if (param.getV_cost() != 0) {
					pStmt.setInt(4, param.getV_cost());
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
			public boolean delete(int v_id) {

				Connection conn = null;
				boolean result = false;

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

					// SQL文を準備する
					String sql = "delete from Variable where v_id=?";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を完成させる
					pStmt.setInt(1, v_id);

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
