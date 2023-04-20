<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSP START</h1>
<%
	//java
	String name = "park";
	int age = 29;
	
	//출력
	System.out.println("name = " + name);
	
	//브라우저에 출력
	out.println("<h3>name = " + name +"</h3>");
	
%>

<hr>

<h4>
	age : <%=age %>살 <br>
	method call : <%=test("JANG") %>
</h4>

<%!
	/* 전역변수 선언 */
	String addr;
	String info="ewr2";
	
	public String test(String name) {
		System.out.println("testestestestesteesteteset");
		return name + " + TETSTESTESTESTSTESTST";
	}
%>
</body>
</html>