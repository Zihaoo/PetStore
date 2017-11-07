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
<title>Insert title here</title>
<link href="css/master.css" rel="stylesheet">
</head>
<body>
	<%@ include file="header.jsp"%>
	<h1>在线人数：${online }<a href="logout">注销</a></h1>
	
	<%-- 	<%
		List<Category> list = (List<Category>) application.getAttribute(AppInfo.APP_CATEGORY_LIST);

		for (Category c : list) {
	%>
	<div><%=c.getId()%><%=c.getTitle()%></div>
	<%
		}
	%> --%>
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
			<td><a href="cart?id=${e.id }">加入购物车</a></td>
		</tr>
		</c:forEach>
	</table>
	<%@ include file="footer.jsp"%>

</body>
</html>
