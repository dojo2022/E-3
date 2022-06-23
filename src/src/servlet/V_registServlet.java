package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.VariableDao;
import model.Result;
import model.Variable;

/**
 * Servlet implementation class V_registServlet
 */
@WebServlet("/V_registServlet")
public class V_registServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessionuser = request.getSession();
		if (sessionuser.getAttribute("user_id") == null) {
			response.sendRedirect("/selfManagement/LoginServlet");
			return;
		}
		// 登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/v_regist.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessionuser = request.getSession();
		if (sessionuser.getAttribute("user_id") == null) {
			response.sendRedirect("/selfManagement/LoginServlet");
			return;
		}
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String v_date = request.getParameter("v_date");
		String v_category = request.getParameter("v_category");
		String v_memo = request.getParameter("v_memo");
		int v_cost = Integer.parseInt(request.getParameter("v_cost"));
		int user_id = (int)sessionuser.getAttribute("user_id");

		// 登録処理を行う
		VariableDao vDao = new VariableDao();
		if (vDao.insert(new Variable(0,v_date, v_category, v_memo, v_cost, user_id))) { // 登録成功
			request.setAttribute("result",
					new Result("登録成功しました", "/selfManagement/V_registServlet", "続けて登録","/selfManagement/H_listServlet","家計簿一覧へ"));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
			dispatcher.forward(request, response);
		} else { // 登録失敗
			request.setAttribute("result",
					new Result("登録失敗しました", "/selfManagement/V_registServlet","登録画面へ", "/selfManagement/H_listServlet","家計簿一覧へ"));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
			dispatcher.forward(request, response);
		}
	}

}
