<%@page import="kb.servlet.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Login Success!</h1>
<%
	Customer cu = (Customer)request.getAttribute("cu");
%>
<h2>
	이름 : <%=cu.getName() %><br>
	나이 : <%=cu.getAge() %><br>
	주소 : <%=cu.getAddr() %><br>
	연락처 : <%=cu.getPhone() %><br>
</h2>
</body>
</html>