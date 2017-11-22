<%@page import="java.util.Set"%>
<%@page import="com.newer.petstore.domain.Product"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.newer.petstore.domain.Cart"%>
<%@page import="com.newer.petstore.AppInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/master.css" rel="stylesheet">
</head>
<body>
	<%@ include file="header.jsp"%>
	<h1>${account.name}购物车<a href="index.jsp">继续购物</a>
	</h1>
	<%
		Cart cart = (Cart) session.getAttribute(AppInfo.SESSION_CART);
		HashMap<Product, Integer> m = cart.getMap();
		Set<Product> products = m.keySet();
	%>
	<table>
		<tr>
			<th>名称</th>
			<th>单价</th>
			<th>图片</th>
			<th>数量</th>
		</tr>
		<%
			for (Product p : products) {
		%>
		<tr>
			<td><%=p.getTitle()%></td>
			<td><%=p.getPrice()%></td>
			<td><img alt="" src="<%=p.getPicPath()%>"></td>
			<td><%=m.get(p)%></td>
		</tr>
		<%
			}
		%>
	</table>

	<div>
		<a href="account.jsp">结账</a>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>