package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FixedDao;
import model.Fixed;
import model.Result;

/**
 * Servlet implementation class F_registServlet
 */
@WebServlet("/F_registServlet")
public class F_registServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessionuser = request.getSession();
		if (sessionuser.getAttribute("user_id") == null) {
			response.sendRedirect("/selfManagement/LoginServlet");
			return;
		}
		// 登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/f_regist.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession sessionuser = request.getSession();
		if (sessionuser.getAttribute("user_id") == null) {
			response.sendRedirect("/selfManagement/LoginServlet");
			return;
		}
		// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				String f_date = request.getParameter("f_date");
				String f_category = request.getParameter("f_category");
				String f_memo = request.getParameter("f_memo");
				int f_cost = Integer.parseInt(request.getParameter("f_cost"));
				int user_id = (int)sessionuser.getAttribute("user_id");

				//デフォルトのカレンダークラスを宣言、下のDateはセット
				SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM");
				SimpleDateFormat df3 = new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
				String d3 = df2.format(date);
				String f_date3;

				//当月以前の固定費登録
				if(f_date.compareTo(d3) < 0) {
					Date d4 = new Date();
					try {
						d4 =  df3.parse(f_date);
					}
					catch (ParseException e) {
						e.printStackTrace();
					}
					Calendar calendar = java.util.Calendar.getInstance();
					calendar.setTime(d4);
					int i = 0;
					Date date2 = new Date();
					String f_date2 = "";
					do{
						calendar.add(Calendar.MONTH, i);
						date2 = calendar.getTime();
						f_date2 = new SimpleDateFormat("yyyy-MM-dd").format(date2);
						f_date3 = new SimpleDateFormat("yyyy-MM").format(date2);
						FixedDao fDao = new FixedDao();
						//当月の固定費登録
						if(f_date3.compareTo(d3) == 0) {
							if (fDao.insert(new Fixed(0, f_date2, f_category, f_memo, f_cost,user_id))) {
								// 登録成功
								request.setAttribute("result",
										new Result("登録成功しました", "/selfManagement/F_registServlet", "固定費登録画面へ","/selfManagement/H_listServlet","家計簿一覧へ"));
								RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
								dispatcher.forward(request, response);
							}
							else { // 登録失敗
								request.setAttribute("result",
										new Result("登録失敗しました", "/selfManagement/F_registServlet","固定費登録画面へ", "/selfManagement/H_listServlet","家計簿一覧へ"));
								RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
								dispatcher.forward(request, response);
							}
						}
						//入力日から前月までのデータの登録
						else {
							fDao.insert(new Fixed(0, f_date2, f_category, f_memo, f_cost,user_id));
							if(i == 0) {
								i ++;
							}
						}
					}while (f_date3.compareTo(d3) < 0);
				}
				//当月と当月以降の固定費登録
				else {
					FixedDao fDao = new FixedDao();
					if (fDao.insert(new Fixed(0, f_date, f_category, f_memo, f_cost,user_id))) {
						// 登録成功
						request.setAttribute("result",
								new Result("登録成功しました", "/selfManagement/F_registServlet", "固定費登録画面へ","/selfManagement/H_listServlet","家計簿一覧へ"));
						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
						dispatcher.forward(request, response);
					}
					else { // 登録失敗
						request.setAttribute("result",
								new Result("登録失敗しました", "/selfManagement/F_registServlet","固定費登録画面へ", "/selfManagement/H_listServlet","家計簿一覧へ"));
						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
						dispatcher.forward(request, response);
					}
				}
	}

}
