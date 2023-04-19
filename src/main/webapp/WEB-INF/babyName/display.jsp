<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/main.css"/>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<a href="/home">Back to Home Page</a>
	<h1> <c:out value="${babyName.name}"/></h1>
	<h3> Added by: <c:out value="${babyName.user.name}"/></h3>
	<h3> Gender: <c:out value="${babyName.gender}"/></h3>
	<h3> Origin: <c:out value="${babyName.origin}"/></h3>
	<h3> Meaning: <c:out value="${babyName.meaning}"/></h3>
	<c:if test="${user_id == babyName.user.id}"> 
	<a class="btn btn-outline-warning" href="/babyNames/edit/${babyName.id}">Edit</a>
										
	</c:if>
	<%-- <form action="/babyNames/delete/${babyName.id}" method="post">
		<input type="hidden" name="_method" value="delete"/>
		<input type="submit" value="Delete" class="btn btn-outline-danger btn-dark"/>
	</form> --%>
</body>
</html>