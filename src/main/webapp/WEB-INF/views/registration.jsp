<%--
  Created by IntelliJ IDEA.
  User: zhuhuihui
  Date: 2017/12/9
  Time: 上午10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <style>
        @
        -moz-keyframes nodeInserted {
        from {opacity: 0.99;
        }

        to {
            opacity: 1;
        }

        }
        @
        -webkit-keyframes nodeInserted {
        from {opacity: 0.99;
        }

        to {
            opacity: 1;
        }

        }
        @
        -o-keyframes nodeInserted {
        from {opacity: 0.99;
        }

        to {
            opacity: 1;
        }

        }
        @
        keyframes nodeInserted {
        from {opacity: 0.99;
        }

        to {
            opacity: 1;
        }

        }
        embed, object {
            animation-duration: .001s;
            -ms-animation-duration: .001s;
            -moz-animation-duration: .001s;
            -webkit-animation-duration: .001s;
            -o-animation-duration: .001s;
            animation-name: nodeInserted;
            -ms-animation-name: nodeInserted;
            -moz-animation-name: nodeInserted;
            -webkit-animation-name: nodeInserted;
            -o-animation-name: nodeInserted;
        }
    </style>
    <link rel="stylesheet" href="../css/weui.css">
    <link rel="stylesheet" href="../css/example.css">
    <script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
    <script src="http://libs.baidu.com/jquery/1.8.3/jquery.min.js"></script>
    <script>
    //    alert(location.href.split('#')[0]);
        wx.config({
            debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
            appId: '${appId}', // 必填，企业号的唯一标识，此处填写企业号corpid
            timestamp: parseInt("${timestamp}", 10), // 必填，生成签名的时间戳
            nonceStr: '${noncestr}', // 必填，生成签名的随机串
            signature: '${signature}',// 必填，签名，见附录1
            jsApiList: ['getLocation'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
        });
        wx.ready(function () {
        });

        wx.error(function (res) {
            alert("获取位置失败！请检查定位是否打开！")
        });
    </script>
    <script src="../js/jquery.min.js"></script>
</head>
<body>
<div class="container" id="container">
    <div class="page home js_show">
        <div class="page list js_show">
            <div class="page__bd">
                <div class="weui-cell weui-cell_select">
                    <div class="weui-cell__bd">
                        <select class="weui-select" name="registrationSelect" id="registrationSelect">
                            <c:choose>
                                <c:when test="${registrationList!=null && fn:length(registrationList) > 0}">    <!--如果数组为空 -->
                                    <c:forEach var="registration" items="${registrationList}">
                                        <option value="${registration.cId}">${registration.cName}</option>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>  <!--否则 -->
                                    <option value="">目前暂时没有可签到课程</option>
                                </c:otherwise>
                            </c:choose>
                        </select>
                    </div>
                </div>
                <a href="javascript:;" id="registration" class="weui-btn weui-btn_plain-primary">签到</a>
            </div>
        </div>
    </div>
</div>
<input type="hidden" name="openId" id="openId" value="${openId}">
<div align="center">
<button id="getBBS" style="width:800px;height:500px;font-size:150px;" onclick="submitOrderInfoClick();">签到</button>
</div>
</body>
<script type="text/javascript">
        $(function(){
            $('#registration').on('click', function(){
                var date = new Date();
                wx.getLocation({
                    type: 'gcj02',
                    success: function (res) {
                        //   alert("获取地理位置成功，经纬度为：（" + res.latitude + "，" + res.longitude + "）");
                        $.ajax({
                            type: "POST",
                            url: "./addRegistration.do",
                            data: {
                                openId: $("#openId").val(),
                                location_x: res.latitude,
                                location_y: res.longitude,
                                date: date.getTime(),
                                rId: $('#registrationSelect option:selected').text(),

                            },
                            dataType: "json",
                            error: function (data) {
                                alert("签到失败，请稍后重试！");
                            },
                            success: function (data) {
                                // alert(data.state);
                                switch (data.state) {
                                    case 0:
                                        alert("您还没有注册，无法签到！")
                                        break;
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
                        alert("获取地理位置失败，请确保开启GPS且允许微信获取您的地理位置！");
                    }
                });
            });
        });
</script>

<script src="./js/zepto.min.js"></script>
<script src="https://res.wx.qq.com/open/libs/weuijs/1.0.0/weui.min.js"></script>
<script src="./js/example.js"></script>
</html>