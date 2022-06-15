package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDao;
import model.Result;
import model.Users;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/U_registServlet")
public class U_registServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		/*
		if (session.getAttribute("login_id") == null) {
			response.sendRedirect("/selfManagement/LoginServlet");
			return;
		}
		*/
		// 登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/u_regist.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String login_id = request.getParameter("login_id");
		String password = request.getParameter("password");
		String constitution = request.getParameter("constitution");
		//↑？？？

		// 登録処理を行う(改造)
		UsersDao uDao = new UsersDao();
		if (request.getParameter("regist").equals("登録")) {
			if (uDao.insert(new Users(login_id, password, constitution))) {	// 登録成功
				request.setAttribute("result",
				new Result("登録しました",login_id + "を登録しました。", "/selfManagement/LoginServlet"));
			}
			else {												// 登録失敗
				request.setAttribute("result",
				new Result("登録失敗！", "会員登録できませんでした。", "/selfManagement/LoginServlet"));
			}
		} else {
			selfManagement/LoginServlet

		}
			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
			dispatcher.forward(request, response);
		}
	}
}
