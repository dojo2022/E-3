package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ScheduleDAO;
import Schedule;
import model.Result;

/**
 * Servlet implementation class S_registServlet
 */
@WebServlet("/S_registServlet")
public class S_registServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// もしもログインしていなかったらログインサーブレットにリダイレクトする
			HttpSession session = request.getSession();
			if (session.getAttribute("id") == null) {
				response.sendRedirect("/selfManagement/LoginServlet");
				return;
			}

			// 登録ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/selfManagement/jsp/s_regist.jsp");
			dispatcher.forward(request, response);
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// もしもログインしていなかったらログインサーブレットにリダイレクトする
			HttpSession session = request.getSession();
			if (session.getAttribute("id") == null) {
				response.sendRedirect("/selfManagement/LoginServlet");
				return;
			}
			request.setCharacterEncoding("UTF-8");
			String date = request.getParameter("Date");
			String s_category = request.getParameter("S_CATEGORY");
			String memo = request.getParameter("MAMO");

			// 登録処理を行う
			DAO bDao = new BcDAO();
			if (bDao.insert(new Bc(number, cname, name, address, tel))) {	// 登録成功
				request.setAttribute("result",
				new Result("登録成功！", "レコードを登録しました。", "/simpleBC/MenuServlet"));
			}
			else {												// 登録失敗
				request.setAttribute("result",
				new Result("登録失敗！", "レコードを登録できませんでした。", "/simpleBC/MenuServlet"));
			}

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
			dispatcher.forward(request, response);
		}
	}



		}
	}

