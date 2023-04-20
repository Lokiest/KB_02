<%@page import="oracle.net.aso.s"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>EL</h3>
\${5} = ${5} <br>
\${5 * 2} = ${5 * 2} <br>
\${5 gt 2} = ${5 gt 2} <br>
<%-- \${5 == 5 || 3 < 5} = ${5 == 5 || 3 < 5} <br> --%>

<%-- \${5>3?"big":"small"} = ${5>3?"big":"small"}<br> --%>

id : <%=request.getParameter("id") %> / ${param.id } <br>

${param.age > 19? "adult" : "kids" }<br>

${param.id == null ? "Guest" : param.id += "님"}<br>
${param.id == null ? "Guest" : param.id.concat("님")}<br>
${empty param.id ? "Guest" : param.id += "님"}<br>
${not empty param.id ? "Guest" : param.id += "님"}<br>

<hr>

<h3>Scope Sector (pageContext &lt; request &lt; session &lt; application) info get
<%
	request.setAttribute("id", "park1234");

	session.setAttribute("addr", "wer2");
	session.setAttribute("msg", "Session ewrwerwerwer2");
	
	application.setAttribute("msgapp", "ekiwjfapplication");
	application.setAttribute("hobbys", new String[]{"ewr", "ewr","123123", "24242"});
	
%>

id : <%=request.getAttribute("id") %> / ${requestScope.id} / ${id} <br>

<hr>

addr : <%=session.getAttribute("addr") %> / ${sessionScope.addr } / ${addr}  <br>
msg : <%=session.getAttribute("msg") %> / ${sessionScope.msg } / ${msg}  <br>

<hr>

msgapp : <%=application.getAttribute("msgapp") %> / ${applicationScope.msgapp} / ${msgapp} <br>
hobbys : <%=application.getAttribute("hobbys")%> / ${applicationScope.hobbys } / ${hobbys} <br>

</h3>

<hr>

<%
	String name= "park";
%>


	
</body>
</html>