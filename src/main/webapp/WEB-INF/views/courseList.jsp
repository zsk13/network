<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<meta http-equiv=Content-Type content="text/html;charset=utf-8">

<!DOCTYPE html>
<html lang="zh-CN">
<head>

<title>课程列表</title>

<link rel="stylesheet"
	href="http://res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css" />

<style type="text/css">
.weui-input {
	text-align: right;
}
</style>

</head>

<body>
	<div class="page">
		<div class="page__bd">
							<jsp:include page="head.jsp" />
			<div class="weui-tab">
				<div class="weui-navbar">
					<div class="weui-navbar__item weui-bar__item_on" id="tab1">
						<a href="./addCourse.do">创建课程</a>
					</div>
					<div class="weui-navbar__item" id="tab2">
						<a href="./courseList.do">课程列表</a>
					</div>
				</div>
				<div class="weui-cells" style="padding-top: 60px;">
					<c:forEach items="${courseList }" var="q">
					<div class="weui-cell weui-cell_access">
						
							<div class="weui-cell__bd">
								<c:if test="${q.cState eq 1}">
								<a href="./editCourse.do?cid=${q.cId }"
									style="height: 50px; font-size: medium;">${q.cName }</a>
							     </c:if>
							     <c:if test="${not (q.cState eq 1)}">
								<a 
									style="height: 50px; font-size: medium;">${q.cName }</a>
							     </c:if>
							</div>
							<div class="weui-cell__ft" style="font-size: 0">
								<span style="vertical-align: middle; font-size: 17px;"> <c:choose>
										<c:when test="${q.cState eq 1}"> <a href="./deleteCourse.do?cid=${q.cId }">删除课程</a> </c:when>
										<c:otherwise> 已完结  </c:otherwise>
									</c:choose>
								</span> 
							</div>
						
					</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>


</body>
<script src="/network/js/jquery.min.js"></script>
<script type="text/javascript"
	src="http://g.alicdn.com/msui/sm/0.6.2/js/sm.js" charset="utf-8"></script>
<script type="text/javascript"
	src="http://g.alicdn.com/msui/sm/0.6.2/js/sm-extend.js" charset="utf-8"></script>



<script type="text/javascript" src="/network/js/questionList.js"></script>
</html>


