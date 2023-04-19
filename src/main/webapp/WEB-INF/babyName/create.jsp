<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
		<a href="/home">Back to Home Page</a>
		<h1>create a babyName</h1>
	    <form:form action="/babyNames/process/new" modelAttribute="babyName" method="post">
	        <form:input type="hidden" path="user" value="${user_id}"/>
	        <div class="form-group">
	            <form:label path="name" > New Name</form:label>
	            <form:input type="text" path="name" class="form-control"/>
	            <form:errors path="name" class="text-danger"/>
	        </div>
	        <%-- <div class="form-group">
	            <form:label path="gender"> Typical Gender</form:label>
	            <form:input type="text" path="gender"  class="form-control"/>
	            <form:errors path="gender" class="text-danger"/>
	        </div> --%>
			  <div class="form-group">      
				  <label>Gender:</label>
				 <form:select path="gender" class="form-control">
				 		<form:option value="" path="gender">
			    			<c:out value=""/>
			    		</form:option>
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
	            <form:input type="text" path="origin"  class="form-control"/>
	            <form:errors path="origin" class="text-danger"/>
	        </div>
	        <div class="form-group">
	            <form:label path="meaning"  > Meaning</form:label>
	            <form:input type="text" path="meaning" class="form-control"/>
	            <form:errors path="meaning" class="text-danger"/>
	        </div>
	          <a href="/home"><input type="button" value="Cancel" class="btn btn-primary"/></a>
	        <input type="submit" value="Submit" class="btn btn-primary"/>
	        </form:form>
        </div>
</body>
</html>