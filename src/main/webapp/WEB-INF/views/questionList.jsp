<%--
  Created by IntelliJ IDEA.
  User: yangyicheng
  Date: 17/12/9
  Time: 下午4:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta http-equiv=Content-Type content="text/html;charset=utf-8">

<%--<script type="text/javascript" src="${ctx}/WEB-INF/js/questionList.js"></script>--%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>

    <title> 问题列表 </title>

    <link rel="stylesheet" href="http://res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css"/>

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
                <div class="weui-navbar__item " id = "tab1">
                    提问
                </div>
                <div class="weui-navbar__item weui-bar__item_on" id = "tab2">
                    问题列表
                </div>
                <div class="weui-navbar__item" id = "tab3">
                    答案统计
                </div>
            </div>

            <div class="list-block" >
                <ul>
                    <div id="list"></div>
                </ul>
            </div>
        </div>


    </div>
</div>

</div>

</body>
<script type="text/javascript" src="http://g.alicdn.com/msui/sm/0.6.2/js/sm.js" charset="utf-8"></script>
<script type="text/javascript" src="http://g.alicdn.com/msui/sm/0.6.2/js/sm-extend.js" charset="utf-8"></script>

<script src="/network/js/jquery.min.js"></script>

<script type="text/javascript" src="/network/js/questionList.js"></script>
</html>


