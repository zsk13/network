<%--
  Created by IntelliJ IDEA.
  User: zhuhuihui
  Date: 2017/12/22
  Time: 下午6:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
        <form id="formData" action="./location/add.do" >
            <div class="weui-cells">
                <div class="weui-cell">
                    <div class="weui-cell__hd"><label class="weui-label">上课地点</label></div>
                    <div class="weui-cell__bd">
                        <input class="weui-input" type="text" id="locationName" name="locationName"
                               placeholder="必填"  />
                    </div>
                </div>

                <div class="weui-cell">
                    <div class="weui-cell__hd"><label class="weui-label">最小纬度</label></div>
                    <div class="weui-cell__bd">
                        <input class="weui-input" id="minLcationX" name="minLcationX" placeholder="必填">
                    </div>
                </div>
                <div class="weui-cell">
                    <div class="weui-cell__hd"><label class="weui-label">最大纬度</label></div>
                    <div class="weui-cell__bd">
                        <input class="weui-input" id="maxLcationX" name="maxLcationX" placeholder="必填">
                    </div>
                </div>
                <div class="weui-cell">
                    <div class="weui-cell__hd"><label class="weui-label">最小经度</label></div>
                    <div class="weui-cell__bd">
                        <input class="weui-input" id="minLcationY" name="minLcationY" placeholder="必填">
                    </div>
                </div>
                <div class="weui-cell">
                    <div class="weui-cell__hd"><label class="weui-label">最大经度</label></div>
                    <div class="weui-cell__bd">
                        <input class="weui-input" id="maxLcationY" name="maxLcationY" placeholder="必填">
                    </div>
                </div>
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <p>http://www.gpsspg.com/maps.htm</p>
                    </div>
                    <div class="weui-cell__ft">经纬度获取地址，注意需要填入的是谷歌地图</div>
                </div>

            </div>

        </form>

        <div class="weui-btn-area">
            <a class="weui-btn weui-btn_primary" href="javascript:" id="submitForm">确定</a>
        </div>
    </div>
</div>

</div>
<script type="text/javascript">
    $(function(){

        $('#submitForm').on('click', function(){
            $('#formData').submit();
        });
    });
</script>
</body>
</html>
