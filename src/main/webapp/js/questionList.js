$(function(){ 
	$.ajax({
        // url: _ctx + '/question/add.do',   http://47.100.116.100/network/question/add.do
        url:'./add.do',
        type: 'POST',
        dataType: "JSON",
        contentType: "application/x-www-form-urlencoded;charset=utf-8",
        data: {teacher_id:teacher_id,question:question,answer:answer,status:status},
        success: function (data) {
            console.log(data)
            var info = JSON.parse(data);
            if (info.success) {
               alert("提交成功");
            } else {
                //alert(info.msg)
            }

        },
        error: function (request) {
            console.error()
            alert('fail: 提交失败');
        }
    }); 
}); 