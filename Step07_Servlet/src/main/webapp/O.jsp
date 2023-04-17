<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	String name = request.getParameter("name") ;
	String blood = request.getParameter("blood");
	
	out.print("<h1>이름 : " + name + "</h1>");
%> 

		혈액형 : <%=blood %>
</body>
</html>