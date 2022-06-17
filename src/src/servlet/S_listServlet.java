package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ScheduleDao;
import model.Schedule;

//import dao.BcDAO;
//import model.Bc;

/**
 * Servlet implementation class S_listServlet
 */
@WebServlet("/S_listServlet")
public class S_listServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//検索処理を行う
		ScheduleDao sDao = new ScheduleDao();
		List<Schedule> scheduleList = sDao.display();
		//検索結果をリクエストスコープに格納する
		request.setAttribute("scheduleList", scheduleList);


		// スケジュール一覧ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/s_list.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
/*		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/simpleBC/LoginServlet");
			return;
		}
*/
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String s_day = request.getParameter("s_day");

		// 検索処理を行う
		ScheduleDao sDao = new ScheduleDao();
		List<Schedule> scheduleList = sDao.select(new Schedule(0, s_day, "", ""));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("scheduleList", scheduleList);

		// スケジュール一覧ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/s_list.jsp");
		dispatcher.forward(request, response);
	}
}


