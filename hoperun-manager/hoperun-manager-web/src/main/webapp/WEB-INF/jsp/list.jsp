<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- jstl:处理后台发送的数据 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>
	<table align="center" border="1">
		<tr>
			<td>用户名</td>
			<td>电话号码</td>
			<td>邮箱</td>
			<td>操作</td>
		</tr>

		<c:forEach items="${list}" var="data">
			<tr>
				<td>${data.username}</td>
				<td>${data.phone}</td>
				<td>${data.e_mail}</td>
				<td>
					<a href="${pageContext.request.contextPath}/deleteById?uid=${data.uid}">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
</body>
</html>