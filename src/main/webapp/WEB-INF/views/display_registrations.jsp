<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="network.model.Registration"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>点名列表</title>
<link href="../css/example.css" rel='stylesheet' type='text/css' />
<link href="../css/weui.css" rel='stylesheet' type='text/css' />
<style>
@
-moz-keyframes nodeInserted {
	from {opacity: 0.99;
}

to {
	opacity: 1;
}

}
@
-webkit-keyframes nodeInserted {
	from {opacity: 0.99;
}

to {
	opacity: 1;
}

}
@
-o-keyframes nodeInserted {
	from {opacity: 0.99;
}

to {
	opacity: 1;
}

}
@
keyframes nodeInserted {
	from {opacity: 0.99;
}

to {
	opacity: 1;
}

}
embed, object {
	animation-duration: .001s;
	-ms-animation-duration: .001s;
	-moz-animation-duration: .001s;
	-webkit-animation-duration: .001s;
	-o-animation-duration: .001s;
	animation-name: nodeInserted;
	-ms-animation-name: nodeInserted;
	-moz-animation-name: nodeInserted;
	-webkit-animation-name: nodeInserted;
	-o-animation-name: nodeInserted;
}
</style>
</head>
<body>
	<div class="container" id="container">
		<div class="page home js_show">
			<div class="page list js_show">
				<div class="page__bd">
					<div class="weui-cells__title">点名列表</div>
					<div class="weui-cells">
						<c:forEach var="registration" items="${registrationList}">
							<a class="weui-cell weui-cell_access"
								href="./display_registration_records.do?registrationId=${registration.rId }">
								<div class="weui-cell__bd">
									<p>
										<c:out value="${registration.name}" />
									</p>
								</div>
								<div class="weui-cell__ft">
									点名开始时间：
									<c:out value="${registration.sTime}" />
								</div>
							</a>

						</c:forEach>
					</div>


				</div>
			</div>
		</div>
	</div>


	<table border="1">
		<tr>
			<th colspan=2>点名列表</th>
		</tr>

		<tr>
			<td>点名名称</td>
			<td>点名开始时间</td>
		</tr>

		<c:forEach var="registration" items="${registrationList}">
			<tr>
				<td><a
					href="./display_registration_records.do?registrationId=${registration.rId }">
						<c:out value="${registration.name}" />
				</a></td>
				<td><c:out value="${registration.sTime}" /></td>
			</tr>

		</c:forEach>
	</table>
</body>
</html>