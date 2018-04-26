
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta http-equiv=Content-Type content="text/html;charset=utf-8">
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>

    <title> 答题 </title>

    <link rel="stylesheet" href="http://res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css"/>

    <style type="text/css">
        .weui-input {
            text-align: right;
        }
		.weui-cells__title {
			font-size:4em !important;
		}
		.weui-textarea{
			font-size:4em !important;
		}
    </style>
<script src="/network/js/jquery.min.js"></script>
</head>

<body>
<div class="page">
    <div class="page__bd">


			<input type="hidden" id="openid" value="${openid }"></input>


            <div class="weui-cells__title" style="padding-top: 60px;">${question }</div>
            <div class="weui-cells weui-cells_form">
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <textarea class="weui-textarea" placeholder="答案" id="answer" name="answer"
                                  rows="3" required maxlength="100" required></textarea>

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
<script type="text/javascript">
		$(document).ready(function() {

			$('#btnSubmit').click(function() {
				Submit();
			})

		});

		function Submit() {
			var openid = $("#openid").val();
		    var answer=$("#answer").val();
		     $.ajax({
		         url:'./submit.do',
		         type: 'POST',
		         dataType: "JSON",
		         contentType: "application/x-www-form-urlencoded;charset=utf-8",
		         data: {openId:openid,answer:answer},
		         success: function (data) {
		    	     if(data){
		    	    	 alert('回答正确');
		    	     }else{
		    	    	 alert('回答错误');
		    	     }
		    	     
		             
		         },
		         error: function (request) {
		        	 if(data){
		    	    	 alert('回答正确~');
		    	     }else{
		    	    	 alert('回答错误~');
		    	     }
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


