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

		var obj = document.getElementById("class_name1");
		var cId = obj.value;

		var obj2 = document.getElementById("aCourseWhoseId="+cId);
		var cName2 = obj2.innerHTML;
		document.getElementById("makeString1").value=cName2;
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
							<select class="weui-select" id="class_name1" name = "class_id">
								<c:forEach items="${clist }" var="course">
									<option id = "aCourseWhoseId=${course.cId }" value="${ course.cId}">${course.cName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="weui-cell weui-cell_select weui-cell_select-after">
						<div class="weui-cell__hd">
							<label for="" class="weui-label">上课地点:</label>
						</div>
						<div class="weui-cell__bd">
							<select class="weui-select" name="location_id">
								<c:forEach items="${locationList}" var="location1">
									<option value="${ location1.lId}">${location1.locationName}</option>
								</c:forEach>
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
								placeholder="" name="eTime" onblur="makeStringOutOfGradeEducationalBackgroundStudyClassAndRollCallCount()">
						</div>
					</div>
					<div class="weui-btn-area">
						<a class="weui-btn weui-btn_primary" href="javascript:"
							id="showTooltips">确定</a>
					</div>
				</div>
			</div>
			<input type="text" id="makeString1" name="class_name" value="" hidden="hidden"/>
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