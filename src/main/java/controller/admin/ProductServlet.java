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
import dao.ProductDAO;
import entities.Category;
import entities.Product;
import entities.User;
import utils.EncryptUtil;

@WebServlet({ "/products/index", "/products/create", "/products/store", "/products/update", "/products/edit",
		"/products/delete", "/products/show", "/products/coat", "/products/shirt", "/products/sport", "/products/shorts" })
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO;
	private CategoryDAO categoryDAO;

	public ProductServlet() {
		super();
		this.productDAO = new ProductDAO();
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
		} else if (uri.contains("coat")) {
			this.coat(request, response);
		} else if (uri.contains("shirt")) {
			this.shirt(request, response);
		} else if (uri.contains("sport")) {
			this.sport(request, response);
		} else if (uri.contains("shorts")) {
			this.shorts(request, response);
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

	private void update(HttpServletRequest request, HttpServletResponse response) {
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
//		User oldValue = this.userDAO.findById(id);

		Category cate = this.categoryDAO.findById(id);
//		System.out.println(cate.getId());

		Product entity = new Product();
		try {
			BeanUtils.populate(entity, request.getParameterMap());

			entity.setCategory(cate);
//			entity.setPassword(oldValue.getPassword());

			this.productDAO.update(entity);

//			session.setAttribute("message", "sửa thành công");

			response.sendRedirect("/thongvhph13968_assignment_java4/products/index");
		} catch (Exception e) {
			e.printStackTrace();
//			session.setAttribute("error", "sửa thất bại");
//			response.sendRedirect("/thongvhph13968_assignment_java4/users/index");
		}
	}

	private void store(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		try {

			int cate_id = Integer.parseInt(request.getParameter("category_id"));

			Category cate = this.categoryDAO.findById(cate_id);

			Product entity = new Product();

			BeanUtils.populate(entity, request.getParameterMap());

			entity.setCategory(cate);

//			String encrypted = EncryptUtil.encrypt(request.getParameter("password"));
//
//			entity.setPassword(encrypted);

			this.productDAO.create(entity);

			session.setAttribute("message", "successfully added new!");

			response.sendRedirect("/thongvhph13968_assignment_java4/products/index");
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error", "new add failure!");
			response.sendRedirect("/thongvhph13968_assignment_java4/products/create");
		}

	}

	private void show(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String idstr = request.getParameter("id");
		int id = Integer.parseInt(idstr);
		Product entity = this.productDAO.findById(id);
		try {
			this.productDAO.delete(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.sendRedirect("/thongvhph13968_assignment_java4/products/index");
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		Product entity = this.productDAO.findById(id);

		System.out.println(entity.getGhiChu());

		request.setAttribute("product", entity);

		request.setAttribute("view", "/views/admin/products/edit.jsp");

		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Category> dscate = this.categoryDAO.all();

		request.setAttribute("dscate", dscate);

		request.setAttribute("view", "/views/admin/products/create.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);

	}

	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> dspro = this.productDAO.all();

		request.setAttribute("dspro", dspro);

		request.setAttribute("view", "/views/admin/products/index.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}

	private void shorts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> dspro = this.productDAO.findBycate("Shorts");

		request.setAttribute("dspro", dspro);

		request.setAttribute("view", "/views/admin/products/index.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}

	private void sport(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> dspro = this.productDAO.findBycate("Sport shorts");

		request.setAttribute("dspro", dspro);

		request.setAttribute("view", "/views/admin/products/index.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}

	private void shirt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> dspro = this.productDAO.findBycate("Shirt");

		request.setAttribute("dspro", dspro);

		request.setAttribute("view", "/views/admin/products/index.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}

	private void coat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> dspro = this.productDAO.findBycate("coat");

		request.setAttribute("dspro", dspro);

		request.setAttribute("view", "/views/admin/products/index.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);

	}

}
