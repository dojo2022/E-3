package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FixedDao;
import model.Fixed;
import model.Result;

/**
 * Servlet implementation class F_registServlet
 */
@WebServlet("/F_registServlet")
public class F_registServlet extends HttpServlet {
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/f_regist.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");

				String f_date = request.getParameter("f_date");
				String f_category = request.getParameter("f_category");
				String f_memo = request.getParameter("f_memo");
				int f_cost = Integer.parseInt(request.getParameter("f_cost"));

				// 登録処理を行う
				FixedDao fDao = new FixedDao();
				if (fDao.insert(new Fixed(f_date, f_category, f_memo, f_cost))) { // 登録成功
					request.setAttribute("result",
							new Result("登録成功しました", "/selfManagement/F_registServlet", "固定費登録画面へ","/selfManagement/H_listServlet","家計簿一覧へ"));
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
					dispatcher.forward(request, response);
				} else { // 登録失敗
					request.setAttribute("result",
							new Result("登録失敗しました", "/selfManagement/F_registServlet","固定費登録画面へ", "/selfManagement/H_listServlet","家計簿一覧へ"));
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
					dispatcher.forward(request, response);
				}
	}

}
