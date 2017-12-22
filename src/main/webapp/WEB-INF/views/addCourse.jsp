<%--
  Created by IntelliJ IDEA.
  User: yangyicheng
  Date: 2017/12/22
  Time: 下午2:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta http-equiv=Content-Type content="text/html;charset=utf-8">

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>发布课程</title>

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
                    <div class="weui-cell__hd"><label class="weui-label">课程名称</label></div>
                    <div class="weui-cell__bd">
                        <input class="weui-input" type="text" id="txtCourseName" name="coursename"
                               placeholder="必填"  />
                    </div>
                </div>

                <div class="weui-cell">
                    <div class="weui-cell__hd"><label class="weui-label">选课密码</label></div>
                    <div class="weui-cell__bd">
                        <input class="weui-input" type="text" id="txtCoursePassword" name="coursePassword"
                               placeholder="必填"  />
                    </div>
                </div>

            </div>

        </form>

        <div class="weui-btn-area">
            <a href="javascript:;" class="weui-btn weui-btn_primary" id="btnSubmit">发布课程</a>
        </div>
    </div>
</div>

</div>
</body>
</html>
