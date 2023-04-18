<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>조회하기</h3>
id : <%=session.getAttribute("id") %> <br>
msg : <%=session.getAttribute("msg") %> <br>

<hr>

	app msg : <%=application.getAttribute("msg") %> <br>
	app age : <%= application.getAttribute("age") %> <br>

</body>
</html>