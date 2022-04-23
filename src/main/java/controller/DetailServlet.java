package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import entities.Product;

@WebServlet("/detail")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO;

	public DetailServlet() {
		super();
		this.productDAO = new ProductDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));

		Product product = this.productDAO.findById(id);

//		System.out.println(product.getKichThuoc());

		request.setAttribute("product", product);

		request.setAttribute("view", "/views/home/details.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
//		request.getRequestDispatcher("/views/home/details.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
