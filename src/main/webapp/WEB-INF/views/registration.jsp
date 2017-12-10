<%--
  Created by IntelliJ IDEA.
  User: zhuhuihui
  Date: 2017/12/9
  Time: 上午10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="../css/weui.css">
    <link rel="stylesheet" href="../css/example.css">
    <script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
    <script src="http://libs.baidu.com/jquery/1.8.3/jquery.min.js"></script>
    <script>
        alert(location.href.split('#')[0]);
        wx.config({
            debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
            appId: '${appId}', // 必填，企业号的唯一标识，此处填写企业号corpid
            timestamp: parseInt("${timestamp}", 10), // 必填，生成签名的时间戳
            nonceStr: '${noncestr}', // 必填，生成签名的随机串
            signature: '${signature}',// 必填，签名，见附录1
            jsApiList: ['getLocation'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
        });
        wx.ready(function () {
        });

        wx.error(function (res) {
        });
    </script>
</head>
<body>
<a href="javascript:submitOrderInfoClick();" class="weui-btn weui-btn_mini weui-btn_primary">按钮</a>
<input type="hidden" name="openId" id="openId" value="${openId}">
<input type="hidden" name="url" id="url" value="${url}">

<button id="getBBS" style="width:1000px;height:600px;font-size:150px;" onclick="submitOrderInfoClick();">获取地理位置</button>
</body>
<script type="text/javascript">
    function submitOrderInfoClick() {
        var date = new Date();
        wx.getLocation({
            type: 'gcj02',
            success: function (res) {
                alert("获取地理位置成功，经纬度为：（" + res.latitude + "，" + res.longitude + "）");
                $.ajax({
                    type: "POST",
                    url: "./addRegistration.do",
                    data: {
                        openId: $("#openId").val(),
                        location_x: res.latitude,
                        location_y: res.longitude,
                        date: date
                    },
                    dataType: "json",
                    success: function (data) {
                        switch (data.code) {
                            case 1:
                                alert("签到失败，当前时间内没有课程！")
                                break;
                            case 2:
                                alert("签到失败，您不在上课地点，请检查定位！")
                                break;
                            case 3:
                                alert("签到成功！")
                                break;
                            case 4:
                                alert("您已签到，请勿重复签到！")
                                break;
                        }
                    }

                });
            },
            fail: function (error) {
                AlertUtil.error("获取地理位置失败，请确保开启GPS且允许微信获取您的地理位置！");
            }
        });
    }
</script>
<script src="./js/zepto.min.js"></script>
<script src="https://res.wx.qq.com/open/libs/weuijs/1.0.0/weui.min.js"></script>
<script src="./js/example.js"></script>
</html>