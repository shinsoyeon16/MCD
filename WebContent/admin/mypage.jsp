<%@page import="com.mcd.vo.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mcd.service.Service"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link href="/mcd/css/join.css" rel="stylesheet" type="text/css">
<title>user my page</title>
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
	<jsp:include page="header.jsp"></jsp:include>
</header>
<%
Service service = Service.getInstanse();
ArrayList<Order> list = service.orderList();
int total=0;
for (int i = 0; i < list.size(); i++) {
    Order o = list.get(i);
    total += o.getTotalPrice();
}%>
<section>
		<h2>현재 매출</h2>
		<h2><%=total%> 원</h2>
		<br><br>
</section>

<footer>
<jsp:include page="footer.jsp"></jsp:include>
</footer>
</body>
</html>