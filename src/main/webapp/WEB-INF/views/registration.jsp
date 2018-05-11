<%--
  Created by IntelliJ IDEA.
  User: zhuhuihui
  Date: 2017/12/9
  Time: 上午10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <style>
        @
        -moz-keyframes nodeInserted {

        from {
            opacity: 0.99;
        }

        to {
            opacity: 1;
        }

        }
        @
        -webkit-keyframes nodeInserted {

        from {
            opacity: 0.99;
        }

        to {
            opacity: 1;
        }

        }
        @
        -o-keyframes nodeInserted {

        from {
            opacity: 0.99;
        }

        to {
            opacity: 1;
        }

        }
        @
        keyframes nodeInserted {

        from {
            opacity: 0.99;
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
    <script src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="https://api.map.baidu.com/api?v=2.0&ak=Fhb4MUBVcLURvrRLPEGuBVZuTR2mkjol"></script>    
    <script type="text/javascript" src="https://developer.baidu.com/map/jsdemo/demo/convertor.js"></script>  
    <script src="../js/jquery.min.js"></script>
</head>
<body>
<div class="container" id="container">
    <div class="page home js_show">
        <div class="page list js_show">
            <div class="page__bd">
                <div class="weui-cells">
                    <div class="weui-cell weui-cell_select weui-cell_select-after">
                        <div class="weui-cell__hd">
                            <label class="weui-label" style="font-size: xx-large">课程:</label>
                        </div>
                        <div class="weui-cell__bd">
                            <input type="hidden" name="openId" id="openId" value="${openId}">
                            <select class="weui-select" name="registrationSelect" id="registrationSelect"
                                    style="font-size: xx-large">
                                <c:choose>
                                    <c:when test="${registrationList!=null && fn:length(registrationList) > 0}"> <!--如果数组为空 -->
                                        <c:forEach var="registration" items="${registrationList}">
                                            <option value="${registration.rId}">${registration.cName}</option>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise> <!--否则 -->
                                        <option value="">目前暂时没有可签到课程</option>
                                    </c:otherwise>
                                </c:choose>
                            </select>
                        </div>
                    </div>
                </div>
                <div style="text-align: center;">
                    <a href="javascript:;" id="registration" class="weui-btn weui-btn_plain-primary"
                       style="font-size: 100px;height: 200px;width: 300px;text-align: center;border-radius: 100px;line-height: 200px;">签到</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    $(function () {
        $('#registration').on('click', function () {
            $.ajax({
                type: "POST",
                url: "./addRegistration.do",
                data: {
                    openId: $("#openId").val(),
                    location_x: 1,
                    location_y: 1,
                    date: date.getTime(),
                    rId: $('#registrationSelect option:selected').val(),
                },
                dataType: "json",
                error: function (data) {
                    alert("签到失败，请稍后重试！");
                },
                success: function (data) {
                    switch (data.state) {
                        case 0:
                            alert("您还没有注册，无法签到！")
                            break;
                        case 1:
                            alert("签到失败，当前时间内没有课程！")
                            break;
                        case 2:
                            alert("签到失败，您不在上课地点，请检查定位！" + position.coords.latitude +" " +position.coords.longitude)
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
       
        	
        });
    });
            function showError(error) {
                switch (error.code) {
                    case error.PERMISSION_DENIED:
                        alert("User denied the request for Geolocation.");
                        break;
                    case error.POSITION_UNAVAILABLE:
                        alert("Location information is unavailable.");
                        break;
                    case error.TIMEOUT:
                        alert("The request to get user location timed out.");
                        break;
                    case error.UNKNOWN_ERROR:
                        alert("An unknown error occurred.");
                        break;
                }
            }



</script>

<script src="../js/zepto.min.js"></script>
<script src="https://res.wx.qq.com/open/libs/weuijs/1.0.0/weui.min.js"></script>
<script src="../js/example.js"></script>
</html>