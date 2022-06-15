package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Users;

public class UsersDao {
	//データ全件取得
		public List<Users> display() {
			Connection conn = null;
			List<Users> userList = new ArrayList<Users>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SM", "sa", "kawasaki");

				// SQL文を準備する
				String sql = "SELECT user_id,reason,goal,deadline,savings,salary,constitution FROM User WHERE user_id = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while(rs.next()) {
					Users userl = new Users();
					userl.getUser_id();
					userl.setReason(rs.getString("reason"));
					userl.setGoal(rs.getInt("goal"));
					userl.setDeadline(rs.getString("deadline"));
					userl.setSalary(rs.getInt("salary"));
					userl.setConstitution(rs.getString("constitution"));


					userList.add(userl);			}
			}
			catch (SQLException e) {
				e.printStackTrace();
				userList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				userList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						userList = null;
					}
				}
			}

			// 結果を返す
			return userList;
		}


		// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
		public boolean insert(Users user) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SM", "sa", "kawasaki");

				// SQL文を準備する
				String sql = "insert into user (login_id, password, constitution) values (?, ?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (user.getLogin_id() != null && !user.getLogin_id().equals("")) {
					pStmt.setString(1, user.getLogin_id());
				}
				else {
					pStmt.setString(1, null);
				}
				if (user.getPassword() != null && !user.getPassword().equals("")) {
					pStmt.setString(2, user.getPassword());
				}
				else {
					pStmt.setString(2, null);
				}
				if (user.getConstitution() != null && !user.getConstitution().equals("")) {
					pStmt.setString(3, user.getConstitution());
				}
				else {
					pStmt.setString(3, null);
				}


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

}
