<%@page import="com.mcd.controller.HttpUtil"%>
<%@page import="com.mcd.service.Service"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link href="/mcd/css/point.css" rel="stylesheet" type="text/css">
<title>user ���� �ۼ�</title>
</head>
<body>
<%
String orderNumber = request.getParameter("orderNumber");
Service service = Service.getInstanse();
service.orderProcess(orderNumber);
%>
<header>
	<jsp:include page="header.jsp"></jsp:include>
</header>
<section>

	<h2>���� �ۼ�</h2>
	<form class = "review" action="reviewWrite.do" accept-charset="utf-8" method="post">
	
					���� : <input type="text" name="title"><br>
					
					�ۼ��� : <input type="text" name="writer" readonly value="${id}"><br>
	
					<textarea name="content" cols = "95" rows = "25"></textarea><br>
					<input type="hidden" name="orderNumber" value="<%=orderNumber %>">
				<button type="submit">���</button>
	
		</form>
</section>
<footer>
	<jsp:include page="footer.jsp"></jsp:include>
</footer>
</body>
</html>