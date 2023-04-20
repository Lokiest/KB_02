<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <jsp:include page="header.jsp" /> --%>

<%
	String addr = "ewr";
%>
<%@ include file="header.jsp" %>

<h1>main.jsp</h1>

<h3>
	main addr : <%=addr %>
</h3>

<hr color="red">

<jsp:include page="footer.jsp" >
	<jsp:param value="<%=addr %>" name="addr"/>
</jsp:include>
<%-- <%@ include file="footer.jsp" %> --%>
</body>
</html>