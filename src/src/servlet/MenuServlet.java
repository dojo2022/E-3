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

import dao.FixedDao;
import dao.ScheduleDao;
import dao.UserDao;
import dao.VariableDao;
import model.Fixed;
import model.Schedule;
import model.User;
import model.Variable;

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
		List<Schedule> scheduleList = SDao.display5();
		request.setAttribute("scheduleList", scheduleList);


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
		User user = uDao.display(user_id);

		//残高を計算する
		FixedDao fDao = new FixedDao();
		List<Fixed> fixed = fDao.select();
		VariableDao vDao = new VariableDao();
		List<Variable> variable = vDao.select();

		//日付取得
		Date date1 = uDao.deadline(user_id);
		int d1 = Integer.parseInt(df.format(date1));
		int d2 = Integer.parseInt(df.format(date));
		int deadline = d1 - d2;

		//検索結果をリクエストスコープに格納する
		request.setAttribute("deadline", deadline);
		request.setAttribute("user", user);
		request.setAttribute("fixed", fixed);
		request.setAttribute("variable", variable);

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
