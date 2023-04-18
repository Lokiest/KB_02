<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>ServletContext - application</h1>
<h3>
	application.getRealPath("/") = <%=application.getRealPath("/") %> <br>
	application.getContextPath() = <%=application.getContextPath() %> <br>
	
	<%
		application.setAttribute("msg", "do");
		application.setAttribute("age", 30);
	%>
	
</h3>

<hr>
	
	msg : <%=application.getAttribute("msg") %> <p>
	age : <%= application.getAttribute("age") %> <p>
	
	<a href = "sessionGet.jsp">Check</a>
</body>
</html>