<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>&lt; c : out > and &lt; c : outset ></h3>

<c:out value="hi" /> <br>
<c:out value="<h3>hi</h3>" /> <br>
<c:out value="<h3>hi</h3>"  escapeXml="true"/> <br>
<c:out value="<h3>hi</h3>" escapeXml="false"/> <br>

${"<h3>hi222</h3>"}

<hr>

<c:set var="id" value="park"/>
<c:set var="age" value="30" scope="session"/>
<c:set var="addr" value="ewr2" scope="application" />

<h3> print </h3>

id : ${id} <br>
age : ${age} / ${sessionScope.age}<br>
addr : ${addr} / ${applicationScope.addr }<br>

<a href="ex02_result.jsp">jump</a>

</body>
</html>