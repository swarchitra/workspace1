<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shopping Cart here</title>
</head>
<body>
<h4>Selected Books</h4>
<ul>
   <c:forEach var="aBook" items="${selectedBooks}">
   
   	<li>${aBook}</li>
   
   </c:forEach> 
</ul>
<h4>Selected Cars</h4>
<ul>
   <c:forEach var="aCar" items="${selectedCars}">
   
   	<li>${aCar}</li>
   
   </c:forEach>  
</ul>

<h4>Selected Bikes</h4>
<ul>
    <c:forEach var="aBike" items="${selectedBikes}">
   
   	<li>${aBike}</li>
   
   </c:forEach> 
</ul>

</body>
</html>