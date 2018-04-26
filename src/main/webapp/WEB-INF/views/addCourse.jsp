<%--
  Created by IntelliJ IDEA.
  User: yangyicheng
  Date: 2017/12/22
  Time: 下午2:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<meta http-equiv=Content-Type content="text/html;charset=utf-8">

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>发布课程</title>

<link rel="stylesheet"
	href="http://res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css" />
    <script src="../js/jquery.min.js"></script>
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
					<div class="weui-navbar__item weui-bar__item_on" id="tab1">
						<a href="./addCourse.do">创建课程</a>
					</div>
					<div class="weui-navbar__item" id="tab2">
						<a href="./courseList.do">课程列表</a>
					</div>
				</div>
			<form id="formData" action="">
				<div class="weui-cells" style="padding-top: 60px;">
					<div class="weui-cell">
						<div class="weui-cell__hd">
							<label class="weui-label">课程名称</label>
						</div>
						<div class="weui-cell__bd">
							<input class="weui-input" type="text" id="c_name" name="c_name"
								placeholder="必填" />
						</div>
					</div>

					<div class="weui-cell">
						<div class="weui-cell__hd">
							<label class="weui-label">选课密码</label>
						</div>
						<div class="weui-cell__bd">
							<input class="weui-input" type="text" id="c_password"
								name="c_password" placeholder="必填" />
						</div>
					</div>

				</div>

			</form>

			<div class="weui-btn-area">
				<a href="javascript:;" class="weui-btn weui-btn_primary"
					id="btnSubmit">发布课程</a>
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

			if ($("#c_name").val().trim() == "") {
				alert("请输入课程名称")
				return false;
			}
			if ($("#c_password").val().trim() == "") {
				alert("请输入选课密码")
				return false;
			}

			var c_name = $("#c_name").val();
			var c_password = $("#c_password").val();

			$.ajax({
						url : './publishCourse.do',
						type : 'POST',
						dataType : "JSON",
						contentType : "application/x-www-form-urlencoded;charset=utf-8",
						data : {
							c_name : c_name,
							c_password : c_password
						},
						success : function(data) {
							console.log("success")
							console.log(data)
							alert("添加成功");
							location.href = "./courseList.do";
						},
						error : function(data) {
							console.log("success")
							console.log(data)
							alert("添加成功");
							location.href = "./courseList.do";
						}
					});

		}
	</script>

</body>
</html>
