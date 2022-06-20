package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ScheduleDao;
import dao.UserDao;
import model.Schedule;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//スケジュールテーブルからデータを取得
		ScheduleDao SDao = new ScheduleDao();
		List<Schedule> scheduleList = SDao.display();
		request.setAttribute("slist", scheduleList);
		//1つのデーブルからデータ取得
		HttpSession sessionuser = request.getSession();
		int user_id = (int)sessionuser.getAttribute("user_id");
		LocalDate todaysDate = LocalDate.now();

		//デフォルトのカレンダークラスを宣言、下のDateはセット
		Calendar calendar = Calendar.getInstance();
		Date date = new Date();

		//値の書式を指定
		SimpleDateFormat df = new SimpleDateFormat("MM");
		SimpleDateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");

		//int month = calendar.get(Calendar.MONTH) + 1;
		//calendar.add(Calendar.month, 4);
		//カレンダークラスaddメソッド使用
		calendar.add(Calendar.MONTH, +0);
		 date = calendar.getTime();

		//検索処理を行う
		UserDao uDao = new UserDao();
		Date deadline = uDao.deadline(user_id);

		//検索結果をリクエストスコープに格納する
		//request.setAttribute("month",month);
		request.setAttribute("deadline", Integer.parseInt(df.format(deadline)));
		request.setAttribute("today", todaysDate);
		request.setAttribute("date", Integer.parseInt(df.format(date)));

		// メニューページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/menu.jsp");
		dispatcher.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
