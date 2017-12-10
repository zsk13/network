<%--
  Created by IntelliJ IDEA.
  User: yangyicheng
  Date: 17/12/9
  Time: 下午4:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta http-equiv=Content-Type content="text/html;charset=utf-8">

<script type="text/javascript" src="${ctx}/js/questionList.js"></script>

<!DOCTYPE html>
<html lang="zh-CN">
<head>

    <title> 发布问题 </title>

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
        <form id="formData" action="">
            <div class="buttons-tab">
                <a href="#tab1" class="tab-link active button" style="font-size: medium;">提问</a>
                <a href="#tab2" class="tab-link button" style="font-size: medium;">问题列表</a>
                <a href="#tab3" class="tab-link button" style="font-size: medium;">答案统计</a>
            </div>

            <div class="list-block" style="margin-top: 10px;">
                <ul>
                    <div id="list"></div>
                </ul>
            </div>
        </form>

        
    </div>
</div>

</div>

</body>
<script type="text/javascript" src="http://g.alicdn.com/msui/sm/0.6.2/js/sm.js" charset="utf-8"></script>
<script type="text/javascript" src="http://g.alicdn.com/msui/sm/0.6.2/js/sm-extend.js" charset="utf-8"></script>
</html>


