<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="web.dto.Member"%>
<%@page import="java.util.List"%>
<%@page import="web.dao.MemberDAOImpl"%>
<%@page import="web.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table{
		border : double red 5px; width: 800px; height: 400px;
	}
	th, td {
		padding : 3px;
		border : 1px gray solid;
		text-align: center;
	}
	
</style>
</head>
<body>
<h1>DBCP TEST</h1>
<%
	MemberDAO dao = new MemberDAOImpl();
	List<Member> list = dao.selectAll();
	request.setAttribute("list", list);
%>

<table>
	<tr>
		<th>No</th>
		<th>ID</th>
		<th>NAME</th>
		<th>AGE</th>
		<th>ADDR</th>
	</tr>
	
	<c:choose>
		<c:when test="${empty requestScope.list || list.size() == 0 }">
			<tr>
				<th colspan="5">no info</th>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${list}" var="mem" varStatus="state">
				<tr>
					<td>${state.count } / ${state.index }</td>
					<td>${mem.id }</td>
					<td>${mem.name }</td>
					<td>${mem.age }</td>
					<td>${mem.addr }</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>

<hr>

<h3>Get Map info</h3>
<%

	Map<String, String> map = new HashMap<>();
	map.put("kr", "Korea");
	map.put("eng", "England");
	map.put("jap", "Japan");
	map.put("fr", "France");
	map.put("ch", "China");
	
	request.setAttribute("map", map);
%>

<fieldset>
	<legend>Choose Country</legend>
		<c:forEach items="${map}" var="m">
			<input type="radio" name="m" value="${m.key }"> ${m.value}
		</c:forEach>
</fieldset>

<hr>

Price : 320420482048원 / 
<fmt:formatNumber value="320420482048" />원
<p>

application.getContextPath() : <%=application.getContextPath() %> <br>
\${pageContext.request.contextPath } = ${pageContext.request.contextPath}


</body>
</html>