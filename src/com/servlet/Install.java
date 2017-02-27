package com.servlet;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Install
 */
public class Install extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Install() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		com.reader.model.code.Install inn = new com.reader.model.code.Install();
		String str = request.getRealPath("\\WEB-INF");
		System.out.println(str);
		inn.getLog4jProperties(str+"\\classes");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
