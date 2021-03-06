<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<style>
{
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #ddd;
  padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2;}

tr:hover {background-color: #ddd;}

th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
</style>


<head>
<meta charset="ISO-8859-1">
<title>Product table here</title>
</head>
<body>
	<h2>Enter values of the product..</h2>
<form:form method="POST"  commandName="product" >
Name <form:input path="name" /> 
Price <form:input path="price"/> <br>
QoH <form:input path="qoh"/> <br>
<input type="submit" value="Add">
</form:form>

<h4>Product</h4>
<table border="2">
<tr>
	<th>ID</th>
	<th>Name</th>
	<th>Price</th>
	<th>QOH</th>
	<th>Action</th>
</tr>
<c:forEach var="product" items="${products}">
	<tr>
	<td>${product.id}</td>
	<td>${product.name}</td>
	<td>${product.price}</td>
	<td>${product.qoh}</td>
	<td><a href="delete?id=${product.id}">remove</a></td>
	</tr>

</c:forEach>
</table>
</body>
</html>