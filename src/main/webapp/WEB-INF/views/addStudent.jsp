<%--
  Created by IntelliJ IDEA.
  User: 张康
  Date: 2017/12/23
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生注册</title>
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
        <form id="formData" action="" >
            <div class="weui-cells">
                <div class="weui-cell">
                    <div class="weui-cell__hd"><label class="weui-label">学号</label></div>
                    <div class="weui-cell__bd">
                        <input class="weui-input" type="text" id="sno" name="sno"
                               placeholder="必填"  />
                    </div>
                </div>

                <div class="weui-cell">
                    <div class="weui-cell__hd"><label class="weui-label">姓名</label></div>
                    <div class="weui-cell__bd">
                        <input class="weui-input" type="text" id="sName" name="sName"
                               placeholder="必填"  />
                    </div>
                </div>

            </div>

        </form>

        <div class="weui-btn-area">
            <input type="hidden" name="openId" value="${openId}"/>
            <a href="javascript:;" class="weui-btn weui-btn_primary" id="btnSubmit">注册</a>
        </div>
    </div>
</div>
</body>
</html>
