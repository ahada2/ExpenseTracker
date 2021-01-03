<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="rootPath" value="${ pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Expense</title>
</head>
<body>
	<h1>Add New Expense</h1>
	
	<form:form action="${ rootPath }/api/v1/save_new_expense" 
			   method="post" 
			   modelAttribute="new_expense_obj" >
		<form:input path="expense" />
		<form:input path="amount" />
		<form:input path="description" />
		
		<button type="submit">Add New Expense</button>
	</form:form>
</body>
</html>