<%@page import="com.mcd.vo.Menu"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mcd.service.Service"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/mcd/css/menu.css" rel="stylesheet" type="text/css">
<title>admin 메뉴</title>
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
<%
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
		<img src="/mcd/images/menu_${m.foodNumber }.png" width="200px">
		<h4>${m.name }</h4>
		<h5>${m.price }</h5>
	</div>
	<%
		if (i % 3 == 2) {
			out.print("<br>");
			}
		}
	%>
	<br><hr>
	<h2>메뉴추가</h2><br>
		<form class = "add" action="/mcd/createMenu.do" accept-charset="utf-8" method="post">
	
					<input type="text" name="name" placeholder="메뉴 명"><br>
					
					<input type="text" name="price" placeholder="가격"><br>

				<button type="submit">등록</button><br>
		</form>
	
<br><br></section>

<footer>
<jsp:include page="footer.jsp"></jsp:include>
</footer>
</body>
</html>