<%--
  Created by IntelliJ IDEA.
  User: yangyicheng
  Date: 17/12/8
  Time: 下午8:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta http-equiv=Content-Type content="text/html;charset=utf-8">

<script type="text/javascript" src="${ctx}/js/question.js"></script>

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
            <div class="weui-cells">
                <div class="weui-cell">
                    <div class="weui-cell__hd"><label class="weui-label">课程名称</label></div>
                    <div class="weui-cell__bd">
                        <input class="weui-input" type="text" id="txtCourseName" name="course"
                               placeholder="必填" required readonly  />
                    </div>
                </div>

            </div>

            <div class="weui-cells__title">问题内容</div>
            <div class="weui-cells weui-cells_form">
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <textarea class="weui-textarea" placeholder="问题内容（必填）" id="question" name="content"
                                  rows="3" required maxlength="100" required> </textarea>

                    </div>
                </div>
            </div>

        </form>

        <div class="weui-btn-area">
            <a href="javascript:;" class="button button-fill" id="btnSubmit">提交</a>
        </div>
    </div>
</div>

</div>

</body>
<script type="text/javascript" src="http://g.alicdn.com/msui/sm/0.6.2/js/sm.js" charset="utf-8"></script>
<script type="text/javascript" src="http://g.alicdn.com/msui/sm/0.6.2/js/sm-extend.js" charset="utf-8"></script>
</html>


