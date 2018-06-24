<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link href="/mcd/css/home.css" rel="stylesheet" type="text/css">	
<title>맥도날드 주문 서비스</title>
</head>
<body>
<%
String error = (String) request.getAttribute("error");
if(error != null) {
	out.println("<script language='javascript'>");
	out.println("alert('" + error + "');");
	out.println("</script>");
}
%>
<section>
	<div class="logo">
		<a href="home.jsp"><img src="images/logo_3.png" width="300"></a>
	</div>
		<form class="login" action="login.do" accept-charset="utf-8"method="post">
				<input type="text" name="id" placeholder="id" title="id"><br>
				<input type="password" name="passwd" placeholder="pw" id="pw"><br>
				<button type="submit">로그인</button>
		</form>
		<div class="login">
				<a href = "join.jsp"><button type="submit">회원가입</button></a>
		</div>
</section>


</body>
</html>