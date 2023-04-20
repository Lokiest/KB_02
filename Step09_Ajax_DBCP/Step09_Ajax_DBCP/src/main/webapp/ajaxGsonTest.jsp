<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>

<script type="text/javascript">
  $(function(){
	 
	  $("#ajaxBtn").click(function(){
		  $.ajax({
			  url : "${pageContext.request.contextPath}/ajaxTest?key=text" ,  //서버요청주소
			  type : "post", // 요청방식(get, post, put, delete, patch)
			  dataType :"text" , //서버가 응답(보내온) 한 데이터타입(text | html | xml | json)
			  data :"name=PARK", // 서버에게 보낼 parameter정보 
			  success: function(result){
				  $("#display").html("<h3>"+result+"</h3>");
			  } ,
			  error : function(err){
				  alert(err+"에러 발생!");
			  }
		  });
	  })
	  ////////////////////////////////
	  $("#jsonBtn").click(function(){
		  $.ajax({
			  url : "${pageContext.request.contextPath}/ajaxTest?key=json" ,  //서버요청주소
			  type : "post", // 요청방식(get, post, put, delete, patch)
			  dataType :"json" , //서버가 응답(보내온) 한 데이터타입(text | html | xml | json)
			 // data :"name=장희정", // 서버에게 보낼 parameter정보 
			  success: function(result){
				  alert(result) //결과를 input type="checkbok" 로 만들어서 display 출력
				  let str="";
				  $.each(result, function(index, item){
					  str+="<input type='checkbox' name='menu' value='"+index+"'>" + item 
				  });
				  
				  $("#display").html(str);
				  
			  } ,
			  error : function(err){
				  alert(err+"에러 발생!");
			  }
		  });
	  });
	  ///////////////////////////////////////////////////////
	  
	  $("#dtoBtn").click(function(){
		  $.ajax({
			  url : "${pageContext.request.contextPath}/ajaxTest?key=dto" ,  //서버요청주소
			  type : "post", // 요청방식(get, post, put, delete, patch)
			  dataType :"json" , //서버가 응답(보내온) 한 데이터타입(text | html | xml | json)
			 // data :"name=장희정", // 서버에게 보낼 parameter정보 
			  success: function(result){
				  alert(result.id +" , " + result.name +" , " + result.age +" , " + result.addr) //결과를 input type="checkbok" 로 만들어서 display 출력
			  } ,
			  error : function(err){
				  alert(err+"에러 발생!");
			  }
		  });
	  })
	  /////////////////////////////////////////////
	  $("#listBtn").click(function(){
		  $.ajax({
			  url : "${pageContext.request.contextPath}/ajaxTest?key=list" ,  //서버요청주소
			  type : "post", // 요청방식(get, post, put, delete, patch)
			  dataType :"json" , //서버가 응답(보내온) 한 데이터타입(text | html | xml | json)
			 // data :"name=장희정", // 서버에게 보낼 parameter정보 
			  success: function(result){
				  //alert(result) //결과를 input type="checkbok" 로 만들어서 display 출력
				  let str="";
				  $.each(result, function(index, mem){
					  str += mem.id +" | " + mem.name +" | " + mem.age +" | " + mem.addr +"<br>";
				  });
				  
				  $("#display").html(str);
			  } ,
			  error : function(err){
				  alert(err+"에러 발생!");
			  }
		  });
	  });
	  ///////////////////////////////////////////////////////////
	  $("#mapBtn").click(function(){
		  $.ajax({
			  url : "${pageContext.request.contextPath}/ajaxTest?key=map" ,  //서버요청주소
			  type : "post", // 요청방식(get, post, put, delete, patch)
			  dataType :"json" , //서버가 응답(보내온) 한 데이터타입(text | html | xml | json)
			 // data :"name=장희정", // 서버에게 보낼 parameter정보 
			  success: function(result){
				  //alert(result) //결과를 input type="checkbok" 로 만들어서 display 출력
				 alert(result.message)
				 alert(result.pageNo)
				 
				 alert(result.dto +" | " + result.dto.id +" | " + result.dto.name)
				 alert(result.memberList)
				 
				 $.each( result.memberList , function(index, mem){
					 alert( mem.id +" | " + mem.name+" | " + mem.age+" | " + mem.addr)
				 });
				 
				 
			  } ,
			  error : function(err){
				  alert(err+"에러 발생!");
			  }
		  });
	  });
	  
	  $("#textJsonBtn").click(function(){
		  $.ajax({
			  url : "${pageContext.request.contextPath}/ajaxTest?key=textJson" ,  //서버요청주소
			  type : "post", // 요청방식(get, post, put, delete, patch)
			  dataType :"json" , //서버가 응답(보내온) 한 데이터타입(text | html | xml | json)
			 // data :"name=장희정", // 서버에게 보낼 parameter정보
			 data:{name:"park", age:555, addr:"ewr2"},
			  success: function(result){
				alert(result.info);
			  } ,
			  error : function(err){
				  alert(err+"에러 발생!");
			  }
		  });
	  });
	  
  }) //readyEnd
</script>
</head>
<body>


<input type="button" value="text결과" id="ajaxBtn">

<input type="button" value="json결과" id="jsonBtn">

<input type="button" value="DTO결과" id="dtoBtn">
<input type="button" value="List결과" id="listBtn">
<input type="button" value="Map결과" id="mapBtn">
<input type="button" value="textJson결과" id="textJsonBtn">

<hr>
<div id="display"></div>



</body>
</html>













