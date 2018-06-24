<%@page import="com.mcd.vo.Menu"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mcd.service.Service"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link href="/mcd/css/menu.css" rel="stylesheet" type="text/css">
<title>MENU</title>
</head>
<body>
<%
String error = (String) request.getAttribute("error");
if(error != null) {
	out.println("<script language='javascript'>");
	out.println("alert('" + error + "');");
	out.println("</script>");
}

		Service service = Service.getInstanse();
		ArrayList<Menu> list = service.menuList();
	%>
	<header> <jsp:include page="header.jsp"></jsp:include> </header>

	<section>
	<h2>메뉴</h2><br>
	<%
		for (int i = 0; i < list.size(); i++) {
			Menu m = list.get(i);
			request.setAttribute("m", m);
	%>
	<div class="menuDiv">
		<img src="/mcd/images/menu_${m.foodNumber }.png" width="200">
		<h4>${m.name }</h4>
		<h5>${m.price }</h5>
		<form class="menu" action="addOrder.do" method="post">
			<input type="hidden" name="foodNumber" value="${m.foodNumber }">
			<button type="submit">주문하기</button><br>
		</form>
	</div>
	<%
		if (i % 3 == 2) {
				out.print("<br>");
			}
		}
	%> <br><br></section>

	<footer> <jsp:include page="footer.jsp"></jsp:include> </footer>
</body>
</html>