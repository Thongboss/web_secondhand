package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.User;

@WebFilter(urlPatterns= {
		"/users/create", "/users/edit", "/users/delete", "/users/update", "/users/store",
		"/products/create", "/products/edit", "/products/delete", "/products/update", "/products/store",
		"/categories/create", "/categories/edit", "/categories/delete", "/categories/update", "/categories/store",
	})
public class Decentralization implements Filter {

    public Decentralization() {
        // TODO Auto-generated constructor stub
    }


	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpRes = (HttpServletResponse) response;
		HttpSession session = httpReq.getSession();
		User user = (User) session.getAttribute("user");
		
		if (user.getRole().equals("user")) {
			request.setAttribute("phan", "You need admin rights to access these functions");
			
			httpRes.sendRedirect("/thongvhph13968_assignment_java4/home");
			return ;
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
