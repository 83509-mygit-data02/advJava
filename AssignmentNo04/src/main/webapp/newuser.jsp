<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User</title>
</head>
<body>
<center>
   <!-- <h2>Registration Page</h2> -->
   <h3>${initParam.appTitle}</h3>

<form method="post" action="register.jsp" >
         <div style="text-align: center;">
         FirstName: <input type="text" name="firstName" /> <br/> <br/>
         LastName: <input type="text" name="lastName"/> <br/> <br/>
         Email: <input type="text" name="email"/> <br/> <br/>
         Password: <input type="password" name="password"/> <br/> <br/>
         DOB: <input type="Date" name="birth"/> <br/> <br/>
         <input type="submit" value="Register"/> <br/><br/>
        </div>
   </form>

   <a href="index.jsp">Already Sign in Click Here</a>
   </center>
</body>
</html>