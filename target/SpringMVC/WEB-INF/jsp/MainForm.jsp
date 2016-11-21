<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Form</title>
<style type="text/css">
.left-div{
    float: left;
    width: 500px;
    height: 20px;
    margin-right: 8px;
   /*  overflow-y: scroll; */
    top:40px;
   /*  background-color: linen; */
}
.right-div {
    float: left;
    margin-left: 108px;
    height:600px;
    overflow-y: auto;
    top:40px;
   /*  background-color: skyblue; */
}

.image-div{
	
	margin-left: 540px;
	width: 160px;
	height:100px;
	background-color: skyblue;
}

.error 
    {
        color: #ff0000;
        font-weight: bold;
    }​

</style>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@page import="org.mnr.model.*, java.util.*"%>

<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script type="text/javascript">

    function Ajax() {
         $.ajax({
            url : 'showAllEmployeesAjax',
            dataType: 'html',
            cache: false,
            success : function(data) {
            	var finalData = "<tbody><tr><th>Id</th><th>Name</th><th>Department</th><th>Email</th><th>Image</th></tr>" + data;
            	$("#data_table").html(finalData);
            
            }
        }); 
    }
    var intervalId = 0;
    intervalId = setInterval(Ajax, 3000);
</script>

</head>
<body>

<div class="left-div">
   <sf:form method="POST" modelAttribute="employee" action="saveEmployee" enctype="multipart/form-data">
<fieldset style="padding: 1em;font:80%/1 sans-serif;width:550px;">
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

<div class="right-div" id="html">

<fieldset style="padding: 1em;font:80%/1 sans-serif;width:650px;">
<legend> List of Employees</legend>
	<table  id="data_table" border="1">
	<!-- <tr>
	<th>Id</th>
	<th>Name</th>
	<th>Department</th>
	<th>Email</th>
	<th>Image</th>
	</tr> -->
	 
	<%-- <%
	 	String employees= (String)(request.getAttribute("employees"));
		boolean hasData	=	true;
		if(!"".equals(employees) && employees != null){%>
			<% 
			
			out.println(employees);%>
	<%	}	
		else{
			hasData	= false;
		}
	 %>
	 
	
		<%	if(hasData==false){%>	
		<div id="msg" style="top:70px; left:700px">
				<b>No Record Found</b>
		</div>
		<%} %> --%>
		
		</table>
</fieldset>
    
</div>
		
		
</body>
</html>