package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
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
		//1つのデーブルからデータ取得
		HttpSession sessionuser = request.getSession();
		if (sessionuser.getAttribute("user_id") == null) {
			response.sendRedirect("/selfManagement/LoginServlet");
			return;
		}
		int user_id = (int)sessionuser.getAttribute("user_id");

		//スケジュールテーブルからデータを取得
		ScheduleDao SDao = new ScheduleDao();
		List<Schedule> scheduleList = SDao.display5(user_id);
		request.setAttribute("scheduleList", scheduleList);

		//今日の日付を取得
		Date date = new Date();

		//値の書式を指定
		SimpleDateFormat df = new SimpleDateFormat("MM");
		SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM");
		SimpleDateFormat df3 = new SimpleDateFormat("yyyy");

		//検索処理を行う
		UserDao uDao = new UserDao();
		User user = uDao.display(user_id);

		//日付取得
		Date date1 = uDao.deadline(user_id);
		int d1 = Integer.parseInt(df.format(date1));	//達成期限
		int d2 = Integer.parseInt(df.format(date));	//今月
		int y1 = Integer.parseInt(df3.format(date1));	//達成年
		int y2 = Integer.parseInt(df3.format(date));	//今年

		int deadline = d1 - d2;
		int year = y1 - y2;

		String d3 = df2.format(date);

		//体質取得
		String constitution = uDao.constitution(user_id);

		//残高を計算する
		//固定費検索処理を行う
		FixedDao fDao = new FixedDao();
		List<Fixed> fixedList = fDao.fixed(new Fixed(0, d3, "", "", 0, user_id));
		//検索結果をリクエストスコープに格納する
		request.setAttribute("fixedList", fixedList);

		if(fixedList == null || fixedList.size() == 0) {
			//固定費検索処理を行う
			FixedDao ffDao = new FixedDao();
			List<Fixed> fixedUpList = ffDao.select(new Fixed(0, d3, "", "", 0, user_id));
			//固定費の再登録
			if(fixedUpList != null) {
				for(int i = 0; i < fixedUpList.size(); i++) {
					ffDao.f_insert(fixedUpList.get(i));
				}
			}

		}

		//変動費検索処理を行う
		VariableDao vDao = new VariableDao();
		List<Variable> variableList = vDao.variable(new Variable(0, d3, "", "", 0, user_id));
		//検索結果をリクエストスコープに格納する
		request.setAttribute("variableList", variableList);




		//検索結果をリクエストスコープに格納する
		request.setAttribute("deadline", deadline); //達成期限と今月の差
		request.setAttribute("year", year);			//達成期限(年)
		request.setAttribute("date1", date1);       //達成期限(月)
		request.setAttribute("user", user);			//ユーザデータ
		request.setAttribute("constitution", constitution);

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
