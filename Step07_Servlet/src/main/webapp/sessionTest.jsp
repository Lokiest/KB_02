<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>HttpSession</h1>
<h3>
 session.isNew() = <%=session.isNew() %> <br>
 session.getId() = <%=session.getId() %> <br>
 session.getMaxInacticeInterval() = <%=session.getMaxInactiveInterval() %> <br>
 session.getLastAccessedTime() = <%=session.getLastAccessedTime() %> <br>
 session.getCreationTime() = <%=session.getCreationTime() %> <br>
 
</h3>

<%
	//세션에 정보 저장
	session.setAttribute("id", "park");
	session.setAttribute("msg", "gogo");
%>

<h3>조회하기</h3>
id : <%=session.getAttribute("id") %> <br>
msg : <%=session.getAttribute("msg") %> <br>

<a href="sessionGet.jsp">Check</a>

</body>
</html>