package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracle.wls.shaded.org.apache.bcel.generic.NEW;

import dao.ListProductDAO;
import model.Cart;
import model.CartDetails;
import model.Product;

/**
 * Servlet implementation class AddToCartController
 */
@WebServlet("/AddToCartController")
public class AddToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToCartController() {
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
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try {
			HttpSession session = request.getSession(true);
			String idd = request.getParameter("id");
			String action = request.getParameter("action");
			String quantity = request.getParameter("quantity");
			if (action!=null && action.equalsIgnoreCase("add")) {
				if(session.getAttribute("cart")==null) {
					session.setAttribute("cart", new Cart());
				}
				int id = Integer.parseInt(idd);
				Product p =new ListProductDAO().getProduct(id);
				Cart c = (Cart) session.getAttribute("cart");
				c.add(new Product(p.getId(),
							p.getName(),
							p.getDescription(),
							p.getPrice(),
							p.getSrc(),
							p.getType(),
							p.getBrand()),
						Integer.parseInt(quantity));
				response.sendRedirect("cart.jsp");
			} 
			else if (action!=null && action.equalsIgnoreCase("delete")){
				int id = Integer.parseInt(idd);
				Cart c = (Cart) session.getAttribute("cart");
				c.remove(id);
				response.sendRedirect("cart.jsp");
			} 

		} catch (Exception ex) {
			response.getWriter().println(ex);
		}
	}

}
