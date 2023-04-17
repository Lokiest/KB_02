<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- jsp 스크립트 요소
<%-- 
	<% %> : 코딩
	<%@ %> : page 지시어 or taglib 선언
	<%! %> : 전역변수 or 메소드 선언할 때
	<%= %> : 출력 - 마크업 중심으로 코딩하다가 변수 출력해야할 때 사용하면 편함
	
 --%>
 -->
<body>
<% 
	String name = request.getParameter("name") ;
	String blood = request.getParameter("blood");
	
	out.print("<h1>이름 : " + name + "</h1>");
%> 

		혈액형 : <%=blood %>
<hr>

</body>
</html>