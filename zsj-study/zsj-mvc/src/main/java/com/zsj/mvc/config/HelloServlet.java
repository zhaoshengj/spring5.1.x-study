package com.zsj.mvc.config;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet");

		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		out.write("Hello请求");
		out.flush();
		out.close();
		System.out.println("访问成功");
		//super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost");
		super.doPost(req, resp);
	}
}
