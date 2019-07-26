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
<meta charset="UTF-8">
<title>Books</title>
</head>
<body>
	<h2>Books!!</h2>
	<h3>Book Creation</h3>
	<form:form method="POST"   action = "/display" modelAttribute="book">
    Name: <form:input path="name" /> 
	Author: <form:input path="author"/> <br>
	Category: <form:input path="category"/> <br>
	Year of Release: <form:input path="releaseYear"/>
<input type="submit" value="Add">
</form:form>
<h4>Books</h4>
<table border="2">
<tr>
	<th>ID</th>
	<th>Name</th>
	<th>Author</th>
	<th>Category</th>
	<th>Chapters</th>
</tr>
<c:forEach var="book" items="${books}">
	<tr>
	<td>${book.id}</td>
	<td>${book.name}</td>
	<td>${book.author}</td>
	<td>${book.category}</td>
	<c:forEach var="chapter" items="${book.chapters}">
	<td>ID: ${chapter.id} INDEX: ${chapter.index} NP: ${chapter.numPages}</td></c:forEach>
	
	</tr>

</c:forEach>
</table>

</body>
</html>