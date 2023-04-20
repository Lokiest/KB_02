<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>jump to ~.jsp</h3>
<form method="post" action="encodingResult.jsp">
	name : <input type="text" name="name">
	<input type="submit" value="전송">
</form>

<hr>

<h3>jump to ~.servlet</h3>
<form method="post" action="ETS">
	name : <input type="text" name="name">
	<input type="submit" value="전송">
</form>


</body>
</html>