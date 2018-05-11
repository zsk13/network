<%--
  Created by IntelliJ IDEA.
  User: 64167
  Date: 2017/12/22
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<meta http-equiv=Content-Type content="text/html;charset=utf-8">

<%--<script type="text/javascript" src="${ctx}/js/questionList.js"></script>--%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>

    <title>教师详情</title>

    <link rel="stylesheet"
          href="http://res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css" />

    <style type="text/css">
        .weui-input {
            text-align: right;
        }
    </style>

</head>

<body>

<div class="page__bd" id="page">
    <div class="weui-tab">
        <div class="page__hd">
            <h1 class="page__title">教师详情</h1>
        </div>

        <div class="weui-cells">
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <div class="weui-cell">
                            <div class="weui-cell__bd" >
                                <p>教师姓名</p>
                            </div>
                            <div class="weui-cell__ft" id="tName"> </div>
                        </div>
                    </div>
                </div>
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <div class="weui-cell">
                        <div class="weui-cell__bd" >
                            <p>登录密码</p>
                        </div>
                        <div class="weui-cell__ft" id="tPassword"> </div>
                    </div>
                </div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <div class="weui-cell">
                        <div class="weui-cell__bd" >
                            <p>教工号</p>
                        </div>
                        <div class="weui-cell__ft"id="tNumber" > </div>
                    </div>
                </div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <div class="weui-cell">
                        <div class="weui-cell__bd" >
                            <p>教师邮箱</p>
                        </div>
                        <div class="weui-cell__ft" id="tMail"> </div>
                    </div>
                </div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <div class="weui-cell">
                        <div class="weui-cell__bd" >
                            <p>教师电话</p>
                        </div>
                        <div class="weui-cell__ft" id="tPhone"> </div>
                    </div>
                </div>
            </div>
            <div class="weui-cell__ft">
                    <a href="javascript:;" class="weui-btn weui-btn_mini weui-btn_primary" id="btnEdit">编辑</a>
                    <a href="javascript:;" class="del-btn weui-btn weui-btn_mini weui-btn_warn" id="btnDel">删除</a>
                    <a href="javascript:;" class="weui-btn weui-btn_mini weui-btn_default" id="btnReturn">返回</a>
            </div>
        </div>

    </div>
</div>

</body>
<script src="../js/jquery.min.js"></script>
<script src="../js/editDetailTeacher.js"></script>
<script src="../js/detailTeacher.js"></script>
<script src="../js/delDetailTeacher.js"></script>
</html>