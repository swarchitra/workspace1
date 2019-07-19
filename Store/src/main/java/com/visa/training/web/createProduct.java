package com.visa.training.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.visa.training.jdbc.*;

@WebServlet({ "/createproduct", "/display" ,"/delete"})
public class createProduct extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getRequestURI().endsWith("createproduct")) {
		String p_name = request.getParameter("pname");
		String p_price = request.getParameter("pprice");
		String p_qoh = request.getParameter("pqoh");
		double d = Double.parseDouble(p_price);
		int qoh = Integer.parseInt(p_qoh);
		ProductDAO pd = new ProductDAO();
		Product p = new Product();
		p.setName(p_name);
		p.setPrice((float)d);
		p.setQoh(qoh);
		int generated_id = pd.save(p);
		request.getRequestDispatcher("/display").forward(request, response);
		}
		if(request.getRequestURI().endsWith("display")) {
			ProductDAO pd = new ProductDAO();
			List<Product> list = pd.findAll();
			request.setAttribute("products",list);
			request.getRequestDispatcher("display.jsp").forward(request, response);
		}
		if(request.getRequestURI().endsWith("/delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			ProductDAO pd = new ProductDAO();
			pd.remove(id);
			request.getRequestDispatcher("/display").forward(request, response);
		}

		
	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
