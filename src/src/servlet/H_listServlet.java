package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FixedDao;
import dao.VariableDao;
import model.Fixed;
import model.Search;
import model.Variable;

/**
 * Servlet implementation class H_listServlet
 */
@WebServlet("/H_listServlet")
public class H_listServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public H_listServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//ユーザ情報を取得
		/*HttpSession sessionuser = request.getSession();
		int user_id = (int) sessionuser.getAttribute("user_id");
		UserDao uDao = new UserDao();
		User user = uDao.display(user_id);
		//検索結果をリクエストスコープに格納する
		request.setAttribute("user", user);*/

		//変動費検索処理を行う
		VariableDao vDao = new VariableDao();
		List<Variable> variableList = vDao.select();
		//検索結果をリクエストスコープに格納する
		request.setAttribute("variableList", variableList);

		//固定費検索処理を行う
		FixedDao fDao = new FixedDao();
		List<Fixed> fixedList = fDao.select();
		//検索結果をリクエストスコープに格納する
		request.setAttribute("fixedList", fixedList);

		// メニューページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/h_list.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//検索処理
		//検索内容の取得
		request.setCharacterEncoding("UTF-8");
		String h_date = request.getParameter("h_date");

		//変動費検索処理を行う
		VariableDao vDao = new VariableDao();
		List<Variable> variableList = vDao.v_search(new Search(h_date));
		//検索結果をリクエストスコープに格納する
		request.setAttribute("variableList", variableList);
/*　固定費検索はなし
		FixedDao fDao = new FixedDao();
		List<Fixed> fixedList = fDao.f_search(new Search(h_date));
		//検索結果をリクエストスコープに格納する
		request.setAttribute("fixedList", fixedList);
*/
		//固定費検索処理を行う
		FixedDao fDao = new FixedDao();
		List<Fixed> fixedList = fDao.select();
		//検索結果をリクエストスコープに格納する
		request.setAttribute("fixedList", fixedList);


		// メニューページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/h_list.jsp");
		dispatcher.forward(request, response);
	}

}
