package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import dao.UserDAO;
import entities.Product;
import entities.User;
import utils.EncryptUtil;
import utils.CheckUtil;

@WebServlet({ "/users/index", "/users/create", "/users/store", "/users/edit", "/users/update", "/users/delete",
		"/users/show", "/error"})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;

	public UserServlet() {
		super();
		this.userDAO = new UserDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();

		if (uri.contains("index")) {
			this.index(request, response);
		} else if (uri.contains("create")) {
			this.create(request, response);
		} else if (uri.contains("edit")) {
			this.edit(request, response);
		} else if (uri.contains("delete")) {
			this.delete(request, response);
		} else if (uri.contains("show")) {
			this.show(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();

		if (uri.contains("store")) {
			try {

				this.store(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (uri.contains("update")) {

			this.update(request, response);

		} else {
			response.sendRedirect("/thongvhph13968_assignment_java4/error");
		}
	}

	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> ds = this.userDAO.all();

		request.setAttribute("ds", ds);

		request.setAttribute("view", "/views/admin/users/index.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);

	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("view", "/views/admin/users/create.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);

	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idStr = request.getParameter("id");

		int id = Integer.parseInt(idStr);

		User entity = this.userDAO.findById(id);

		request.setAttribute("user", entity);

		request.setAttribute("view", "/views/admin/users/edit.jsp");

		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String idstr = request.getParameter("id");
		int id = Integer.parseInt(idstr);
		User entity = this.userDAO.findById(id);
		try {
			this.userDAO.delete(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.sendRedirect("/thongvhph13968_assignment_java4/users/index");

	}

	private void show(HttpServletRequest request, HttpServletResponse response) {

	}

	private void store(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		try {
			User entity = new User();
			BeanUtils.populate(entity, request.getParameterMap());

			String encrypted = EncryptUtil.encrypt(request.getParameter("password"));

			entity.setPassword(encrypted);	
			
//			if(CheckUtil.checkNull(entity.getHoTen()) == false || CheckUtil.checkEmail(entity.getEmail()) == false || CheckUtil.checkNull(entity.getPassword()) == false 
//					|| CheckUtil.checkNull(entity.getDiaChi()) == false || CheckUtil.checkNull(entity.getSdt()) == false) {
//				
//				request.setAttribute("warning", "Information fields cannot be left blank, email needs to be in the correct format.");
//				
//				request.setAttribute("view", "/views/admin/users/create.jsp");
//				request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
//			}
			
			this.userDAO.create(entity);

			session.setAttribute("message", "successfully added new!");

			response.sendRedirect("/thongvhph13968_assignment_java4/users/index");
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error", "new add failure!");
			response.sendRedirect("/thongvhph13968_assignment_java4/users/create");
		}

	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		HttpSession session = request.getSession();
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		User oldValue = this.userDAO.findById(id);

		User entity = new User();
		try {
			BeanUtils.populate(entity, request.getParameterMap());
			entity.setPassword(oldValue.getPassword());

			this.userDAO.update(entity);
			
//			session.setAttribute("message", "sửa thành công");

			response.sendRedirect("/thongvhph13968_assignment_java4/users/index");
		} catch (Exception e) {
			e.printStackTrace();
//			session.setAttribute("error", "sửa thất bại");
//			response.sendRedirect("/thongvhph13968_assignment_java4/users/index");
		}
	}

}
