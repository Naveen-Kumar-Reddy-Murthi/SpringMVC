<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="p"%>
<body>
<p:form action="save" modelAttribute="student1">
Id		  	:<p:input  path="id"/><p:errors  path="id"/><br><br>
Name	  	:<p:input  path="name"/><p:errors  path="name"/><br><br>
<%-- Email     	:<p:input  path="email"/><p:errors  path="email"/><br><br> --%>
<%-- Subject Id	:<p:input  path="subject.id"/><p:errors  path="subject.id"/><br><br>
Subject Name:<p:input  path="subject.name"/><p:errors  path="subject.name"/><br><br> --%>
<input type="submit" value="Save"/>
</p:form>

</body>
</html>