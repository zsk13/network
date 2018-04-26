<%--
  Created by IntelliJ IDEA.
  User: zhuhuihui
  Date: 2017/12/24
  Time: 下午1:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<meta http-equiv=Content-Type content="text/html;charset=utf-8">
<html>
<head>
    <title>地点列表</title>
    <link rel="stylesheet"
          href="http://res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css" />

    <style type="text/css">
        .weui-input {
            text-align: right;
        }
    </style>
</head>
<body>

<div class="page__bd">
	<jsp:include page="head.jsp" />
    <div class="weui-tab">
        <div class="page__hd">
            <h1 class="page__title">地点管理</h1>
            <div class="weui-cell__ft">
                <a href="./addLocation.do" class="weui-btn weui-btn_mini weui-btn_primary">添加地点</a>
            </div>
        </div>

        <div class="weui-cells">
            <c:forEach items="${locationList}" var="location" >
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <div class="weui-cell">
                            <div class="weui-cell__bd" id="name">
                                <p>${location.locationName}</p>
                            </div>
                            <div class="weui-cell__ft" > <p>最小纬度：${location.minLcationX} 最大纬度：${location.maxLcationX} 最小经度：${location.minLcationY} 最大经度:${location.maxLocationY}</p> </div>
                        </div>
                    </div>
                    <div class="weui-cell__ft">
                        <a href="javascript:;" class="del-btn weui-btn weui-btn_mini weui-btn_warn" id="${location.lId}">删除</a>

                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="page_hd">
            <div class="button-sp-area">

                <a href="./locationList.do?pageNo=${currentPage-1}" class="weui-btn weui-btn_mini weui-btn_primary">上一页</a>
                <a href="./locationList.do?pageNo=${currentPage+1}" class="weui-btn weui-btn_mini weui-btn_primary">下一页</a>
                <a href="javascript:;" class="weui-btn weui-btn_mini weui-btn_default">共${totalPage}页，当前第${currentPage}页</a>

            </div>
        </div>

    </div>
</div>
</div>

</div>

</body>
<script src="../js/jquery.min.js"></script>
<script type="text/javascript" >
    $(document).ready(function () {

        $('.del-btn').click(function () {
            var id = $(this).attr('id')
            var msg = "您真的确定要删除吗？";
            if (confirm(msg)==true){
                Delete(id);
            }
        })


    });

    function Delete(id) {
        $.ajax({
            // url: _ctx + '/question/add.do',   http://47.100.116.100/network/question/add.do
            url:'./delete.do',
            type: 'POST',
            dataType: "JSON",
            contentType: "application/x-www-form-urlencoded;charset=utf-8",
            data: {lId: id},
            success: function (data) {
                console.log("success")
                console.log(data)
                if (data.message == "success") {
                    //alert("删除成功");
                    location.href ="./locationList.do";
                } else {
                    //alert(info.msg)
                }


            },
            error: function (data) {
                console.log("why")
                console.log(data)
                console.error()
                alert('fail: 删除失败');
            }
        });

    }
</script>



</html>
