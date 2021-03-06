package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession sessionuser = request.getSession();
		if (sessionuser.getAttribute("user_id") == null) {
			response.sendRedirect("/selfManagement/LoginServlet");
			return;
		}
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		int user_id = (int)sessionuser.getAttribute("user_id");

		//検索処理を行う
		ScheduleDao sDao = new ScheduleDao();
		List<Schedule> scheduleList = sDao.display(new Schedule(0, "", "", "", user_id));
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
		HttpSession sessionuser = request.getSession();
		if (sessionuser.getAttribute("user_id") == null) {
			response.sendRedirect("/selfManagement/LoginServlet");
			return;
		}
		int user_id = (int)sessionuser.getAttribute("user_id");

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String s_day = request.getParameter("s_day");

		// 検索処理を行う
		ScheduleDao sDao = new ScheduleDao();
		List<Schedule> scheduleList = sDao.select(new Schedule(0, s_day, "", "", user_id));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("scheduleList", scheduleList);

		// スケジュール一覧ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/s_list.jsp");
		dispatcher.forward(request, response);
	}
}


