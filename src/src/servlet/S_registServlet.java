package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ScheduleDao;
import model.Result;
import model.Schedule;

/**
 * Servlet implementation class S_registServlet
 */
@WebServlet("/S_registServlet")
public class S_registServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		HttpSession sessionuser = request.getSession();
		if (sessionuser.getAttribute("user_id") == null) {
			response.sendRedirect("/selfManagement/LoginServlet");
			return;
		}
		//int user_id = (int)sessionuser.getAttribute("user_id");

		// 登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/s_regist.jsp");
		dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		HttpSession sessionuser = request.getSession();
		if (sessionuser.getAttribute("user_id") == null) {
			response.sendRedirect("/selfManagement/LoginServlet");
			return;
		}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String s_date = request.getParameter("s_date");
		String s_category = request.getParameter("s_category");
		String s_memo = request.getParameter("s_memo");
		int user_id = (int)sessionuser.getAttribute("user_id");

		// 登録処理を行う
		ScheduleDao sDao = new ScheduleDao();
		if (sDao.insert(new Schedule(0, s_date, s_category, s_memo, user_id))) { // 登録成功
			request.setAttribute("result",
					new Result("登録成功しました", "/selfManagement/S_registServlet","続けて登録", "/selfManagement/S_listServlet","スケジュール一覧へ"));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
			dispatcher.forward(request, response);
		} else { // 登録失敗
			request.setAttribute("result",
					new Result("登録失敗しました", "/selfManagement/S_registServlet", "登録画面に戻る", "/selfManagement/S_listServlet", "スケジュール一覧へ"));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
			dispatcher.forward(request, response);
		}
	}

}
