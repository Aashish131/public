<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bug Details</title><meta charset="utf-8">
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
      <a class="nav-link" >Manager's Profile</a>
    </li>
     <li class="nav-right" >
      <a class="nav-link" href="ViewBugDetail">View Reported Bugs</a>
    </li>
   <li class="nav-item active">
      <a  href="logout" class="nav-link" >logout</a>
    </li>
   
  </ul>
</nav>

 <div >

</div>
<div align="right" >
<h1>Welcome  ${userObj.name}</h1>

</div>

<div id="d2" align="center">
<h1>Details Of Bugs</h1>
</div>

<form action="" method="get" style="padding-top: 100px">
<table class="table">
  <thead>
    <tr>
      <th scope="col">Bug Allocated Id</th>
      <th scope="col">Project name</th>
      <th scope="col">Project name</th>
      <th scope="col">Bug Status</th>
      <th scope="col">Bug Severity</th>
      <th scope="col">Bug Description</th>
      <th scope="col">Bug Assignment</th>
    </tr>
  </thead>
  <tbody>
   <c:forEach var="i" items="${bugAllocatedList}">
<tr>
<td>${i.bugAllocateId}</td>
<td>${i.projObj.projName }</td>
<td>${i.bugTypeObj.bType}</td>
<td>${i.bugStatusObj.statusName}</td>
<td>${i.severityObj.sType}</td>
<td>${i.desc}</td>
<td><a href="${path}/showBugDetail/${i.bugAllocateId} " id="btn" class="btn btn-success btn-block>Assign Bug">Assign Bug

</a></td>
</tr>
</c:forEach>
  </tbody>
</table>
</form>

</body>
</html>


