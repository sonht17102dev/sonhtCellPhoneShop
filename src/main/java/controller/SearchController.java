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

import dao.ListProductDAO;
import model.Product;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/search")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchController() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			processRequest(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8"); // search bang tieng viet
		HttpSession session = request.getSession();
		String txtSearch = request.getParameter("txt");
		String name = request.getParameter("name");
		ListProductDAO dao = new ListProductDAO();
		List<Product> list = dao.searchByName(txtSearch);
		/*
		 * Neu list rong, user de trong thi hien thi error
		 */
		if (list.isEmpty()) {
			session.setAttribute("error",
					"<p style='color:red; text-align: center;'><strong>Can't find product.<br>Try to find another product</strong></p>");

		} else if (txtSearch.trim().equals("")) {
			session.setAttribute("error",
					"<p style='color:red; text-align: center;'><strong>Search input can not contains space!</strong></p>");
		} else {
			session.removeAttribute("error");
			request.setAttribute("listProduct", list);
		}
		request.setAttribute("inputSearch", txtSearch); // Sử dụng EL để lưu trữ dữ liệu nhập vào trên form search
		request.getRequestDispatcher("search.jsp").forward(request, response);
	}
}
