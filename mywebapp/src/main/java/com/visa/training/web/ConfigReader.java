package com.visa.training.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfigReader extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletConfig config = getServletConfig();
		String initParamValue = config.getInitParameter("user");
		
		ServletContext application = getServletContext();
		String contextParam = application.getInitParameter("company");
		
		PrintWriter out = resp.getWriter();
		out.println("User = "+initParamValue);
		out.println("Company = "+contextParam);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
