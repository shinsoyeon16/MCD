<%@page import="com.mcd.vo.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mcd.service.Service"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link href="/mcd/css/point.css" rel="stylesheet" type="text/css">
<title>admin �ֹ� ����</title>
</head>
<body>
<header>
	<jsp:include page="header.jsp"></jsp:include>
</header>

<section>
<%
Service service = Service.getInstanse();
ArrayList<Order> list = service.orderList();
%>
		<h2>�ֹ� ����</h2>
<table class="table">
<% if(! list.isEmpty()) {
	   %>
<thead>
	<tr>
		<th>�ֹ���ȣ</th>
		<th>�̸�</th>
		<th>����</th>
		<th>�ֹ���</th>
		<th>�ֹ���¥</th>
		<th>�ֹ�����</th>
	</tr>
</thead>
<tbody>
<%
         for (int i = 0; i < list.size(); i++) {
               Order o = list.get(i);
               request.setAttribute("o", o);
               String name = service.getFood(o.getFood()); %>
     
     <tr>
       <td>${o.orderNumber }</td>
       	<td><%=name%></td>
       	<td>${o.totalPrice}</td>
        <td>${o.orderId}</td>
        <td>${o.orderDate}</td>
        <td><div class="review">
        <a href="/mcd/orderProc.do?orderNumber=${o.orderNumber }"  style="text-decoration:none">
        <% switch(o.getState()) { 
        case 0: %> <button type="submit">���� �Ϸ�</button><% break;
     	case 1: %> <button type="submit">���� �Ϸ�</button></a><% break;
     	default: %><h5>���� �Ϸ�</h5><%} %></a>
     	</div>
     	</td>
      </tr>
</tbody>
<% }}else {
            out.print("<h3>��ϵ� ������ �����ϴ�.<h3>");
         }
      %>
</table>
<br><br>
</section>

<footer>
<jsp:include page="footer.jsp"></jsp:include>
</footer>
</body>
</html>