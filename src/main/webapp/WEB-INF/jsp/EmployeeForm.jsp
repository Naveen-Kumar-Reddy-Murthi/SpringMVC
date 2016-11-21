<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<style>
    .error 
    {
        color: #ff0000;
        font-weight: bold;
    }
    </style>

</head>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<body>
<div>

 
<sf:form method="POST" modelAttribute="employee" action="saveEmployee1" enctype="multipart/form-data">
<fieldset style="padding: 1em;font:80%/1 sans-serif;width:500px;">
<legend> Employee Registration</legend>
<table cellspacing="0">
<tr>
<th><label for="id">Id:</label></th>
<td><sf:input path="id" id="id"/></td>
<td><sf:errors path="id" cssClass="error"/></td>
</tr>
<tr>
<th><label for="name">Name:</label></th>
<td><sf:input path="name" id="name"/></td>
<td><sf:errors path="name" cssClass="error"/></td>
</tr>
<tr>
<th><label for="department">Department:</label></th>
<td><sf:input path="department" id="department"/></td>
<td><sf:errors path="department" cssClass="error"/></td>
</tr>
<tr>
<th><label for="email">Email:</label></th>
<td><sf:input path="email" id="email"/></td>
<td><sf:errors path="email" cssClass="error"/></td>
</tr>

<tr>
<th><label for="imageFile">Image</label></th>
<td><input name="imageFile" type="file"/>
<td><sf:errors path="imageFile" cssClass="error"/></td>
</tr>
<tr>
<th><input type="Submit" value="Submit"/></th>
<td></td>
</tr>
</table>
</fieldset>
</sf:form>
 
</div>


</body>
</html>