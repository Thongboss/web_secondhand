package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;
import dao.UserDAO;
import entities.Product;
import utils.EncryptUtil;


@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO;
	private UserDAO userDAO;
       

    public HomeServlet() {
        super();
        this.productDAO = new ProductDAO();
        this.userDAO = new UserDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> list = this.productDAO.all();
		
		request.setAttribute("list", list);
		
		request.setAttribute("view", "/views/home/home.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String email = request.getParameter("email"), pwd = request.getParameter("password");
		
//		System.out.println(email);
//		System.out.println(pwd);

		if (email.length() == 0 || pwd.length() == 0) {
			session.setAttribute("error", "cannot be left blank");
			response.sendRedirect("/thongvhph13968_assignment_java4/login");
		}
		entities.User user = this.userDAO.findByEmail(email);
		boolean check = EncryptUtil.check(pwd, user.getPassword());
//		System.out.println(user.getEmail());
//		System.out.println(check);

		if (check == true) {
			// Đăng nhập thành công
			
			session.setAttribute("user", user);

			List<Product> list = this.productDAO.all();

			request.setAttribute("list", list);

			request.setAttribute("view", "/views/home/home.jsp");
			request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
		} else {
			// Đăng nhập thất bại
			request.getRequestDispatcher("/views/login.jsp").forward(request, response);
		}
	}

}
