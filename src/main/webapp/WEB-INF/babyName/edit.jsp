<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>
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
	<div class="container">
		
		<h1>Change ${babyName.name}</h1>
	    <form:form action="/babyNames/process/edit/${babyName.id}" modelAttribute="babyName" method="post">
	    	<input type="hidden" name="_method" value="put"/>
	        <form:hidden path="user"/>
	        <div class="form-group">
	            <form:label path="name"> Name</form:label>
	            <form:input type="text" hidden="true" path="name" class="form-control"/>
	            <form:input type="text" disabled="true" path="name" class="form-control"/>
	            <form:errors path="name" class="text-danger"/>
	        </div>
	        <%-- <div class="form-group">
	            <form:label path="gender"> Gender</form:label>
	            <form:input type="text" path="gender" class="form-control"/>
	            <form:errors path="gender" class="text-danger"/>
	        </div> --%>
	        
	        <div class="form-group">      
				  <label>Gender:</label>
				 <form:select path="gender" class="form-control">
			    		<form:option value="male" path="gender">
			    			<c:out value="male"/>
			    		</form:option>
			    		<form:option value="female" path="gender">
			    			<c:out value="female"/>
			    		</form:option>
			    		<form:option value="nuetral" path="gender">
			    			<c:out value="nuetral"/>
			    		</form:option>
			    </form:select>
			     <form:errors path="gender" class="text-danger"/>
		    </div>
	         <div class="form-group">
	            <form:label path="origin"> Origin</form:label>
	            <form:input type="text" path="origin" class="form-control"/>
	            <form:errors path="origin" class="text-danger"/>
	        </div>
	        <div class="form-group">
	            <form:label path="meaning"> Meaning</form:label>
	            <form:input type="text" path="meaning" class="form-control"/>
	            <form:errors path="meaning" class="text-danger"/>
	        </div>
	       
	        <a href="/home"><input type="button" value="Cancel" class="btn btn-primary"/></a>
	        <input type="submit" value="Submit" class="btn btn-primary"/>
	        </form:form>
	        <form action="/babyNames/delete/${babyName.id}" method="post">
				<input type="hidden" name="_method" value="delete"/>
				<input type="submit" value="Delete" class="btn btn-outline-danger"/>
			</form>
		</div>
</body>
</html>