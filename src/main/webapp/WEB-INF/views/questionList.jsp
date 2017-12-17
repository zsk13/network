<%--
  Created by IntelliJ IDEA.
  User: yangyicheng
  Date: 17/12/9
  Time: 下午4:49
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<meta http-equiv=Content-Type content="text/html;charset=utf-8">

<%--<script type="text/javascript" src="${ctx}/js/questionList.js"></script>--%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>

<title>问题列表</title>

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
			<div class="weui-tab">
				<div class="weui-navbar">
					<div class="weui-navbar__item weui-bar__item_on" id="tab1">
						<a href="./addquestion.do">提问</a>
					</div>
					<div class="weui-navbar__item" id="tab2">
						<a href="./questionlist.do">问题列表</a>
					</div>
				</div>
				<div class="weui-cells">
				<c:forEach items="${qs }" var="q">
					<div class="weui-cell weui-cell_access">
						
							<div class="weui-cell__bd">
								<a href="./answer.do?qid=${q.qid }"
									style="height: 50px; font-size: medium;">${q.question }</a>
							</div>
							<div class="weui-cell__ft" style="font-size: 0">
								<span style="vertical-align: middle; font-size: 17px;"> <c:choose>
										<c:when test="${q.status eq 0}">
											<a onclick="publishQuestion(${q.qid })">发布问题</a>
										</c:when>
										<c:when test="${q.status eq 1}"> 回答中  </c:when>
										<c:when test="${q.status eq 2}"> 已完结  </c:when>
									</c:choose>
								</span> 
								<!--  
								<span class="weui-badge weui-badge_dot"
									style="margin-left: 5px; margin-right: 5px;"></span>
								-->
							</div>
						
					</div>
					</c:forEach>
				</div>
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


