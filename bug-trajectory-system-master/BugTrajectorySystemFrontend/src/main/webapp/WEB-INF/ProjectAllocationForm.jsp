<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" >
<title>Project Allocation Page</title>

</head>
<body marginheight="0px">

<nav class="navbar navbar-expand-sm bg-info navbar-dark">
  <ul class="navbar-nav mr-auto">
   
 
   
     <li class="nav-item active" >
      <a class="nav-link" >Bug Trajectory System</a>
    </li>
     <li class="nav-item active">
      <a class="nav-link" >Manager's Profile</a>
    </li>
     <li class="nav-right" >
      <a class="nav-link" href="ViewBugDetail">View Reported Bugs</a>
    </li>
    <li class="nav-item active">
      <a href="logout" class="nav-link" >Logout</a>
    </li>
  </ul>
</nav>

 <div >

</div>
<div align="right" >
<h1>Welcome  ${userObj.name}</h1>

</div>

<div align="center" id="d2">
     ${msg}
<form action="${path}/projectAllocated" method="post">

<table>
	<tr>
	<td>Select Project :</td>
	<td>
    	<select name="project" required >
    	<option value="0" >Project List</option>
    	<c:forEach items="${projectList}" var="pObj">
    	<option value="${pObj.projId}">${pObj.projName}</option>
           </c:forEach>
       </select>
	</td>
	</tr>
	
	<tr>
	<td>Select Developer :</td>
	<td>
    	<select name="developer" multiple="multiple" required>
    	<option value="0">Developer list</option>
    	<c:forEach items="${developerList}" var="dObj">
    	<option value="${dObj.id}">${dObj.name}</option>
           </c:forEach>
       </select>
	</td>
	</tr>
	
	<tr>
	<td>Select Tester :</td>
	<td>
    	<select name="tester" multiple="multiple" required>
    	<option value="0">Tester List</option>
    	<c:forEach items="${testerList}" var="tObj">
    	<option value="${tObj.id}">${tObj.name}</option>
           </c:forEach>
       </select>
	</td>
	</tr>
	
	<tr>
		<td></td>
		<td>
			<input type="submit" value="Allocate">
		</td>
	</tr>
	<tr>
	
	</tr>
</table>
</form>
</div>
</body>
</html>