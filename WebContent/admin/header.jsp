<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link href="/mcd/css/top.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<body>
<%
String id = (String) session.getAttribute("admin");
if(id!=null) {%>
	<form class="login" action="/mcd/logout.do" method="post">
	<div class="info" style="color:#dfb300">
사장님 안녕하세요! <br>
</div>
			<button type="submit">로그아웃</button>
		</form>
<%}%>
	<div class="logo">
	<a href="/mcd/admin/index.jsp"><img src="/mcd/images/logo_2.png" width="200"></a>
	</div><br>
		
<nav>
	<ul>
	<li><a href="/mcd/admin/menu.jsp">MENU</a></li>
		<li><a href="/mcd/admin/reviewList.jsp">REVIEW</a></li>	
		<li><a href="/mcd/admin/mypage.jsp">MY PAGE</a></li>
		<li><a href="/mcd/admin/order.jsp">ORDER</a></li>
	</ul>
</nav>
</body>
</html>