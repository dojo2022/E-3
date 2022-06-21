package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.Result;
import model.User;

/**
 * Servlet implementation class U_updateServlet
 */
@WebServlet("/U_updateServlet")
public class U_updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public U_updateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//user_idをスコープから呼び出す
		HttpSession sessionuser = request.getSession();
		int user_id = (int)sessionuser.getAttribute("user_id");

		//検索処理を行う
		UserDao uDao = new UserDao();
		User user = uDao.display(user_id);

		//検索結果をリクエストスコープに格納する
		request.setAttribute("user", user);

		// ユーザ更新ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/u_update.jsp");
		dispatcher.forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//user_idをスコープから呼び出す
		HttpSession sessionuser = request.getSession();
		int user_id = (int)sessionuser.getAttribute("user_id");

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String reason = request.getParameter("reason");
		String deadline = request.getParameter("deadline");
		int goal = Integer.parseInt(request.getParameter("goal"));
		int salary = Integer.parseInt(request.getParameter("salary"));
		String constitution = request.getParameter("constitution");

		// 更新を行う
		UserDao uDao = new UserDao();
		if (request.getParameter("submit").equals("更新")) {
			if (uDao.update(new User(reason, deadline, goal, salary, constitution),user_id)) {	// 更新成功
				request.setAttribute("result",
				new Result("データの更新が完了しました！", "","", "/selfManagement/MenuServlet","メインメニューへ"));
			}
			else {												// 更新失敗
				request.setAttribute("result",
				new Result("データを更新できませんでした。", "", "", "/selfManagement/MenuServlet", "メインメニューへ"));
			}
		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
		dispatcher.forward(request, response);
	}

}
