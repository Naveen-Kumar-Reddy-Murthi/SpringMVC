<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee List View</title>
</head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@page import="org.mnr.model.*, java.util.*"%>
<body>

		<div>
<b>List of Persons</b>
 
<table  border="1">
<tr>
<th>Id</th>
<th>Name</th>
<th>Department</th>
<th>Email</th>
</tr>
 
<%
/* List<Employee> employeeList = (List)request.getAttribute("employees");
for(Employee employee: employeeList){
out.println("<tr>");
out.println("<td>" + employee.getId() + "</td>");
out.println("<td>" + employee.getName() + "</td>");
out.println("<td>" + employee.getDepartment() + "</td>");
out.println("<td>" + employee.getEmail() + "</td>");
out.println("</tr>");
} */
 
String employees= (String)(request.getAttribute("employees"));
if(!"".equals(employees) || employees != null)
	out.println(employees);
else
	out.println("No Record Found");
%>
 
</table>
 
</div>

</body>
</html>