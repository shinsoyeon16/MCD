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
${id} �� �ȳ��ϼ���!<br>
���� �Ӵ� : <%=member.getMoney() %> ��</div>
<button type="submit">�α׾ƿ�</button>
</form>
<%} else { 
	request.setAttribute("error", "�α��� �� �̿� ������ �����Դϴ�.");
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