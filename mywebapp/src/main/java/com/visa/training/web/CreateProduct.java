package com.visa.training.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.visa.training.jdbc.*;

@WebServlet("/createproduct")
public class CreateProduct extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		PrintWriter out  = response.getWriter();
		out.println("<html><body><h4>The product is created with pid "+generated_id+"</h4></body></html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
