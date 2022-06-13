package servlet;

import java.io.IOException;
//import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

/*		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/selfManagement/LoginServlet");
			return;
		}
*/

		// スケジュール一覧ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/s_list.jsp");
		dispatcher.forward(request, response);


// 検索処理を行う
//BcDAO bDao = new BcDAO();
//List<Bc> cardList0 = bDao.display();
// 検索結果をリクエストスコープに格納する
//request.setAttribute("cardList0", cardList0);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
