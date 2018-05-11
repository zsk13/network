<%--
  Created by IntelliJ IDEA.
  User: 64167
  Date: 2017/12/22
  Time: 1:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<meta http-equiv=Content-Type content="text/html;charset=utf-8">

<%--<script type="text/javascript" src="${ctx}/js/questionList.js"></script>--%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>

    <title>编辑教师</title>

    <link rel="stylesheet"
          href="http://res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css" />

    <style type="text/css">
        .weui-input {
            text-align: right;
        }
    </style>

</head>
<body>
<h1 class="page__title">编辑教师</h1>
<div class="weui-cells weui-cells_form">
    <div class="weui-cell">
        <div class="weui-cell__hd"  style="height: 40px">
            <label class="weui-label" >姓名</label></div>
        <div class="weui-cell__bd"  style="height: 40px">
            <input class="weui-input" type="text" style="height: 40px" id="tName">
        </div>
    </div>
    <div class="weui-cell" >
        <div class="weui-cell__hd" style="height: 40px">
            <label class="weui-label" >密码</label></div>
        <div class="weui-cell__bd" style="height: 40px">
            <input class="weui-input" type="text" style="height: 40px" id="tPassword">
        </div>
    </div>
    <div class="weui-cell" >
        <div class="weui-cell__hd" style="height: 40px">
            <label class="weui-label">工号</label></div>
        <div class="weui-cell__bd" style="height: 40px">
            <input class="weui-input" type="text" style="height: 40px" id="tNumber">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd" style="height: 40px">
            <label class="weui-label">邮箱</label></div>
        <div class="weui-cell__bd" style="height: 40px">
            <input class="weui-input" type="text" style="height: 40px" id="tMail">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd" style="height: 40px">
            <label class="weui-label">手机号</label>
        </div>
        <div class="weui-cell__bd" style="height: 40px">
            <input class="weui-input" type="tel"  style="height: 40px" id="tPhone">
        </div>
    </div>
    <a href="javascript:;" class="weui-btn weui-btn_primary" id="btnUpdate">提交</a>
    <a href="javascript:;" class="weui-btn weui-btn_default" id="btnReturn">返回</a>

</div>
</body>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/returnHome.js"></script>
<script type="text/javascript" src="../js/editTeacher.js"></script>
</html>
