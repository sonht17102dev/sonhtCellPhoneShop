package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracle.wls.shaded.org.apache.bcel.generic.NEW;

import dao.ListProductDAO;
import dao.OrdersDAO;
import model.Cart;
import model.Orders;

/**
 * Servlet implementation class PayController
 */
@WebServlet("/PayController")
public class PayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		try {
			HttpSession session = request.getSession(true);
			if(session.getAttribute("cart") == null) {
				session.setAttribute("cart", new Cart());
			}
			OrdersDAO dao = new OrdersDAO();
			Cart c = (Cart) session.getAttribute("cart");
			String username = request.getParameter("name");
			String discount = request.getParameter("discount");
			String address = request.getParameter("address");

			if(username.equals("") || address.equals(""))
			{
				session.setAttribute("error", "Please type in your name and address");
				response.sendRedirect("cart.jsp");
			}
			Orders d = new Orders(username,2,discount,address,"", null);
			dao.insertOrder(d, c);
//			response.sendRedirect("admin/index.jsp");
			request.getRequestDispatcher("HomeController").forward(request, response);
		} catch (Exception e) {
			response.getWriter().println(e);
		}
	}

}
