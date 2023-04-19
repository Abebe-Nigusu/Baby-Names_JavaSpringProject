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
		<h1>Hello, <c:out value="${loggedInUser.name}"/> Here are some name suggestions.</h1>
		<a href="/users/logout"  class="btn btn-primary">logout</a>
		<h1>Baby Names</h1>
		
		<table class="table table-dark">
		  <thead>
		    <tr>
		      <th scope="col">id</th>
		      <th scope="col">Name</th>
		      <th scope="col">Gender</th>
		      <th scope="col">Origin</th>
		     <!--  <th scope="col">Posted by</th> -->
		    
		    </tr>
		  </thead>
		  <tbody>
		    <c:forEach items="${allBabyNames}" var="babyName">
		    <tr>
					<td>${babyName.id}</td>
					<td><a href="/babyNames/display/${babyName.id}">${babyName.name}</a></td>
					<td>${babyName.gender}</td>
					<td>${babyName.origin}</td>
					<%-- <td>${babyName.user.name}</td>	 --%>
		    </tr>
			</c:forEach>
			
		  </tbody>
		</table>
	<a href="/babyNames/new"  class="btn btn-primary">New Name</a>
</body>
</html> 