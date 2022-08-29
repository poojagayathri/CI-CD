<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="shortcut icon" href="bg_shoes.PNG">
<style>
.topnav{
background-color: #333;
overflow:hidden;
}
.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 20px 22px;
  text-decoration: none;
  font-size: 33px;
}

/* Change the color of links on hover */
.topnav a:hover {
  background-color: #ddd;
  color: black;
}

/* Add a color to the active/current link */
.topnav a.active {
  background-color: #04AA6D;
  color: white;
}
</style>
</head>
<body>
<div class="topnav">
<a>Sporty Shoes</a>
<c:if test="${sessionScope.name != null}">
<a href="userList">Home</a>
<a href="productList">Products</a>
<a href="categoryList">Categories</a>
<a href="logout" style="font-size:20px">Log Out</a>
</c:if>

</div>
</body>
</html>