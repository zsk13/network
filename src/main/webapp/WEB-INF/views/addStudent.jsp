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
    <link rel="stylesheet" href="../css/weui.css">
    <style type="text/css">
        .weui-input {
            text-align: right;
        }
    </style>
    <script src="../js/jquery.min.js"></script>
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
                <div class="weui-cell">
                    <div class="weui-cell__hd"><label class="weui-label">班级</label></div>
                    <div class="weui-cell__bd">
                        <input class="weui-input" type="text" id="className" name="className"
                               placeholder="必填"  />
                    </div>
                </div>

            </div>

        </form>

        <div class="weui-btn-area">
            <input type="hidden" name="openId" id="openId" value="${openId}"/>
            <a href="javascript:;" class="weui-btn weui-btn_primary" id="btnSubmit">注册</a>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function(){

        $('#btnSubmit').on('click', function(){
            Submit();
        });
    });
</script>
<script type="text/javascript">
    function Submit() {
        if ($("#sno").val().trim() == "") {
            alert("请输入学号！")
            return false;
        }

        if ($("#sName").val().trim() =="") {
            alert("请输入姓名！")
            return false;
        }
        if ($("#className").val().trim() =="") {
            alert("请输入班级！")
            return false;
        }


        var sno=$("#sno").val();
        var sName=$("#sName").val();
        var className=$("#className").val();
        var openId=$("#openId").val();

        $.ajax({
            url:'./add.do',
            type: 'POST',
            dataType: "JSON",
            contentType: "application/x-www-form-urlencoded;charset=utf-8",
            data: {sno: sno,sName: sName,openId: openId,className:className},
            success: function (data) {
                console.log("success")
                console.log(data)
                if (data.code == 1) {
                    alert("注册成功！");
                }
                if (data.code == 2){
                    alert("您已注册，请勿重复注册！");
                }
                if (data.code == 3){
                    alert("好像出了点问题，请关闭页面重试尝试！");
                }

            },
            error: function (data) {
                console.log("why")
                console.log(data)
                console.error()
                alert('fail: 注册失败，请稍后重试！');
            }
        });

    }

</script>
</body>
</html>
