<%--
  Created by IntelliJ IDEA.
  User: 64167
  Date: 2017/12/21
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<meta http-equiv=Content-Type content="text/html;charset=utf-8">

<%--<script type="text/javascript" src="${ctx}/js/questionList.js"></script>--%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>

    <title>添加教师</title>

    <link rel="stylesheet"
          href="http://res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css" />

    <style type="text/css">
        .weui-input {
            text-align: right;
        }
    </style>

</head>
<body>
    <h1 class="page__title">添加教师</h1>
    <div class="weui-cells weui-cells_form">
        <div class="weui-cell">
            <div class="weui-cell__hd"  style="height: 40px">
                <label class="weui-label">姓名</label></div>
            <div class="weui-cell__bd"  style="height: 40px">
                <input class="weui-input" type="text" placeholder="请输入教师姓名"  style="height: 40px" id="tName">
            </div>
        </div>
        <div class="weui-cell" >
            <div class="weui-cell__hd" style="height: 40px">
                <label class="weui-label">密码</label></div>
            <div class="weui-cell__bd" style="height: 40px">
                <input class="weui-input" type="text" placeholder="请设置密码"  style="height: 40px" id="tPassword">
            </div>
        </div>
        <div class="weui-cell" >
            <div class="weui-cell__hd" style="height: 40px">
                <label class="weui-label">工号</label></div>
            <div class="weui-cell__bd" style="height: 40px">
                <input class="weui-input" type="text" placeholder="请输入职工号"  style="height: 40px" id="tNumber">
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd" style="height: 40px">
                <label class="weui-label">邮箱</label></div>
            <div class="weui-cell__bd" style="height: 40px">
                <input class="weui-input" type="text" placeholder="请输入邮箱"  style="height: 40px" id="tMail">
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd" style="height: 40px">
                <label class="weui-label">手机号</label>
            </div>
            <div class="weui-cell__bd" style="height: 40px">
                <input class="weui-input" type="tel" placeholder="请输入手机号"  style="height: 40px" id="tPhone">
            </div>
        </div>
            <a href="javascript:;" class="weui-btn weui-btn_primary" id="btnSubmit">添加</a>
            <a href="javascript:;" class="weui-btn weui-btn_default" id="btnReturn">返回</a>

    </div>
</body>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/addTeacher.js"></script>
</html>
