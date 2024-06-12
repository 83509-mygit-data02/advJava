<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page Connectivity</title>
</head>
<body>
   <jsp:useBean id="rb" class="com.sunbeam.beans.RegistrationBean" scope="page"/>
   <jsp:setProperty property="*" name="rb"/>
   <jsp:setProperty property="status" name="rb" value="0"/>
   <jsp:setProperty property="role" name="rb" value="voter"/>
   <%-- <% rb.registerUser(); %> --%>
   ${rb.registerUser()}
   <%-- <% if (rb.getCount() == 1) { %>
          Registration successful.
          <a href="index.jsp">Sign In</a>
    <% } else { %>
          Registration failed.
          <a href="newuser.jsp">Sign Up</a>
     <% } %> --%>
     
     <c:choose>
        <c:when test="${rb.count == 1}">   
            Registration Successful.
            <a href="index.jsp">Sign In</a>
        </c:when>
        <c:otherwise>
             Registration Failed.
             <a href="newuser.jsp">Sign Up</a>
        </c:otherwise>
     </c:choose>
</body>
</html>