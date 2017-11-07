<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header>
	<h1>Xxx 宠物店</h1>
	<menu>
		<c:forEach items="${categories}" var="c">
			<li>${c.title}</li>
		</c:forEach>
	</menu>
</header>
