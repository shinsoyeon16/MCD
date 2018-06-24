<%@page import="com.mcd.vo.Member"%>
<%@page import="com.mcd.service.Service"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link href="/mcd/css/join.css" rel="stylesheet" type="text/css">
<title>My Page</title>
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
String id = (String) session.getAttribute("id");
Member member = service.getMember(id);
request.setAttribute("member", member);

%>
<section>
		<h2>회원 정보 수정</h2><br>
		<form class = "join" action="update.do" accept-charset="utf-8" method="post">

					<input type="text" name="id" readonly value="${member.id}" /><br>
	
					<input type="password" name="passwd" required value="${member.passwd}"/><br>
	
					<input type="text" name="name" required value="${member.name}"/><br>
	
					<input type="text" name="phoneNumber" required value="${member.phoneNumber}"/><br>
	
				<button type="submit">수정</button>
	
		</form><br>
		<hr>
		<h2>머니 충전</h2><br>
		<form class = "join" action="registerMoney.do" accept-charset="utf-8" method="post">

					<input type="text" name="money" placeholder="충전할 금액 입력"><br>
	
					<button type="submit">충전</button>
		</form>

</section>

<footer>
<jsp:include page="footer.jsp"></jsp:include>
</footer>
</body>
</html>