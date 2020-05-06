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
      <li class="nav-item active">
      <a href="logout" class="nav-link" >Logout</a>
    </li>
   
  </ul>
</nav>

 <div >
<div id="d1" align="right">
<h1 ALIGN="center">Welcome ${userObj.name}</h1>
${msg}
</div>
<div id="d2" align="center">
<form action="${path}/BugSuccessfullyAllocated" method="get">
<table>
 <tr>
 <td> Tester Name: </td>
 <td> <input type="text" value="${userObj.name}" readonly="readonly"></td>
 </tr>
 <tr>
 <td> Project Name: </td>
 <td> 
 <input type="text" value="${projectObj.projName}" readonly="readonly">
 
 </td>
 </tr>
 <tr>
 	<td> Buy Type: </td>
  <td><select name="bug" required>
    <option value="0">select bug type</option>
   <c:forEach items="${bugListObj}" var="bObj">
    	<option value="${bObj.bId}">${bObj.bType}</option>
           </c:forEach>    
     </select> 
    </td>
 </tr>
 <tr>
 	<td> Severity : </td>
  <td><select name="severity" required>
    <option value="0">select severity type</option>
   <c:forEach items="${severityList}" var="sObj">
    	<option value="${sObj.sId}">${sObj.sType}</option>
           </c:forEach>    
     </select> 
    </td>
 </tr>
  <tr>
 <td> Description: </td>
 <td> <textarea cols="40" rows="10" name="description" required="required"></textarea></td>
 </tr>
 <tr>
	<td></td>
		<td>
			<input type="submit" value="Report">
		</td>
	</tr>
</table>
</form>
</div>
</body>
</html>