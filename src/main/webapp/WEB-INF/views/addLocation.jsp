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
    <script src="../js/jquery.min.js"></script>
</head>
<body>
<div class="container" id="container">
    <div class="page home js_show">
        <div class="page list js_show">
            <div class="page__bd">
            	<jsp:include page="head.jsp" />
                <form id="formData" action="./add.do" >
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
</div>

</div>
<script type="text/javascript">
    $(function(){

        $('#submitForm').on('click', function(){
           Submit();
        });
    });
</script>
<script type="text/javascript">
    function Submit() {
        var re = /^[0-9]+.?[0-9]*$/;

        if ($("#locationName").val().trim() == "") {
            alert("请输入上课地点")
            return false;
        }

        if (!re.test($("#minLcationX").val().trim())) {
            alert("请输入正确的最小纬度")
            return false;
        }

        if (!re.test($("#maxLcationX").val().trim())) {
            alert("请输入正确的最大纬度")
            return false;
        }

        if (!re.test($("#minLcationY").val().trim())) {
            alert("请输入正确的最小经度")
            return false;
        }

        if (!re.test($("#maxLcationY").val().trim())) {
            alert("请输入正确的最大经度")
            return false;
        }

        var locationName=$("#locationName").val();
        var minLcationX=$("#minLcationX").val();
        var maxLcationX=$("#maxLcationX").val();
        var minLcationY=$("#minLcationY").val();
        var maxLcationY=$("#maxLcationY").val();


        $.ajax({
            // url: _ctx + '/question/add.do',   http://47.100.116.100/network/question/add.do
            url:'./add.do',
            type: 'POST',
            dataType: "JSON",
            contentType: "application/x-www-form-urlencoded;charset=utf-8",
            data: {locationName: locationName,minLcationX: minLcationX,maxLcationX: maxLcationX,minLcationY: minLcationY,maxLcationY: maxLcationY},
            success: function (data) {
                console.log("success")
                console.log(data)
                if (data.message == "success") {
                    alert("添加成功");
                    location.href ="./locationList.do";
                } else {
                    //alert(info.msg)
                }


            },
            error: function (data) {
                console.log("why")
                console.log(data)
                console.error()
                alert('fail: 添加失败');
            }
        });

    }

</script>
</body>
</html>
