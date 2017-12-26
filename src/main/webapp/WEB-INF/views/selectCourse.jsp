<%--
  Created by IntelliJ IDEA.
  User: 张康
  Date: 2017/12/24
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<meta http-equiv=Content-Type content="text/html;charset=utf-8">
<html>
<head>
    <title>选课</title>
    <link rel="stylesheet" href="../css/weui.css">

    <style type="text/css">
        .weui-input {
            text-align: right;
        }

        .weui-swiped-btn_primary {
            background-color: #1AAD19;
        }
    </style>
    <script type="text/javascript" src="../js/jquery.min.js"></script>
</head>
<body>
<div class="container">
    <div class="page__hd">
        <h1 class="page__title">选课</h1>
    </div>
    <div class="page__bd">
        <div class="weui-cells" style="font-size: 300%;">
            <input type="hidden" name="openId" id="openId" value="${openId}"/>
            <c:forEach items="${cList}" var="c">
                <a class="weui-cell weui-cell_access" href="javascript:;" id="${c.cId}" name="${c.cId}">
                    <div class="weui-cell__bd">
                        <p>${c.cName}</p>
                    </div>
                    <div class="weui-cell__ft">点击选课</div>
                </a>

            </c:forEach>
        </div>
    </div>

    <div class="page dialog js_show">
        <%--弹窗显示输入密码--%>
        <div id="dialogs">
            <div class="js_dialog" id="androidDialog2" style="display: none;">
                <div class="weui-mask"></div>
                <div class="weui-dialog weui-skin_android">
                    <div class="weui-dialog__hd">
                        <label class="weui-label">选课密码</label>
                    </div>
                    <div class="weui-dialog__bd">
                        <input class="weui-input" type="password" placeholder="请输入选课密码" id="cPassword"/>
                    </div>
                    <div class="weui-dialog__bd" style="display: none;" id="errorPassword">
                        <p style="color: red;">密码错误！</p>
                    </div>
                    <div class="weui-dialog__ft">
                        <a href="javascript:;" class="weui-dialog__btn weui-dialog__btn_default">取消</a>
                        <a href="javascript:;" class="weui-dialog__btn weui-dialog__btn_primary" id="btnSubmit">确定</a>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    $(function () {
        $('#dialogs').on('click', '.weui-dialog__btn_default', function () {
            $(this).parents('.js_dialog').fadeOut(200);
        });

        var $androidDialog2 = $('#androidDialog2');
        var cId;

        $('.weui-cell_access').on('click', function () {
            var openId = $("#openId").val();
            if (openId == null || openId.trim().length <= 0) {
                alert("好像出了点问题，请稍后重试！");
                return false;
            }
            $androidDialog2.fadeIn(200);

            cId = $(this).attr('id');

        });
        $('#btnSubmit').on("click", function () {
            var cPassword = $('#cPassword').val();
            var openId = $("#openId").val();

            $.ajax({
                url: './add.do',
                type: 'POST',
                dataType: "JSON",
                contentType: "application/x-www-form-urlencoded;charset=utf-8",
                data: {cId: cId, cPassword: cPassword, openId: openId},
                success: function (data) {
                    console.log("success")
                    console.log(data)
                    if (data.code == 1) {
                        alert("选课成功！");
                        $androidDialog2.fadeOut(200);
                        location.href = "./addCourseStudent.do?type=1";
                    }
                    if (data.code == 2) {
                        var error = document.getElementById("errorPassword");
                        error.style.display = "";
                    }
                },
                error: function (data) {
                    console.log("why")
                    console.log(data)
                    console.error()
                    alert('fail: 选课失败，请稍后重试！');
                }
            });
        });


    });
</script>
</html>
