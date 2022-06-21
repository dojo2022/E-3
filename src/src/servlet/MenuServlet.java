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

		//検索処理を行う
		UserDao uDao = new UserDao();
		User user = uDao.display(user_id);

		//日付取得
		Date date1 = uDao.deadline(user_id);
		int d1 = Integer.parseInt(df.format(date1));	//達成期限
		int d2 = Integer.parseInt(df.format(date));	//今月
		int deadline = d1 - d2;
		String d3 = df2.format(date);

		//体質取得
		//String constitution = UserDao.constitution(user_id);

		//残高を計算する
		//固定費検索処理を行う
		FixedDao fDao = new FixedDao();
		List<Fixed> fixedList = fDao.fixed(d3, user_id);
		//検索結果をリクエストスコープに格納する
		request.setAttribute("fixedList", fixedList);

		//変動費検索処理を行う
		VariableDao vDao = new VariableDao();
		List<Variable> variableList = vDao.variable(d3, user_id);
		//検索結果をリクエストスコープに格納する
		request.setAttribute("variableList", variableList);

		//検索結果をリクエストスコープに格納する
		request.setAttribute("deadline", deadline);
		request.setAttribute("user", user);
		//request.setAttribute(constitution, constitution);

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
