<%@page import="java.util.ArrayList"%>
<%@page import="com.mcd.service.Service"%>
<%@page import="com.mcd.vo.Review"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link href="/mcd/css/point.css" rel="stylesheet" type="text/css">
<title>���� ���</title>
</head>
<body>
<header>
	<jsp:include page="header.jsp"></jsp:include>
</header>

<section>
		<h2>review</h2>
	<%
      Service service = Service.getInstanse();
      ArrayList<Review> list = service.reviewList();
   %>
<table class="table">
<% if(! list.isEmpty()) {
	   %>
<thead>
	<tr>
		<th>��ȣ</th>
		<th>����</th>
		<th>�ۼ���</th>
		<th>�ۼ���¥</th>
	</tr>
</thead>
<tbody>
<%
         for (int i = 0; i < list.size(); i++) {
               Review r = list.get(i);
               request.setAttribute("r", r);
      %>
     <tr>
       <td>${r.seq }</td>
       	<td><a href="reviewViewForm.jsp?seq=${r.seq }">${r.title }</a></td>
       	<td>${r.writer }</td>
        <td>${r.regDate }</td>
      </tr>
     <%} %>
</tbody>
<% }else {
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