package com.visa.training.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({ "/addbooks", "/addbikes", "/addcars" })
public class ShoppingCart extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String  uri = request.getRequestURI();
			HttpSession session = request.getSession();
			if(uri.endsWith("addbooks")) {
				String[] selected_books =  request.getParameterValues("books");
				session.setAttribute("selectedBooks", selected_books);
				request.getRequestDispatcher("car.html").forward(request, response);
			}
			else if(uri.endsWith("addcars")) {
				String[] selected_cars =  request.getParameterValues("Cars");
				session.setAttribute("selectedCars", selected_cars);
				request.getRequestDispatcher("bike.html").forward(request, response);
			}
			else if(uri.endsWith("addbikes")) {
				String[] selectedBikes =  request.getParameterValues("Bikes");
				session.setAttribute("selectedBikes", selectedBikes);
				String[] selectedBooks = (String[]) session.getAttribute("selectedBooks");
				String[] selectedCars = (String[]) session.getAttribute("selectedCars");
				request.setAttribute("selectedBikes",selectedBikes);
				request.getRequestDispatcher("cart_el.jsp").forward(request, response);
				session.invalidate();
			/*	PrintWriter out = response.getWriter();
	            out.println("<html><body>");
	            out.println("<h4>Selected Books</h4>");
	            out.println("<ul>");
	            Stream.of(selectedBooks).map(s->"<li>"+s+"</li>").forEach(out::println);
	            out.println("</ul>");
	            
	            out.println("<h4>Selected Cars</h4>");
	            out.println("<ul>");
	            Stream.of(selectedCars).map(s->"<li>"+s+"</li>").forEach(out::println);
	            out.println("</ul>");
	            
	            out.println("<h4>Selected Bikes</h4>");
	            out.println("<ul>");
	            Stream.of(selectedBikes).map(s->"<li>"+s+"</li>").forEach(out::println);
	            out.println("</ul>");*/
	            
	            
	            //out.println("</body></html>");session.invalidate();
				
				
				
 			}
			
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
