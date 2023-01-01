package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CRUDDAO;
import dao.LoginDAO;
import model.Account;

/**
 * Servlet implementation class EditAccount
 */
@WebServlet("/EditAccount")
public class EditAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usermail = request.getParameter("usermail");
		CRUDDAO dao = new CRUDDAO();
		Account account = dao.getAccountByUserMail(usermail);
		request.setAttribute("account", account);
		request.getRequestDispatcher("admin/editAccount.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uName = request.getParameter("username");
		String uAddress = request.getParameter("address");
		String uPhone = request.getParameter("phone");
		String uMail = request.getParameter("usermail");
		CRUDDAO dao = new CRUDDAO();
		dao.updateAccount(uName, uAddress, uPhone, uMail);
		LoginDAO daoLogin = new LoginDAO();
		List<Account> list = daoLogin.getAllAccount();
		
		request.setAttribute("listAccount", list);
		request.getRequestDispatcher("admin/admin.jsp").forward(request, response);;
	}

}
