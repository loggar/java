package com.loggar.servlet.concept;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestTracking extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 228825978198075945L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse reqeust) throws ServletException, IOException {
		// tracking request occuring.
		System.out.println("request.getRemoteAddr={}" + request.getRemoteAddr());
		System.out.println("request.getContentType={}" + request.getContentType());
		System.out.println("request.getProtocol={}" + request.getProtocol());
		System.out.println("request.getMethod={}" + request.getMethod());
		System.out.println("request.getRequestURI={}" + request.getRequestURI());
		System.out.println("request.getContextPath={}" + request.getContextPath());
		System.out.println("request.getServerName={}" + request.getServerName());
		System.out.println("request.getHeader(\"User-Agent\")={}" + request.getHeader("User-Agent"));
	}
}
