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
<title>购物车</title>
<link href="css/master.css" rel="stylesheet">
<style type="text/css">
.remove {
	background-color: #4a4;
	padding: 0.5em 2em;
	color: #fff;
}
</style>

<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(function() {

		
		$('.remove').on('click', function() {
			// 事件源
			var e = $(this);
			$.post('cart', {
				id : $(this).val(),
				action : 'delete'
			}, function(data) {
				console.log(data.result);
				if (data.result == 'ok') {
					e.parent().parent().remove();
				}
			});

		});
		
		$('.update').on('blur', function() {
			// 事件源
			alert($(this).val + $(this).next().val);
			var e = $(this);
			$.post(
					'cart',
					{id:$(this).val(),action : 'update'},
					function() {
						
					});
		});

	});
</script>
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
			<th></th>
		</tr>
		<%
			for (Product p : products) {
		%>
		<tr>
			<td><%=p.getTitle()%></td>
			<td><%=p.getPrice()%></td>
			<td><img alt="" src="<%=p.getPicPath()%>"></td>
			<td><input class="update" value="<%=m.get(p)%>"><input type="hidden" value="<%=p.getId()%>" ></td>
			<td><button class="remove" value="<%=p.getId()%>">删除</button></td>
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