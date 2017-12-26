<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师</title>
<link href="../css/example.css" rel='stylesheet' type='text/css' />
<link href="../css/weui.css" rel='stylesheet' type='text/css' />
<style>@-moz-keyframes nodeInserted{from{opacity:0.99;}to{opacity:1;}}@-webkit-keyframes nodeInserted{from{opacity:0.99;}to{opacity:1;}}@-o-keyframes nodeInserted{from{opacity:0.99;}to{opacity:1;}}@keyframes nodeInserted{from{opacity:0.99;}to{opacity:1;}}embed,object{animation-duration:.001s;-ms-animation-duration:.001s;-moz-animation-duration:.001s;-webkit-animation-duration:.001s;-o-animation-duration:.001s;animation-name:nodeInserted;-ms-animation-name:nodeInserted;-moz-animation-name:nodeInserted;-webkit-animation-name:nodeInserted;-o-animation-name:nodeInserted;}</style>
</head>
<body>
	<div class="container" id="container">
		<div class="page home js_show">
			<div class="page list js_show">
				<div class="page__bd">
					<div class="weui-cells__title">欢迎${sessionScope.teacher.tName} 老师</div>
					<div class="weui-cells">
						<a class="weui-cell weui-cell_access" href="/network/manage/display_registrations.do">
							<div class="weui-cell__bd">
								<p>我要查看历史点名情况</p>
							</div>
							<div class="weui-cell__ft"></div>
						</a> <a class="weui-cell weui-cell_access" href="./start_add.do">
							<div class="weui-cell__bd">
								<p>我要发布一次点名</p>
							</div>
							<div class="weui-cell__ft"></div>
						</a><a class="weui-cell weui-cell_access" href="../location/locationList.do">
						<div class="weui-cell__bd">
							<p>查看/新增 签到地点</p>
						</div>
						<div class="weui-cell__ft"></div>
					</a><a class="weui-cell weui-cell_access" href="../question/addquestion.do">
						<div class="weui-cell__bd">
							<p>发布问题</p>
						</div>
						<div class="weui-cell__ft"></div>
					</a><a class="weui-cell weui-cell_access" href="../question/questionlist.do">
						<div class="weui-cell__bd">
							<p>查看已发布问题</p>
						</div>
						<div class="weui-cell__ft"></div>
					</a><a class="weui-cell weui-cell_access" href="../course/addCourse.do">
						<div class="weui-cell__bd">
							<p>创建课程</p>
						</div>
						<div class="weui-cell__ft"></div>
					</a>
					<a class="weui-cell weui-cell_access" href="../course/courseList.do">
						<div class="weui-cell__bd">
							<p>课程列表</p>
						</div>
						<div class="weui-cell__ft"></div>
					</a>
					</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>