<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style><%@include file="/views/css/login.css"%></style>
<title>Registration</title>
</head>
<body>
 <div class="container">
  <h1 class="titletxt"> Registration Form</h1>
  <form action="<%=request.getContextPath()%>/RegistrationServlet" method="post">
   <table>
    <tr>
     <td><label>UserName</label></td>
     <td><input type="text" name="username" placeholder="Enter your Username" required></td>
    </tr>
    <tr>
     <td><label>Password</label></td>
     <td><input type="password" name="password" placeholder="Enter your Password" required></td>
    </tr>
    <tr>
     <td><label>First Name</label></td>
     <td><input type="text" name="firstName" placeholder="Enter your First Name" required></td>
    </tr>
    <tr>
     <td><label>Middle Name</label></td>
     <td><input type="text" name="middleName" placeholder="Enter your Middle Name" required></td>
    </tr>
    <tr>
     <td><label>Last Name</label></td>
     <td><input type="text" name="lastName" placeholder="Enter your Last Name" required></td>
    </tr>
    
 
   </table>
   <input type="submit" value="Submit" class="btn"/><br>
  </form>
  <a href ="/HospitalManagementSystem/LoginServlet"><h3>Log In</h3></a>
 </div>

</body>
</html>