package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import dao.LoginDAO;
import model.Account;

/**
 * Servlet implementation class SignupController
 */
@WebServlet("/signup")
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignupController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String userMail = request.getParameter("usermail");
		String userName = request.getParameter("username");
		String userAddress = request.getParameter("address");
		String userPhone = request.getParameter("phone");
		String pass = request.getParameter("password");
		String repass = request.getParameter("repassword");
		LoginDAO dao = new LoginDAO();
		Account acc = new Account(userMail, pass, 1, userName, userAddress, userPhone);
		// Check all fields are validated?
		String validationResult = acc.validate();
		if (!validationResult.isEmpty()) {
			request.setAttribute("usermail", userMail);
			request.setAttribute("password", pass);
			request.setAttribute("username", userName);
			request.setAttribute("address", userAddress);
			request.setAttribute("phone", userPhone);
			request.setAttribute("error", validationResult);

			RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
			rd.forward(request, response);
			return;
		}
		acc = dao.checkLoginExist(userMail);
		if (!pass.equals(repass)) {
			request.setAttribute("message", "Wrong repassword");
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		}
		if (acc == null) {
			// neu account == null thi duoc signup
			dao.signup(userMail, pass, userName, userAddress, userPhone);
			response.sendRedirect("login.jsp");
		} else {
			response.sendRedirect("signup.jsp");
		}

	}
}
