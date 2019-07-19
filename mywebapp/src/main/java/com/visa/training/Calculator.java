package com.visa.training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("calculator")
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String number1 = request.getParameter("num1");
		String number2 = request.getParameter("num2");
		String op = request.getParameter("op");
		double n1 = Double.parseDouble(number1);
		double n2 = Double.parseDouble(number2);
		double res = 0; //pass this local variable from servlet to jsp  request attributes can be used
		if(op.equals("+"))
			res = n1 + n2;
		else if(op.equals("-"))
			res = n1 - n2;
		else if(op.equals("*"))
			res = n1 * n2;
		else if(op.equals("/"))
			res = n1 / n2;
		else
			res = 0;
		
		//PrintWriter out = response.getWriter();
		//out.println(n1+ " "+ op +" "+ n2 + " = "+res );
		request.setAttribute("result",res);
		request.getRequestDispatcher("calciresult.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
