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
</head>
<body>
<script src="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <!--Data Table-->
    <script type="text/javascript"  src=" https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript"  src=" https://cdn.datatables.net/buttons/1.2.4/js/dataTables.buttons.min.js"></script>
   
<!--Export table button CSS-->
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.2.4/css/buttons.dataTables.min.css">
<jsp:include page="Header.jsp"></jsp:include>
<br/>
<div style="width:70%; margin:5% 15% 5% 15%">
<table id="example" class="display" >
        <thead>
            <tr>
                <th>Id</th>
                <th>First Name</th>  
                <th>Last Name</th>     
                <th>Email</th>  
            </tr>
        </thead>
          
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                 <td>${user.lastName}</td>
                  <td>${user.email}</td>
            </tr>
          </c:forEach>
        </tbody>
    </table>
</div>
</body>
<script type="text/javascript">
$(document).ready(function() {
    $('#example').DataTable();
} );
</script>
</html>