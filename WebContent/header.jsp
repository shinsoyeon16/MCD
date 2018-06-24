<%@page import="com.mcd.controller.HttpUtil"%>
<%@page import="com.mcd.vo.Member"%>
<%@page import="com.mcd.service.Service"%>
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
String id = (String) session.getAttribute("id");
Service service = Service.getInstanse();
Member member = service.getMember(id);
if(id!=null) {%>
<form class="login" action="logout.do" method="post">
<div class="info" style="color:#dfb300">
${id} 님 안녕하세요!<br>
보유 머니 : <%=member.getMoney() %> 원</div>
<button type="submit">로그아웃</button>
</form>
<%} else { 
	request.setAttribute("error", "로그인 후 이용 가능한 서비스입니다.");
	HttpUtil.forward(request, response, "home.jsp");
} %>
	<div class="logo">
		<a href="index.jsp"><img src="images/logo_2.png" width="200"></a>
	</div>
		
<nav>
	<ul>
		<li><a href="menu.jsp">MENU</a></li>
		<li><a href="reviewList.jsp">REVIEW</a></li>	
		<li><a href="mypage.jsp">MY PAGE</a></li>
		<li><a href="order.jsp">ORDER</a></li>
	</ul>
</nav>
</body>
</html>