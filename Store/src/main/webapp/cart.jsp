<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shopping Cart here</title>
</head>
<body>
<%
    String[] selectedCars = (String[]) session.getAttribute("selectedCars");
    String[] selectedBooks = (String[]) session.getAttribute("selectedBooks");
    String[] selectedBikes = (String[]) session.getAttribute("selectedBikes");
%>
<h4>Selected Books</h4>
<ul>
    <%for(String aBook : selectedBooks) 
    {
    %>
        <li><%=aBook %></li>
    <%
    }
    %>
</ul>
<h4>Selected Cars</h4>
<ul>
    <%for(String aCar : selectedCars) 
    {
    %>
        <li><%= aCar %></li>
    <%
    }
    %>
</ul>

<h4>Selected Bikes</h4>
<ul>
    <%for(String aBike : selectedBikes) 
    {
    %>
        <li><%= aBike %></li>
    <%
    }
    %>
</ul>

</body>
</html>