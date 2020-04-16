package com.loggar.servlet.concept;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContentTypeTracking extends HttpServlet {
	private static final long serialVersionUID = 8869658726225190558L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse reqeust)
			throws ServletException, IOException {
		
		System.out.println(isAjaxRequest(request.getContentType()));
	}

	private boolean isAjaxRequest(String contentType) {
		if (contentType == null)
			return false;
		if (contentType.indexOf("application/json") == 0)
			return true;
		return false;
	}
}
