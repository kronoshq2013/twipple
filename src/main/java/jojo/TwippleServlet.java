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
 * Servlet implementation class TwippleServlet
 */
@WebServlet("/TwippleServlet")
public class TwippleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TwippleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		

		HttpSession session = request.getSession();
		try {
			UserDao userDao = new UserDao(ConnectionUtils.getConnection());
			int count = userDao.count(name, password);
			System.out.println(count);
			
			if (count == 1) {
				UserDto dto = new UserDto(name, password);
				session.setAttribute("userData", dto);
				request.getRequestDispatcher("home.jsp").forward(request, response);
			} else {
				request.setAttribute("message", "※ユーザー名、またはパスワードが間違っています");
				request.getRequestDispatcher("login.jsp").forward(request,response);
			}	
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
