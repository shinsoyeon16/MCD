<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="/mcd/css/join.css" rel="stylesheet" type="text/css">
<title>user 회원가입</title>
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
<header>
<div class="logo">
		<a href="home.jsp"><img src="images/logo_2.png" width="200"></a>
	</div>
</header>
<section>
		<h2>회원가입</h2>
	    <form class = "join" action="join.do" accept-charset="utf-8" method="post">

					<input type="text" name="id" placeholder="아이디"><br>
	
					<input type="password" name="passwd" placeholder="비밀번호" /><br>
	
					<input type="text" name="name" placeholder="이름"/><br>
	
					<input type="text" name="phoneNumber" placeholder="전화번호"/><br>
	
				<button type="submit">가입</button>
	
		</form>

</section>

<footer>
<jsp:include page="footer.jsp"></jsp:include>
</footer>

</body>
</html>