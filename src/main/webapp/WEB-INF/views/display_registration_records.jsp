<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>点名详情</title>
    <link href="../css/example.css" rel='stylesheet' type='text/css'/>
    <link href="../css/weui.css" rel='stylesheet' type='text/css'/>

</head>
<body>

<div class="container" id="container">
    <div class="page home js_show">
        <div class="page__hd">
            <div class="weui-cell__ft">
                <a href="../export/rollcallExport.do?rId=${rId}"
                   class="weui-btn weui-btn_mini weui-btn_primary">下载签到表</a>
            </div>
            <div class="weui_cell">
                <div class="weui-grids">
                    <a href="javascript:;" class="weui-grid">

                        <p class="weui-grid__label">学号</p>
                    </a>
                    <a href="javascript:;" class="weui-grid">

                        <p class="weui-grid__label">姓名</p>
                    </a>
                    <a href="javascript:;" class="weui-grid">

                        <p class="weui-grid__label">是否签到</p>
                    </a>
                    <c:forEach items="${rollcallDisplayList}" var="c">
                        <a href="javascript:;" class="weui-grid">

                            <p class="weui-grid__label">${c.sno}</p>
                        </a>
                        <a href="javascript:;" class="weui-grid">

                            <p class="weui-grid__label">${c.name}</p>
                        </a>
                        <c:choose>
                            <c:when test="${c.isRegistered == 1}">
                                <a href="javascript:;" class="weui-grid" style="text-align: center;">

                                    <i class="weui-icon-success-circle"></i>
                                </a>
                            </c:when>
                            <c:otherwise>
                                <a href="javascript:;" class="weui-grid" style="text-align: center;">
                                    <i class="weui-icon-cancel"></i>
                                </a>
                            </c:otherwise>
                        </c:choose>

                    </c:forEach>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>