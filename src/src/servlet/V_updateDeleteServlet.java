package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VariableDao;
import model.Bc;
import model.Result;

/**
 * Servlet implementation class V_updateDeleteServlet
 */
@WebServlet("/V_updateDeleteServlet")
public class V_updateDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public V_updateDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/v_regist.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		int v_id = Integer.parseInt(request.getParameter("v_id"));
		String v_date = request.getParameter("v_date");
		String v_category = request.getParameter("v_category");
		String v_memo = request.getParameter("v_memo");
		int v_cost = Integer.parseInt(request.getParameter("v_cost"));

		// 更新または削除を行う
		VariableDao vDao = new VariableDao();
		if (request.getParameter("SUBMIT").equals("更新")) {
			if (bDao.update(new Bc(number, name, address, company, department, zip, fax, tel, email))) { // 更新成功
				request.setAttribute("result",
						new Result("レコードを更新しました。"));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search.jsp");
				dispatcher.forward(request, response);
			} else { // 更新失敗
				request.setAttribute("result",
						new Result("レコードを更新できませんでした。"));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search_result.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			if (bDao.delete(number)) { // 削除成功
				request.setAttribute("result",
						new Result("レコードを削除しました。"));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search.jsp");
				dispatcher.forward(request, response);
			} else { // 削除失敗
				request.setAttribute("result",
						new Result("レコードを削除できませんでした。"));
				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
				dispatcher.forward(request, response);
			}
		}
	}

}
