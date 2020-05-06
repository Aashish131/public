<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Allocation Page</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</head>
<body> 
<div>

<nav class="navbar navbar-expand-sm bg-info navbar-dark">
  <ul class="navbar-nav mr-auto">
   
 
   
     <li class="nav-item active" >
      <a class="nav-link" >Bug Trajectory System</a>
    </li>
     <li class="nav-item active">
      <a class="nav-link" >Tester's Profile</a>
    </li>
     <li class="nav-item active" >
      <a href="${path}/logout" class="nav-link" >Logout</a>
    </li>
   
  </ul>
</nav>
</div>
 <div >
s
<div id="d1" align="center">
<h1 align="center">Project Allocated </h1>
</div>
<div id="d2" align="center">
<table border="1" align="center" width="100%">
	<tr>
		<td align="center">Project Allocated</td>
		<td align="center"></td>
	</tr>
	
	<c:forEach items="${projectList}" var="pObj">
		<tr>
			<td align="center">
				${ pObj.projName}
			</td>
			<td align="center"> 
				<a href="BugAllocated/${pObj.projId}">Report Bug</a>
			</td>
		</tr>
	</c:forEach>
</table>
</div>
</body>
</html>