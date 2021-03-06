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
 * Servlet implementation class S_updateDeleteServlet
 */
@WebServlet("/S_updateDeleteServlet")
public class S_updateDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession sessionuser = request.getSession();
		if (sessionuser.getAttribute("user_id") == null) {
			response.sendRedirect("/selfManagement/LoginServlet");
			return;
		}
		//int user_id = (int)sessionuser.getAttribute("user_id");

		// リクエストパラメータを取得する

		request.setCharacterEncoding("UTF-8");
		int s_id = Integer.parseInt(request.getParameter("s_id"));
		String s_date = request.getParameter("s_date");
		String s_category = request.getParameter("s_category");
		String s_memo = request.getParameter("s_memo");

		// 更新または削除を行う
		ScheduleDao sDao = new ScheduleDao();
		if (request.getParameter("submit").equals("更新")) {
			if (sDao.update(new Schedule(s_id, s_date, s_category, s_memo, 0))) {
				// 更新成功
				response.sendRedirect("/selfManagement/S_listServlet");
			}
			else {
				// 更新失敗
				request.setAttribute("result",
						new Result("レコードを更新できませんでした。", "", "", "/selfManagement/S_listServlet", "スケジュール一覧へ"));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
				dispatcher.forward(request, response);
			}
		}
		else {
			if (sDao.delete(s_id)) {	// 削除成功
				response.sendRedirect("/selfManagement/S_listServlet");
			}
			else {						// 削除失敗
				request.setAttribute("result",
						new Result("レコードを削除できませんでした。", "", "", "/selfManagement/S_listServlet", "スケジュール一覧へ"));
				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
}