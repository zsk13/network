<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<meta http-equiv=Content-Type content="text/html;charset=utf-8">

<%--<script type="text/javascript" src="${ctx}/WEB-INF/js/answer.js"></script>--%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>

<title>答案统计</title>

<link rel="stylesheet"
	href="http://res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css" />

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
						<a href="./addquestion.do">提问</a>
					</div>
					<div class="weui-navbar__item" id="tab2">
						<a href="./questionlist.do">问题列表</a>
					</div>
				</div>
				<div class="weui-cells" style="padding-top: 60px;">
					<div class="weui-cell">
						<div class="weui-cell__hd">
							<label class="weui-label">答对人数 </label>
						</div>
						<div class="weui-cell__bd">
							<input class="weui-input" type="text" id="truenum"
								name="truepeople" required readonly value="${correct}" />
						</div>
					</div>

					<div class="weui-cell">
						<div class="weui-cell__hd">
							<label class="weui-label">答错人数 </label>
						</div>
						<div class="weui-cell__bd">
							<input class="weui-input" type="text" id="wrongnum"
								name="wrongpeople" required readonly value="${wrong}" />
						</div>
					</div>

					<div class="weui-cells__title">统计图展示</div>
					<div class="weui-cells weui-cells_form" style ="text-align:center">
						<div class="weui-cell">
							<div class="weui-cell__bd" >
								<textarea class="weui-textarea" id="show" name="ansshow"> </textarea>
								<div id="main" style="width: 600px; height: 400px; margin:20px auto"></div>


							</div>

						</div>
					</div>

				</div>



			</div>


		</div>
	</div>

	</div>

</body>


<script type="text/javascript"
	src="http://g.alicdn.com/msui/sm/0.6.2/js/sm.js" charset="utf-8"></script>
<script type="text/javascript"
	src="http://g.alicdn.com/msui/sm/0.6.2/js/sm-extend.js" charset="utf-8"></script>

<script src="/network/js/jquery.min.js"></script>
<script src="/network/js/echarts.common.min.js"></script>
<script type="text/javascript" src="/network/js/answer.js"></script>
<script type="text/javascript">
	// 基于准备好的dom，初始化echarts实例
	var myChart = echarts.init(document.getElementById('main'));

	// 指定图表的配置项和数据
	option = {
		title : {
			text : '回答情况统计',
			x : 'center'
		},
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b} : {c} ({d}%)"
		},
		legend : {
			orient : 'vertical',
			left : 'left',
			data : [ '正确', '错误' ]
		},
		series : [ {

			type : 'pie',
			radius : '55%',
			center : [ '50%', '60%' ],
			data : [ {
				value : "${correct}",
				name : '正确'
			}, {
				value : "${wrong}",
				name : '错误'
			} ],
			itemStyle : {
				emphasis : {
					shadowBlur : 10,
					shadowOffsetX : 0,
					shadowColor : 'rgba(0, 0, 0, 0.5)'
				}
			}
		} ]
	};

	// 使用刚指定的配置项和数据显示图表。
	myChart.setOption(option);
</script>
</html>


