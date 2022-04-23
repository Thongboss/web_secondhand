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

import dao.CategoryDAO;
import dao.UserDAO;
import entities.Category;
import entities.User;
import utils.EncryptUtil;

@WebServlet({ "/categories/index", "/categories/create", "/categories/edit", "/categories/delete", "/categories/show",
		"/categories/store", "/categories/update" })
public class CaterogyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	private CategoryDAO categoryDAO;

	public CaterogyServlet() {
		super();
		this.userDAO = new UserDAO();
		this.categoryDAO = new CategoryDAO();
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
			// 404
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		HttpSession session = request.getSession();
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		
		Category cate = this.categoryDAO.findById(id);
		
		User user = cate.getUser();
//		Category oldValue = this.categoryDAO.findById(id);

		Category entity = new Category();
		try {
			String tendm = request.getParameter("tendm");
			
			
			
			entity.setTenDanhmuc(tendm);
			entity.setUser(user);

			this.categoryDAO.update(entity);

//			session.setAttribute("message", "sửa thành công");

			response.sendRedirect("/thongvhph13968_assignment_java4/categories/index");
		} catch (Exception e) {
			e.printStackTrace();
//			session.setAttribute("error", "sửa thất bại");
//			response.sendRedirect("/thongvhph13968_assignment_java4/categories/index");
		}
	}

	private void store(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		try {
			Category entity = new Category();
			
			int user_id = Integer.parseInt(request.getParameter("user_id"));
			
			User user = this.userDAO.findById(user_id);
			
			BeanUtils.populate(entity, request.getParameterMap());
			
			entity.setUser(user);

//			String encrypted = EncryptUtil.encrypt(request.getParameter("password"));
//
//			entity.setPassword(encrypted);

			this.categoryDAO.create(entity);

			session.setAttribute("message", "Thêm mới thành công");

			response.sendRedirect("/thongvhph13968_assignment_java4/categories/index");
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error", "Thêm mới thất bại");
			response.sendRedirect("/thongvhph13968_assignment_java4/categories/create");
		}
	}

	private void show(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String idstr = request.getParameter("id");
		int id = Integer.parseInt(idstr);
		Category entity = this.categoryDAO.findById(id);
		try {
			this.categoryDAO.delete(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.sendRedirect("/thongvhph13968_assignment_java4/categories/index");
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");

		int id = Integer.parseInt(idStr);

		Category entity = this.categoryDAO.findById(id);

		request.setAttribute("category", entity);

		request.setAttribute("view", "/views/admin/categories/edit.jsp");

		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> dsuser = this.userDAO.all();

		request.setAttribute("dsuser", dsuser);

		request.setAttribute("view", "/views/admin/categories/create.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}

	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> dscate = this.categoryDAO.all();

		request.setAttribute("dscate", dscate);

		request.setAttribute("view", "/views/admin/categories/index.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}

}
