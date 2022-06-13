package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ScheduleDao;
import model.Result;
import model.Schedule;

/**
 * Servlet implementation class V_registServlet
 */
@WebServlet("/S_registServlet")
public class S_registServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/s_regist.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");

		String s_date = request.getParameter("s_date");
		String s_category = request.getParameter("s_category");
		String s_memo = request.getParameter("s_memo");

		// 登録処理を行う
		ScheduleDao sDao = new ScheduleDao();
		if (sDao.insert(new Schedule(s_date, s_category, s_memo))) { // 登録成功
			request.setAttribute("result",
					new Result("登録成功しました", "/selfManagement/S_registServlet", "/selfManagement/S_listServlet"));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
			dispatcher.forward(request, response);
		} else { // 登録失敗
			request.setAttribute("result",
					new Result("登録失敗しました", "/selfManagement/S_registServlet", "/selfManagement/S_listServlet"));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
			dispatcher.forward(request, response);
		}
	}

}
