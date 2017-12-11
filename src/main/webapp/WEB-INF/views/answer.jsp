<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta http-equiv=Content-Type content="text/html;charset=utf-8">

<%--<script type="text/javascript" src="${ctx}/WEB-INF/js/answer.js"></script>--%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>

    <title> 答案统计</title>

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
        <div class="weui-tab">
            <div class="weui-navbar">
                <div class="weui-navbar__item " id="tab1">
                    提问
                </div>
                <div class="weui-navbar__item" id = "tab2">
                    问题列表
                </div>
                <div class="weui-navbar__item weui-bar__item_on" id ="tab3">
                    答案统计
                </div>
            </div>
            <div class="weui-cells" style="padding-top: 60px;">
                <div class="weui-cell">
                    <div class="weui-cell__hd"><label class="weui-label">答对人数 </label></div>
                    <div class="weui-cell__bd">
                        <input class="weui-input" type="text" id="truenum" name="truepeople"
                                required readonly  />
                    </div>
                </div>

                <div class="weui-cell">
                    <div class="weui-cell__hd"><label class="weui-label">答错人数 </label></div>
                    <div class="weui-cell__bd">
                        <input class="weui-input" type="text" id="wrongnum" name="wrongpeople"
                               required readonly   />
                    </div>
                </div>

                <div class="weui-cells__title">统计图展示</div>
                <div class="weui-cells weui-cells_form">
                    <div class="weui-cell">
                        <div class="weui-cell__bd">
                        <textarea class="weui-textarea"  id="show" name="ansshow"> </textarea>

                        </div>
                    </div>
                </div>

            </div>



        </div>


    </div>
</div>

</div>

</body>
<script type="text/javascript" src="http://g.alicdn.com/msui/sm/0.6.2/js/sm.js" charset="utf-8"></script>
<script type="text/javascript" src="http://g.alicdn.com/msui/sm/0.6.2/js/sm-extend.js" charset="utf-8"></script>

<script src="/network/js/jquery.min.js"></script>
<script type="text/javascript" src="/network/js/answer.js"></script>
</html>


