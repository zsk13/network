<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

<title>发起点名</title>
</head>
<body>
	<form id = "form1" action="./add.do" method="post">
		<input type = "text" id = "makeString1" name = "name" value = ""  hidden="hidden"></input>
		<table>
			<tr>
				<th colspan = 2>发起点名</th>
			</tr>
			<tr>
				<td>课程名称：</td>
				<td><input type = "text" name = "className"></input></td>
			</tr>
			<tr>
				<td>学生班级：</td>
				<td>
					<select id = "grade">
						<option value = "2014">2014</option>
						<option value = "2015">2015</option>
						<option value = "2016">2016</option>
						<option value = "2017">2017</option>
						<option value = "2018">2018</option>
					</select>
					级
					<select id = "educational_background">
						<option value = "bachelor">本科</option>
						<option value = "master">研究</option>
					</select>
					生
					<select id = "study_class">
						<option value = "1">1</option>
						<option value = "2">2</option>
						<option value = "3">3</option>
						<option value = "4">4</option>
					</select>
					班第<input type = "text" id = "count" onblur="makeStringOutOfGradeEducationalBackgroundStudyClassAndRollCallCount();"></input>
					次点名
				</td>
			</tr>
			<tr>
				<td>位置：</td>
				<td>
					<select  name = "location_id">
						<option value = "1">馆3</option>
						<option value = "2">费彝民楼</option>
						<option value = "3">教学楼</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>开始时间：</td>
				<td><input type = "text" name = "sTime">（时间格式：2011-11-11 11:11:11）</input></td>
			</tr>
			<tr>
				<td>结束时间：</td>
				<td><input type = "text" name = "eTime">（时间格式：2011-11-11 11:11:11）</input></td>
			</tr>
			<tr>
				<td><input type = "submit" value = "提交"></input></td>
				<td><input type = "button" value = "重置"  onclick = "formReset()"/></td>
			</tr>
		</table>
	</form>
</body>
</html>