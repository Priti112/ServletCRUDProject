<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Page</title>
</head>
<body>
<h1>Student List Page</h1>
<h2>
   <a href="new">Add New Students</a>
   &nbsp;&nbsp;&nbsp;
   <a href="list">List All Students</a>
</h2>
<table border="1">
<tr>
  <th>ID</th>
  <th>Name</th>
  <th>Age</th>
  <th>City</th>
  <th>Email</th>
  <th colspan="2">Action</th>
  
<c:forEach var="s" items="${studentList}">
<tr>
   <td>${s.id}</td>
   <td>${s.name}</td>
   <td>${s.age}</td>
   <td>${s.city}</td>
   <td>${s.email}</td>
   <td>
   <a href="edit?id=${s.id}">Edit</a>
   &nbsp;&nbsp;&nbsp;
   <a onclick="return confirm('Are you sure you want to delete')" href="delete?id=${s.id}">Delete</a>
   </td>     
</tr>
</c:forEach>      
</table>
</body>
</html>