<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="../js/jquery.min.js"></script>

<script>
	function makeStringOutOfGradeEducationalBackgroundStudyClassAndRollCallCount(){
		var grade = document.getElementById("grade").value;
		var educational_background = document.getElementById("educational_background").value;
		var study_class = document.getElementById("study_class").value;
		var count = document.getElementById("count").value;
		document.getElementById("makeString1").value=grade+"级"+educational_background+"生"+study_class+"班第"+count+"次点名";
	}
	function formReset(){
		document.getElementById("form1").reset();
	}
</script>
<link href="../css/example.css" rel='stylesheet' type='text/css' />
<link href="../css/weui.css" rel='stylesheet' type='text/css' />
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
<title>发起点名</title>
</head>
<body>
	<div class="container" id="container">
		<div class="page home js_show">
           <form id = "form1" action="./add.do" method="post">
            
			<div class="page__bd">
				<div class="weui-cells__title">发起点名</div>
				<div class="weui-cells weui-cells_form">

					<div class="weui-cell">
						<div class="weui-cell__hd">
							<label class="weui-label">课程名称：</label>
						</div>
						<div class="weui-cell__bd">
							<input class="weui-input" placeholder="课程名称" type="text"
								name="className">
							<select class="weui-select" id="class_name1">
								<c:forEach items="${clist }" var="course">
									<option value="${ course.cId}">Here is cName.<c:out value="${course.cName}"/></option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="weui-cell weui-cell_select weui-cell_select-after">
						<div class="weui-cell__hd">
							<label for="" class="weui-label">年級：</label>
						</div>
						<div class="weui-cell__bd">
							<select class="weui-select" id="grade">
								<option value="2014">2014</option>
								<option value="2015">2015</option>
								<option value="2016">2016</option>
								<option value="2017">2017</option>
								<option value="2018">2018</option>
							</select>
						</div>
					</div>
					<div class="weui-cell weui-cell_select weui-cell_select-after">
						<div class="weui-cell__hd">
							<label for="" class="weui-label">本科/研究生</label>
						</div>
						<div class="weui-cell__bd">
							<select class="weui-select" id="educational_background">
								<option value="bachelor">本科</option>
								<option value="master">研究</option>
							</select>
						</div>
					</div>
					<div class="weui-cell weui-cell_select weui-cell_select-after">
						<div class="weui-cell__hd">
							<label for="" class="weui-label">班级：</label>
						</div>
						<div class="weui-cell__bd">
							<select class="weui-select" id="study_class">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
							</select>
						</div>
					</div>
					<div class="weui-cell">
						<div class="weui-cell__hd">
							<label class="weui-label">第几次点名：</label>
						</div>
						<div class="weui-cell__bd">
							<input class="weui-input" placeholder="第几次" type="text"
								id="count"
								onblur="makeStringOutOfGradeEducationalBackgroundStudyClassAndRollCallCount();">
						</div>
					</div>
					<div class="weui-cell weui-cell_select weui-cell_select-after">
						<div class="weui-cell__hd">
							<label for="" class="weui-label">位置:</label>
						</div>
						<div class="weui-cell__bd">
							<select class="weui-select" name="location_id">
								<option value="1">馆3</option>
								<option value="2">费彝民楼</option>
								<option value="3">教学楼</option>
							</select>
						</div>
					</div>
					<div class="weui-cell">
						<div class="weui-cell__hd">
							<label for="" class="weui-label">开始时间：</label>
						</div>
						<div class="weui-cell__bd">
							<input class="weui-input" type="datetime-local" value=""
								placeholder="" name="sTime">
						</div>
					</div>
					<div class="weui-cell">
						<div class="weui-cell__hd">
							<label for="" class="weui-label">结束时间：</label>
						</div>
						<div class="weui-cell__bd">
							<input class="weui-input" type="datetime-local" value=""
								placeholder="" name="eTime">
						</div>
					</div>
					<div class="weui-btn-area">
						<a class="weui-btn weui-btn_primary" href="javascript:"
							id="showTooltips">确定</a>
					</div>
				</div>
			</div>
			<input type="text" id="makeString1" name="name" value=""
			hidden="hidden"></input>
			</form>
		</div>
	</div>
	
	<script type="text/javascript">
    $(function(){

        $('#showTooltips').on('click', function(){
        	 $('#form1').submit();
        });
    });
</script>
</body>
</html>