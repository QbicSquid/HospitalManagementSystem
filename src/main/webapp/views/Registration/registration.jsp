<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <div align="center">
  <h1> Registration Form</h1>
  <form action="<%=request.getContextPath()%>/RegistrationServlet" method="post">
   <table style="width: 80%">
    <tr>
     <td>UserName</td>
     <td><input type="text" name="username" placeholder="Enter your Username" required></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" placeholder="Enter your Password" required></td>
    </tr>
    <tr>
     <td>First Name</td>
     <td><input type="text" name="firstName" placeholder="Enter your First Name" required></td>
    </tr>
    <tr>
     <td>Middle Name</td>
     <td><input type="text" name="middleName" placeholder="Enter your Middle Name" required></td>
    </tr>
    <tr>
     <td>Last Name</td>
     <td><input type="text" name="lastName" placeholder="Enter your Last Name" required></td>
    </tr>
    
 
   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>

</body>
</html>