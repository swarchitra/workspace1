<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result of simple calculator</title>
</head>
<body>
<h2>Simple Calculator</h2>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<form action="calculate" method="get">

<label>Number 1</label>: <input type="number" name="num1"/>
<label>Number 2</label>: <input type="number" name="num2"/>
<br/>
<br/>
<input type="submit" name="op" value="+"/>
<input type="submit" name="op" value="-"/>
<input type="submit" name="op" value="*"/>
<input type="submit" name="op" value="/"/>



</form>
<c:if test = "${not (empty (result))}">
<h2>The result of ${num1} ${op} ${num2} is <b>${result}.</b></h2>
</c:if>


</body>
</html>