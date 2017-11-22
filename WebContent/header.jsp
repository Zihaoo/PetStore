<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header>
	<h1><a href="index.jsp">宠物店</a></h1>
	<h1></h1>
	<menu>
		<c:forEach items="${categories}" var="c">
			<li>${c.title}</li>
		</c:forEach>
		<form action="search" method="GET">
			<input type="text" name="keyWords" placeholder="请输入关键字" /> <input
				type="submit" value="搜索" />
				<li>注销</li>
				<li><a href="cart.jsp">购物车</a>
		</form>
	</menu>
</header>
