
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta http-equiv=Content-Type content="text/html;charset=utf-8">
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>

    <title> 发布问题 </title>

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
			<jsp:include page="head.jsp" />
            <div class="weui-tab">
                <div class="weui-navbar">
                    <div class="weui-navbar__item weui-bar__item_on" id = "tab1">
                        	<a href="./addquestion.do">提问</a>
                    </div>
                    <div class="weui-navbar__item" id="tab2">
                       <a href="./questionlist.do">问题列表</a>
                    </div>
                </div>
                <%--<div class="weui-tab__panel">--%>

                <%--</div>--%>


            <div class="weui-cells__title" style="padding-top: 60px;">选择班级</div>
			<div class="weui-cell weui-cell_select">
                <div class="weui-cell__bd">
                    <select class="weui-select" name="cId" id = "cId">
                    	<c:forEach items="${courseList }" var="q">
							<option value="${q.cId }">${q.cName }</option>
						</c:forEach>
  
                    </select>
                </div>
            </div>




            <div class="weui-cells__title" style="padding-top: 60px;">问题内容</div>
            <div class="weui-cells weui-cells_form">
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <textarea class="weui-textarea" placeholder="问题内容（必填）" id="question" name="content"
                                  rows="3" required maxlength="100" required> </textarea>

                    </div>
                </div>
            </div>

            <div class="weui-cells__title">问题答案</div>
            <div class="weui-cells weui-cells_form">
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <textarea class="weui-textarea" placeholder="问题答案（必填）" id="answer" name="ans"
                                  rows="3" required maxlength="100" required> </textarea>

                    </div>
                </div>
            </div>



        <div class="weui-btn-area">
            <%--<a href="javascript:;" class="button button-fill" style="margin: auto;" id="btnSubmit">提交</a>--%>
            <a href="javascript:;" class="weui-btn weui-btn_primary" id="btnSubmit">提交</a>

        </div>
            </div>
    </div>
</div>

</div>

</body>
<script type="text/javascript" src="http://g.alicdn.com/msui/sm/0.6.2/js/sm.js" charset="utf-8"></script>
<script type="text/javascript" src="http://g.alicdn.com/msui/sm/0.6.2/js/sm-extend.js" charset="utf-8"></script>


<%--<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>--%>
<%--<script type="text/javascript" src="${ctx}/js/question.js"></script>--%>

<script src="/network/js/jquery.min.js"></script>
<script type="text/javascript" src="/network/js/question.js"></script>
</html>


