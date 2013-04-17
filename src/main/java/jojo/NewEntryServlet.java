package jojo;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class NewEntry
 */
@WebServlet("/NewEntryServlet")
public class NewEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewEntryServlet() {
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
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		
		if(!this.check(name) || !this.check(password) || !this.check(password2)){
			request.setAttribute("message3", "※入力が正しくありません");
			request.getRequestDispatcher("NewEntry.jsp").forward(request,response);
			return; 
		}
		 
		
			if (password.equals(password2)) {

			HttpSession session = request.getSession();
			try {
				UserDao userDao = new UserDao(ConnectionUtils.getConnection());
				int count = userDao.insert(name, password);
				System.out.println(count);

				if (count == 1) {
					UserDto dto = new UserDto(name, password);
					session.setAttribute("userData", dto);
					request.getRequestDispatcher("finish.jsp").forward(request,response);
				} else {
					request.setAttribute("message2", "※既に存在しているユーザ名です");
					request.getRequestDispatcher("NewEntry.jsp").forward(request,response);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} else {
			request.setAttribute("message", "※パスワードが違います");
			request.getRequestDispatcher("NewEntry.jsp").forward(request,response);
		}
	}
	
	private boolean check(String param) {
		if(param != null && !param.equals("")){
			return true;
		}
		return false;
	}

}
