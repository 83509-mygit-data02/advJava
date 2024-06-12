<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Candidate</title>
</head>
<body>
    <h3>${initParam.appTitle}</h3>
    <jsp:useBean id="uc" class="com.sunbeam.beans.UpdateCandidateBean" scope="page"/>
    <jsp:setProperty property="*" name="uc"/>
    ${uc.updateCandidate()}
    <c:choose>
          <c:when test="${uc.count == 1}">
              <c:redirect url="result.jsp"/>         
          </c:when>
          <c:otherwise>
              candidate update failed. <br/><br/>
              <a href="result.jsp">Show Result</a>
          </c:otherwise>
    </c:choose>
</body>
</html>