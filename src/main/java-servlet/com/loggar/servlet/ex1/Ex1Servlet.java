package com.loggar.servlet.ex1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex1/*")
public class Ex1Servlet extends HttpServlet {
	private static final long serialVersionUID = -281469142966125140L;
	
	private static final String defaultUrl = "./view";
	private static final String defaultView = "/view/ex1/list.jsp";
	
	private final Service_1 service = new Service_1();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String requestMapping = uri.substring(uri.lastIndexOf("/"), uri.length());
		
		int id = 1;
		
		switch (requestMapping) {
		case "/list":
			req.setAttribute("list", service.list());
			req.setAttribute("model", service.model(id));
			getServletContext().getRequestDispatcher(defaultView).forward(req, res);
			break;
		case "/save":
			String value = "VALUE";
			service.save(id, value);
			res.sendRedirect(defaultUrl);
			break;
		case "/remove":
			service.remove(id);
			res.sendRedirect(defaultUrl);
			break;
		default:
			String errView = getServletContext().getInitParameter("errRequestMappingView");
			getServletContext().getRequestDispatcher(errView).forward(req, res);
			break;
		}
	}

}
