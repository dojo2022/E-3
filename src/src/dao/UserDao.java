package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDao {

	// ログインできるならtrueを返す
	public boolean isLoginOK(User idpw) {
		Connection conn = null;
		boolean loginResult = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SM", "sa", "kawasaki");

			// SELECT文を準備する
			String sql = "select count(*) from User where login_id = ? and password = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,idpw.getLogin_id());
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


	//user取得
	public User display(int user_id) {
		Connection conn = null;
		User user = new User();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SM", "sa", "kawasaki");

			// SQL文を準備する
			String sql = "SELECT user_id,reason,goal,deadline,savings,salary,constitution FROM User WHERE user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, user_id);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();



			// 結果表をコレクションにコピーする
			while(rs.next()) {
				user.getUser_id();
				user.setReason(rs.getString("reason"));
				user.setGoal(rs.getInt("goal"));
				user.setDeadline(rs.getString("deadline"));
				user.setSalary(rs.getInt("salary"));
				user.setConstitution(rs.getString("constitution"));

			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			user = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			user = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					user = null;
				}
			}
		}

		// 結果を返す
		return user;
	}


	// 引数userで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(User user) {
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

	// 引数userで指定されたレコードを更新し、成功したらtrueを返す
	public boolean update(User user) {
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

			pStmt.setInt(7, user.getUser_id());

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

	//user_id取得
	public int id(String login_id, String password){
		Connection conn = null;
		int user_id = 0;


		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SM", "sa", "kawasaki");

			// SQL文を準備する
			String sql = "SELECT user_id FROM User WHERE login_id= ? and password= ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, login_id);
			pStmt.setString(2, password);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				user_id = (rs.getInt("user_id"));
			}

		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
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
		return user_id;
	}
}
