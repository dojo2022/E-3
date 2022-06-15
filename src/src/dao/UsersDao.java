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
		// ログインできるならtrueを返す
		public boolean isLoginOK(Users idpw) {
			Connection conn = null;
			boolean loginResult = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SM", "sa", "kawasaki");

				// SELECT文を準備する
				String sql = "select count(*) from IDPW where ID = ? and PW = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, idpw.getLogin_id());
				pStmt.setString(2,idpw.getPassword());

				// SELECT文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
				rs.next();
				if (rs.getInt("count(*)") == 1) {
					loginResult = true;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				loginResult = false;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				loginResult = false;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						loginResult = false;
					}
				}
			}

			// 結果を返す
			return loginResult;
		}
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
	// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
	public boolean update(Users user) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SM", "sa", "kawasaki");

			// SQL文を準備する
			String sql = "UPDATE User SET reason=?, goal=?, deadline=? ,savings=? ,salary=? constitution=? WHERE user_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (user.getReason() != null && !user.getReason().equals("")) {
				pStmt.setString(1, user.getReason());
			}
			else {
				pStmt.setString(1, null);
			}
			if (user.getGoal() != 0) {
				pStmt.setInt(2, user.getGoal());
			}
			else {
				pStmt.setInt(2, 0);
			}
			if (user.getDeadline() != null && !user.getDeadline().equals("")) {
				pStmt.setString(3, user.getDeadline());
			}
			else {
				pStmt.setString(3, null);
			}
			if (user.getSavings() != 0) {
				pStmt.setInt(4, user.getSavings());
			}
			else {
				pStmt.setInt(4, 0);
			}
			if (user.getSalary() != 0) {
				pStmt.setInt(5, user.getSalary());
			}
			else {
				pStmt.setInt(5, 0);
			}
			if (user.getConstitution() != null && !user.getConstitution().equals("")) {
				pStmt.setString(6, user.getConstitution());
			}
			else {
				pStmt.setString(6, null);
			}

			pStmt.setString(7, user.getUser_id());

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
