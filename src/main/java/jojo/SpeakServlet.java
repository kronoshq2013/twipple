package jojo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// Ctrl + Shift + o
/**
 * Servlet implementation class SpeakServlet
 */
@WebServlet("/SpeakServlet")
public class SpeakServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SpeakServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con = null;

		String speak = request.getParameter("speak");
		System.out.println(speak);

		HttpSession session = request.getSession();
		try {
			con = ConnectionUtils.getConnection();
			// Ctrl + 2 Å® l
			UserDao userDao = new UserDao(con);
			int count = userDao.speakInsert(speak);
			System.out.println(count);

			if (count == 1) {
				UserDao dao = new UserDao(con);
				List<TsubuyakiDto> tweets = dao.getSpeak(con);
				
				// 10åèÇæÇØÇ…Ç∑ÇÈ
				List<TsubuyakiDto> tweets10 = new TsubuyakiLogic().extract(tweets);
				
				
				session.setAttribute("users", tweets10);
				request.getRequestDispatcher("home.jsp").forward(request,
						response);
			} else {
				request.setAttribute("message", "Å¶ñ‚ëËÇ™î≠ê∂ÇµÇ‹ÇµÇΩ");
				request.getRequestDispatcher("home.jsp").forward(request,
						response);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
