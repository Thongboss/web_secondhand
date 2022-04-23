package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;
import entities.Product;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO;

	public CartServlet() {
		super();
		this.productDAO = new ProductDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpSession session = httpReq.getSession();
//		List<Product> list = new ArrayList<Product>();
		System.out.println(request.getParameter("id"));
		Product pro = this.productDAO.findById(Integer.parseInt(request.getParameter("id")));
//		int so = Integer.parseInt(request.getParameter("id"));
		int so = 1;
		
		request.setAttribute("soluong", so);
		
		if (pro.getSoLuong() < so) {
			request.setAttribute("canhbao",
					"The purchase quantity cannot be greater than the number of products available in the store");
			response.sendRedirect("/thongvhph13968_assignment_java4/home");
			return;
		}
		pro.setSoLuong(so);
		System.out.println(pro.getTensp());
//		list.add(pro);
		
		List<Product> listpro = (List<Product>) session.getAttribute("listpro");
		if(listpro == null) {
			listpro = new ArrayList<Product>();
		}
		listpro.add(pro);
		
		session.setAttribute("listpro", listpro);

//		request.setAttribute("listpro", listpro);

		request.setAttribute("view", "/views/home/cart.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
