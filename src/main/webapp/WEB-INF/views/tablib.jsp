<%--
  Created by IntelliJ IDEA.
  User: yangyicheng
  Date: 17/12/10
  Time: 下午3:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 设置一个项目路径的变量  -->
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>

<meta http-equiv=Content-Type content="text/html;charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<meta name="format-detection" content="telephone=no">
<!-- JS -->
<script type="text/javascript" src="${ctx}/js/zepto/zepto.min.js"></script>
<script type="text/javascript" src="${ctx}/js/zepto/event.js"></script>
<script type="text/javascript" src="${ctx}/js/zepto/touch.js"></script>
<script type="text/javascript" src="${ctx}/js/moment/moment.js"></script>
<script type="text/javascript" src="${ctx}/js/views/utility.js"></script>
<script type="text/javascript" src="${ctx}/js/js.cookie-2.1.2.min.js"></script>
<%--<script type="text/javascript" src="http://g.alicdn.com/dingding/open-develop/1.5.1/dingtalk.js"></script>--%>
<script type="text/javascript" src="${ctx}/js/utility/lodash.core.min.js"></script>
<script type="text/javascript" src="${ctx}/js/utility/lodash.min.js"></script>

<link rel="stylesheet" href="${ctx}/css/ourcss.css">
<link rel="stylesheet" href="http://g.alicdn.com/msui/sm/0.6.2/css/sm.css">
<link rel="stylesheet" href="http://g.alicdn.com/msui/sm/0.6.2/css/sm-extend.css">

<script type="application/javascript">
    var _ctx="${ctx}";
    function NewPage(url) {
        window.location.href = _ctx + url;
    }
</script>





