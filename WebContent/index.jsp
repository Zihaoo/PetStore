<%-- <%@page import="com.newer.petstore.AppInfo"%>
<%@page import="com.newer.petstore.domain.Category"%>
<%@page import="java.util.List"%>
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>宠物商店</title>
<style type="text/css">
.addCart {
	background-color: #4a4;
	padding: 0.5em 2em;
	color: #fff;
}

.buy {
	background-color: red;
	color: #fff;
}
</style>

<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript">

$(function() {
	$('.addCart').on('click', function() {
		/* alert($(this).val()); */
		
		var e =$(this);
		$.post(
				'cart',
				{id:$(this).val()},
				function(data) {
					e.addClass('buy');
					e.after($('<span>').text('已购买'));
				});
	});
});

// 搜索
$('#btnSearch').on('click', function() {
	
	$.get(
			'search',
			{keyWords:$('#key').val()}, 
			function(data) {
				//alert(data);
				
				$('table').remove();
				$('#r').text(data);
				
				// DOM
				// todo list
			});
});


</script>

<link href="css/master.css" rel="stylesheet">
</head>
<body>
	<%@ include file="header.jsp"%>
	<h1>
		在线人数：${online }<a href="logout">注销</a>
	</h1>


	<table>
		<tr>
			<th>名称</th>
			<th>价格</th>
			<th>信息</th>
			<th>库存</th>
			<th>销量</th>
			<th>图片地址</th>
			<th></th>
		</tr>
		<c:forEach items="${products}" var="e">
			<tr>
				<td>${e.title}</td>
				<td>${e.price}</td>
				<td>${e.info}</td>
				<td>${e.quantity}</td>
				<td>${e.salesNum}</td>
				<td><img alt="" src="${e.picPath}"></td>
				<td><button class="addCart" value="${e.id}">加入购物车</button></td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="footer.jsp"%>

</body>
</html>
