package com.loggar.servlet.ex0;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SampleRealPathServlet extends HttpServlet {
	/**
	 * generated serial version uid
	 */
	private static final long serialVersionUID = 8101412359817900074L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String rootPath = getServletConfig().getServletContext().getRealPath("/");
		File file = new File(rootPath + "WEB-INF/dist/json/rateJSON.txt");
		System.out.println(file.getAbsolutePath());

		Path p = Paths.get("./");
		System.out.println(p);
		System.out.println(p.toAbsolutePath());

		String c = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath()
				+ "../dist/json/sample.json";
		System.out.println(c);
		File file2 = new File(c);
		System.out.println(file2.getAbsolutePath());
	}
}
