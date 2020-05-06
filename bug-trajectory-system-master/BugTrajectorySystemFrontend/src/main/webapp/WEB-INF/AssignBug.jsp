<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assign Bug</title>
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
      <a class="nav-link" >Manager's Profile</a>
    </li>
     <li class="nav-right" >
      <a class="nav-link" href="ViewBugDetail">View Reported Bugs</a>
    </li>
    <li class="nav-item active">
      <a href="logout" class="nav-link"  >Logout</a>
    </li>
   
  </ul>
</nav>
 <div >

</div>
<h1 align="center">Assign Bug </h1>
<form action="assigned" method="get">
<table align="center">
<tr>
<td>Project Name:</td>
<td><input type="text" value="${bugAlloactionDetails.projObj.projName }" readonly="readonly" > </td>
</tr>
<tr>
<td> Developer List:</td>
<td><select name="developer">
    <option value="0">Select Developer</option>
   <c:forEach items="${uList}" var="dObj">
       <option value="${dObj.id}">${dObj.name}</option>
           </c:forEach>    
     </select> 
</tr>
<tr>
      <td> Buy Status: </td>
  <td><select name="status">
    <option value="0">Select Bug Status</option>
          <c:forEach items="${statusList}" var="sObj">
           <option value="${sObj.statusId}">${sObj.statusName}</option>
           </c:forEach>    
     </select> 
    </td>
</tr>
<tr>
   <td>Bug Type:</td>
       <td><input type="text" value="${bugAlloactionDetails.bugTypeObj.bType}" readonly="readonly" > </td><td>
</tr>
<tr>
   <td>Assigned Date</td>
   <td><input type="date" name="AssignedDate"><td>
</tr>
<tr>
<td>Planned End Date</td>
<td><input type="Date" name="EndDate"></td>
</tr>
<tr>
<td>Description</td>
<td><textarea  cols="30" rows="10" readonly="readonly">${bugAlloactionDetails.desc}</textarea><td>
</tr>
<tr>
<td> </td>
<td><input type="submit" value="Assign"></td>
</tr>
</table>
</form>
</body>
</html>
		