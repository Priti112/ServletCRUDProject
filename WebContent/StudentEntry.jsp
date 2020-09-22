<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Entry Page</title>
</head>
<body>
<h1>Student Entry Page</h1>
<h2>
   <a href="new">Add New Students</a>
   &nbsp;&nbsp;&nbsp;
   <a href="list">List All Students</a>
</h2>
<form action="${action}" method="post">
<input type="hidden" name="id" value="${student.id}">
<table border="1">
<tr>
   <th>Name:</th>
   <td>
      <input type="text" name="name" value="${student.name}">
   </td>
</tr>   
<tr>
   <th>Age:</th>
   <td>
      <input type="text" name="age" value="${student.age}">
   </td>
</tr>
<tr>
   <th>City:</th>
   <td>
      <input type="text" name="city" value="${student.city}">
   </td>
</tr>
<tr>
   <th>Email:</th>
   
   <td>
      <input type="text" name="email" value="${student.email}">
   </td>
</tr>      
<tr>
   <td colspan="1" align="center">
   <input type="submit" value="submit"/>
   </td>
</tr>
</table>
</form>
</body>
</html>