package controller;

import java.io.IOException;
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
import dao.OrdersDAO;
import model.Cart;
import model.Orders;
import model.Product;

/**
 * Servlet implementation class SearchController2
 */
@WebServlet("/search2")
public class SearchController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController2() {
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
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		try {
			String text =  request.getParameter("name");
//			request.setAttribute("results", new ListProductDAO().searchByName(text));
			ListProductDAO dao = new ListProductDAO();
			List<Product> list11 = dao.searchByName(text);
			List<Product> listX = dao.searchByName(text);
			List<Product> list7 = dao.searchByName(text);
			HttpSession session = request.getSession();
			if (list7.isEmpty() || list11.isEmpty() || listX.isEmpty()) {
				session.setAttribute("error",
						"<p style='color:red; text-align: center;'><strong>Can't find product.<br>Try to find another product</strong></p>");

			} else {
				session.removeAttribute("error");
				request.setAttribute("list7", list7);
				request.setAttribute("listX", listX);
				request.setAttribute("list11", list11);
			}
			request.getRequestDispatcher("search.jsp").forward(request, response);
		} catch (Exception e) {
			response.getWriter().println(e);
		}
	}

}
