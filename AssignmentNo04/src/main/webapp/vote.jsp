<%@page import="com.sunbeam.beans.VoteBean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <h3>${initParam.appTitle}</h3> <br/><br/>
    Hello, ${lb.user.firstName} ${lb.user.lastName} <hr/>
    <c:choose>
       <c:when test="${lb.user.status == 0}">
            <jsp:useBean id="vb" class="com.sunbeam.beans.VoteBean"/>
            <jsp:setProperty property="candidId" name="vb" param="candidate"/>
            <jsp:setProperty property="userId" name="vb" value="${lb.user.id }"/>
            ${vb.candVote()} <br/>
            Voted Successfully.<br/><br/>
       </c:when>
       <c:otherwise>
            Already voted.<br/><br/>            
       </c:otherwise>
    </c:choose>
    <br/>
    <a href="signout.jsp">Sign Out</a>
</body>
</html>