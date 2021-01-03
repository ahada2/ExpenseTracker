<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="rootPath" value="${ pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<h1>Expense Tracker- Home</h1>
	
	<a href="${ rootPath }/api/v1/addexpense">Add New Expense</a>
	
	<c:forEach var="each_exp" items="${ listExpenses }">
		<div>
			<h3>${ each_exp.expense }</h3>
			<p>${ each_exp.amount }</p>
		</div>
	</c:forEach>
</body>
</html>