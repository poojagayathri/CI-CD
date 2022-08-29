<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.bg-img{
background-image:url('bg_shoes.png');
min-height: 100%;
background-repeat: no-repeat;
background-size:cover;
}
button {
  background-color: #04AA6D;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

button:hover {
  opacity:1;
}
.container{
max-width:50%;
margin: auto;
 padding: 10%;
left: 30%;
top:30%;
}
input ,select{
     width:100%;
     padding: 15px;
     margin: 5px 0 22px 0;
     display: inline-block;
}
</style>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<br/>

<div class="bg-img">
<form method="POST" action="newProduct" enctype="multipart/form-data" modelAttribute="product">
<div>${msg}</div>
<div class="container">

<label><b>Product Name</b></label><br>
<input id="productName" name="productName" placeholder="Enter product Name" required/>

<label><b>price:</b></label><br/>
<input type="number" id="price" name="price" placeholder="Enter price" required/>

<label><b>Quantity:</b></label><br/>
<input type="number" id="quantity" name="quantity" placeholder="Enter price" required/>

<label><b>Category Name:</b></label><br/>
<select id="categoryName" name="categoryName" required="required">
<c:forEach var="cat" items="${catList}">
<option>${cat}</option>
</c:forEach>
</select>

<input name="file" type="file" accept="image/png" />

<button type="submit">Submit</button>

</div>

</form>
</div>
</body>
</html>