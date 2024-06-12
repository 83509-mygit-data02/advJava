<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <h3>${initParam.appTitle}</h3>
   
   <jsp:useBean id="dc" class="com.sunbeam.beans.DeleteCandBean" scope="request"/>
   <jsp:setProperty property="id" name="dc" param="id"/>
   ${dc.deleteCandidate() }
   <jsp:forward page="result.jsp"></jsp:forward>
   
</body>
</html>