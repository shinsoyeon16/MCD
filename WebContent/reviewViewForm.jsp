<%@page import="com.mcd.vo.Review"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mcd.service.Service"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link href="/mcd/css/point.css" rel="stylesheet" type="text/css">
<title>리뷰 보기</title>
</head>
<body>
	<%
	String id = (String) session.getAttribute("id");
    Service service = Service.getInstanse();
	String seq = request.getParameter("seq");
	Review review = service.getReview(Integer.parseInt(seq));
   %>
	<header> <jsp:include page="header.jsp"></jsp:include> </header>
	<section>
	<h2>리뷰 보기</h2>
	<form  class = "review" action="reviewDelete.do" accept-charset="utf-8"
		method="post">

		제목 : <input type="text" name="title" readonly
			value="<%=review.getTitle() %>"><br> 
			작성자 : <input type="text" name="writer" readonly value="<%=review.getWriter() %>"><br>
		<textarea name="content" cols="95" rows="25" readonly><%=review.getContent() %></textarea>
		<br>
		<input type="hidden" name="seq" value="<%=seq %>">
		<%if(id.equals(review.getWriter())) { %><button type="submit">삭제</button><%} %>
	</form>
	</section>
	<footer> <jsp:include page="footer.jsp"></jsp:include> </footer>
</body>
</html>