<%@page import="com.newer.petstore.AppInfo"%>
<%@page import="com.newer.petstore.domain.Category"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>



	<%
		List<Category> list = (List<Category>) application.getAttribute(AppInfo.APP_CATEGORY_LIST);
		for (Category c : list) {
	%>
			<div>编号：<%=c.getId() %>名称：<%=c.getTitle() %></div>
	<%
		}
	%>

</body>
</html>