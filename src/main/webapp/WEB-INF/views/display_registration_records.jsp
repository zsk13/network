<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List" %>
<%@ page import="network.model.Rollcall" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>点名详情</title>
<link href="../css/example.css" rel='stylesheet' type='text/css' />
<link href="../css/weui.css" rel='stylesheet' type='text/css' />
<style>@-moz-keyframes nodeInserted{from{opacity:0.99;}to{opacity:1;}}@-webkit-keyframes nodeInserted{from{opacity:0.99;}to{opacity:1;}}@-o-keyframes nodeInserted{from{opacity:0.99;}to{opacity:1;}}@keyframes nodeInserted{from{opacity:0.99;}to{opacity:1;}}embed,object{animation-duration:.001s;-ms-animation-duration:.001s;-moz-animation-duration:.001s;-webkit-animation-duration:.001s;-o-animation-duration:.001s;animation-name:nodeInserted;-ms-animation-name:nodeInserted;-moz-animation-name:nodeInserted;-webkit-animation-name:nodeInserted;-o-animation-name:nodeInserted;}</style>
</head>
<body>

	<table border=1>
		<tr>
			<th colspan = 6>
				点名详情
			</th>
		</tr>
		
		<tr>
			<td>
				学号
			</td>
			<td>
				姓名
			</td>
			<td>
				课程名
			</td>
			<td>
				课堂名
			</td>
			<td>
				签到地点
			</td>
			<td>
				签到时间
			</td>
		</tr>
		
		<c:forEach items = "${rollcallDisplayList }" var = "rollcallDisplay">
			<tr>
			<td>
				<c:out value = "${ rollcallDisplay.studentNumber}" />
			</td>
			<td>
				<c:out value = "${ rollcallDisplay.personName}" />
			</td>
			<td>
				<c:out value = "${ rollcallDisplay.className}" />
			</td>
			<td>
				<c:out value = "${ rollcallDisplay.registrationName}" />
			</td>
			<td>
				<c:out value = "${ rollcallDisplay.locationName}" />
			</td>
			<td>
				<c:out value = "${ rollcallDisplay.rollcallTime}" />
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>