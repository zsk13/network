<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<meta http-equiv=Content-Type content="text/html;charset=utf-8">

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>修改课程</title>

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
				<input type="hidden" id="cid" name="cid" value="${c.cId }" />
					<div class="weui-cell">
						<div class="weui-cell__hd">
							<label class="weui-label">课程名称</label>
						</div>
						<div class="weui-cell__bd">
							<input class="weui-input" type="text" id="c_name" name="c_name" value="${c.cName }"
								placeholder="必填" />
						</div>
					</div>

					<div class="weui-cell">
						<div class="weui-cell__hd">
							<label class="weui-label">选课密码</label>
						</div>
						<div class="weui-cell__bd">
							<input class="weui-input" type="text" id="c_password" value="${c.cPassword }"
								name="c_password" placeholder="必填" />
						</div>
					</div>

				</div>

			</form>

			<div class="weui-btn-area">
				<a href="javascript:;" class="weui-btn weui-btn_primary"
					id="btnSubmit">修改课程</a>
			</div>
			<div class="weui-btn-area">
				<a href="javascript:;" class="weui-btn weui-btn_primary"
					id="editstate">结束课程</a>
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
			$('#editstate').click(function() {
				editState();
			})

		});
		function editState() {
			var c_id = $("#cid").val();
			var c_name = $("#c_name").val();
			var c_password = $("#c_password").val();
			var c_state = 0;
			$.ajax({
				url : './update.do',
				type : 'POST',
				dataType : "JSON",
				contentType : "application/x-www-form-urlencoded;charset=utf-8",
				data : {
					c_name : c_name,
					c_password : c_password,
					cid:c_id,
					c_state:c_state
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
		function Submit() {

			if ($("#c_name").val().trim() == "") {
				alert("请输入课程名称")
				return false;
			}
			if ($("#c_password").val().trim() == "") {
				alert("请输入选课密码")
				return false;
			}
			var c_id = $("#cid").val();
			var c_name = $("#c_name").val();
			var c_password = $("#c_password").val();
			var c_state = 1;

			$.ajax({
						url : './update.do',
						type : 'POST',
						dataType : "JSON",
						contentType : "application/x-www-form-urlencoded;charset=utf-8",
						data : {
							c_name : c_name,
							c_password : c_password,
							cid:c_id,
							c_state:c_state
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
