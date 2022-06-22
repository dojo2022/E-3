package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FixedDao;
import dao.UserDao;
import dao.VariableDao;
import model.Fixed;
import model.User;
import model.Variable;

/**
 * Servlet implementation class H_listServlet
 */
@WebServlet("/H_listServlet")
public class H_listServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public H_listServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//ユーザ情報を取得
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession sessionuser = request.getSession();
		if (sessionuser.getAttribute("user_id") == null) {
			response.sendRedirect("/selfManagement/LoginServlet");
			return;
		}
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		int user_id = (int)sessionuser.getAttribute("user_id");

		//今日の日付を取得
		Date date = new Date();

		//値の書式を指定
		SimpleDateFormat df = new SimpleDateFormat("MM");
		SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM");
		SimpleDateFormat df3 = new SimpleDateFormat("yyyy");

		//検索処理を行う
		UserDao uDao = new UserDao();
		User user = uDao.display(user_id);

		//日付取得
		Date date1 = uDao.deadline(user_id);
		int d1 = Integer.parseInt(df.format(date1));	//達成期限（月）
		int d2 = Integer.parseInt(df.format(date));	//今月
		int y1 = Integer.parseInt(df3.format(date1));	//達成期限（年）
		int y2 = Integer.parseInt(df3.format(date));	//今年

		int deadline = d1 - d2;
		int year = y1 - y2;

		String d3 = df2.format(date);

		//残高を計算する
		//変動費検索処理を行う
		VariableDao vDao = new VariableDao();
		List<Variable> variableList = vDao.variable(new Variable(0, d3, "", "", 0, user_id));
		//検索結果をリクエストスコープに格納する
		request.setAttribute("variableList", variableList);

		//固定費検索処理を行う
		FixedDao fDao = new FixedDao();
		List<Fixed> fixedList = fDao.fixed(new Fixed(0, "", "", "", 0, user_id));
		//検索結果をリクエストスコープに格納する
		request.setAttribute("fixedList", fixedList);

		//検索結果をリクエストスコープに格納する
		request.setAttribute("deadline", deadline);	//達成期限と今月の差
		request.setAttribute("year", year);			//達成期限（年）
		request.setAttribute("date1", date1);       //達成期限(月)
		request.setAttribute("user", user);			//ユーザーデータ

		// メニューページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/h_list.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ユーザ情報を取得
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession sessionuser = request.getSession();
		if (sessionuser.getAttribute("user_id") == null) {
			response.sendRedirect("/selfManagement/LoginServlet");
			return;
		}
		int user_id = (int)sessionuser.getAttribute("user_id");

		//検索処理
		//検索内容の取得
		request.setCharacterEncoding("UTF-8");
		String h_date = request.getParameter("h_date");


		//変動費検索処理を行う
		VariableDao vDao = new VariableDao();
		List<Variable> variableList = vDao.variable(new Variable(0, h_date, "", "", 0, user_id));
		//検索結果をリクエストスコープに格納する
		request.setAttribute("variableList", variableList);

		//固定費一覧の表示
		FixedDao fDao = new FixedDao();
		List<Fixed> fixedList = fDao.fixed(new Fixed(0, "", "", "", 0, user_id));
		//検索結果をリクエストスコープに格納する
		request.setAttribute("fixedList", fixedList);


		// メニューページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/h_list.jsp");
		dispatcher.forward(request, response);
	}

}
