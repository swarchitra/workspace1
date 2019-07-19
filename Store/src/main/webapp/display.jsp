<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product table here</title>
</head>
<body>
	<h2>Enter values of the product..</h2>
	<form action="createproduct" method="get">
		<label>Product Name</label>: <input type="text" name="pname"/><br>
		<label>Product Price</label>: <input type="text" name="pprice"/><br>
		<label>Product QoH</label>: <input type="text" name="pqoh"/><br>
		<input type="submit" value="create" name="create"/>
	</form>

<h4>Product</h4>
<table border="2">
<tr>
	<th>Name</th>
	<th>Price</th>
	<th>QOH</th>
</tr>
<c:forEach var="product" items="${products}">
	<tr>
	<td>${product.name}</td>
	<td>${product.price}</td>
	<td>${product.qoh}</td>
	<td><a href="delete?id=${product.id}">remove</a></td>
	</tr>

</c:forEach>
</table>
</body>
</html>