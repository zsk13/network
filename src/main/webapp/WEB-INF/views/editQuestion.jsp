
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta http-equiv=Content-Type content="text/html;charset=utf-8">
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>

    <title> 修改问题 </title>

    <link rel="stylesheet" href="http://res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css"/>

    <style type="text/css">
        .weui-input {
            text-align: right;
        }

    </style>
<script src="/network/js/jquery.min.js"></script>
</head>

<body>
<div class="page">
    <div class="page__bd">

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
                    	<c:forEach items="${courseList }" var="c">
							<c:if test="${c.cId eq q.courseId}">
								<option  selected value="${c.cId }">${c.cName }</option>
							</c:if>
							<c:if test="${not (c.cId eq q.courseId)}">
								<option  value="${c.cId }">${c.cName }</option>
							</c:if>
						</c:forEach>
  
                    </select>
                </div>
            </div>

			<input type="hidden" id="qid" value="${q.qid }"></input>


            <div class="weui-cells__title" style="padding-top: 60px;">问题内容</div>
            <div class="weui-cells weui-cells_form">
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <textarea class="weui-textarea" placeholder="问题内容（必填）" id="question" name="content"
                                  rows="3" required maxlength="100" required> ${q.question }</textarea>

                    </div>
                </div>
            </div>

            <div class="weui-cells__title">问题答案</div>
            <div class="weui-cells weui-cells_form">
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <textarea class="weui-textarea" placeholder="问题答案（必填）" id="answer" name="ans"
                                  rows="3" required maxlength="100" required> ${q.answer }</textarea>

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
<script type="text/javascript">
		$(document).ready(function() {

			$('#btnSubmit').click(function() {
				Submit();
			})

		});

		function Submit() {

			if ($("#question").val().trim() == "") {
		        alert("请输入问题")
		        return false;
		    }

		    if ($("#answer").val().trim() == "") {
		        alert("请输入答案")
		        return false;
		    }
			var qid = $("#qid").val();
		    var question=$("#question").val();
		    var answer=$("#answer").val();
		    var cId=$("#cId").val();
		    var teacher_id = 1 ;
		    var status = "0";

		     $.ajax({
		         url:'./edit.do',
		         type: 'POST',
		         dataType: "JSON",
		         contentType: "application/x-www-form-urlencoded;charset=utf-8",
		         data: {qid:qid,cId:cId,question:question,answer:answer,status:status},
		         success: function (data) {
		             console.log(data)
		         },
		         error: function (request) {
		             console.error()
		             alert('提交成功');
		         }
		     });

		}
	</script>

</body>
<script type="text/javascript" src="http://g.alicdn.com/msui/sm/0.6.2/js/sm.js" charset="utf-8"></script>
<script type="text/javascript" src="http://g.alicdn.com/msui/sm/0.6.2/js/sm-extend.js" charset="utf-8"></script>


<%--<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>--%>
<%--<script type="text/javascript" src="${ctx}/js/question.js"></script>--%>


</html>


