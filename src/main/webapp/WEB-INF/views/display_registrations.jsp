<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List" %>
<%@ page import="network.model.Registration" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>点名列表</title>
</head>
<body>


	<table border="1">
		<tr>
			<th colspan = 2>
				点名列表
			</th>
		</tr>
		
		<tr>
			<td>
				点名名称
			</td>
			<td>
				点名开始时间
			</td>
		</tr>
		
		<c:forEach var="registration" items="${registrationList}">
		<tr>
			<td>
				<a href = "./display_registration_records.do?registrationId=${registration.rId }">
					<c:out value="${registration.name}"/>
				</a>
			</td>
			<td>
				<c:out value ="${registration.sTime}"/>
			</td>
		</tr>
	
		</c:forEach>
	</table>
</body>
</html>