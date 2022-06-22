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
 * Servlet implementation class F_updateDeleteServlet
 */
@WebServlet("/F_updateDeleteServlet")
public class F_updateDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	* @see HttpServlet#HttpServlet()
	*/
	public F_updateDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession sessionuser = request.getSession();
		if (sessionuser.getAttribute("user_id") == null) {
			response.sendRedirect("/selfManagement/LoginServlet");
			return;
		}
		//int user_id = (int)sessionuser.getAttribute("user_id");

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		int f_id = Integer.parseInt(request.getParameter("f_id"));
		String f_category = request.getParameter("f_category");
		String f_memo = request.getParameter("f_memo");
		int f_cost = Integer.parseInt(request.getParameter("f_cost"));
		FixedDao fDao = new FixedDao();

		if (request.getParameter("submit").equals("更新")) {
			if (fDao.update(new Fixed(f_id, "", f_category, f_memo, f_cost, 0))) { // 更新成功
				response.sendRedirect( "/selfManagement/H_listServlet");
			} else { // 更新失敗
				request.setAttribute("result",
						new Result("レコードを更新できませんでした。", "", "", "", ""));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			if (fDao.delete(f_id)) { // 削除成功
				response.sendRedirect( "/selfManagement/H_listServlet");
			} else { // 削除失敗
				request.setAttribute("result",
						new Result("レコードを削除できませんでした。", "", "", "", ""));
				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
				dispatcher.forward(request, response);
			}
		}
	}

}
