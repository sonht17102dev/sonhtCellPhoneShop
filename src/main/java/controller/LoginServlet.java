package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDAO;
import model.Account;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8"); //vietnamese
		List<Account> list = new ArrayList<>();
		try {
			request.getSession(true).invalidate();
			// make sure that email is valid
			String regexMail = "^[A-Z0-9_a-z]+@[A-Z0-9\\.a-z]+\\.[A-Za-z]{2,6}$" ;
			String regex = "[a-zA-Z0-9_!@#$%^&*]+";
			// collect data from a login form
			String user = request.getParameter("username");
			String password = request.getParameter("password");
			Account acc = new Account();
			acc.setUsr(user);
			acc.setPwd(password);
			
			HttpSession session = request.getSession(true);
			if(!password.matches(regex) || !user.matches(regexMail)) {
				session.setAttribute("error", "invalid syntax");
				session.setAttribute("isNew", "no");
				response.sendRedirect("login.jsp");
			}
			if(user.trim().equals("") || password.trim().equals("")) {
				session.setAttribute("error", "Email and password must be filled in!");
				session.setAttribute("isNew", "no");
				response.sendRedirect("login.jsp");
			}
			LoginDAO dao = new LoginDAO();
			acc = dao.checkLogin(user, password);
			list = dao.getAllAccount();
			//check account - use validate code in assignment 1 to valid user
			if (user != null && user.equals(acc.getUsr()) && password.equalsIgnoreCase(acc.getPwd()) && acc.getRole() == 1) {
				//set cookies
				if(request.getParameter("remember")!=null) {
					Cookie cookie1 = new Cookie("user",user);
					Cookie cookie2 = new Cookie("password",password);
					cookie1.setMaxAge(1800);
					cookie2.setMaxAge(1800);
					response.addCookie(cookie1);
					response.addCookie(cookie2);
				}
				
				// set session
				session.setAttribute("acc", acc);
				session.setAttribute("user", user);
				request.getRequestDispatcher("HomeController").forward(request, response);
			} else if (user != null && user.equals(acc.getUsr()) && password.equalsIgnoreCase(acc.getPwd()) && acc.getRole() == 2) {
				session.setAttribute("acc", acc);
				session.setAttribute("user", "Welcome " + acc.getName());
				session.setAttribute("listAccount", list);
				request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
			} 
			else {
				
				session.setAttribute("error", "wrong user mail or password");
				session.setAttribute("isNew", "no");
				response.sendRedirect("login.jsp");
			}
		
		} catch (Exception exception) {
			// TODO: handle exception
			response.getWriter().println(exception);
		}
	}
}
