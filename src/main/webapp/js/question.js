var _config;

$(document).ready(function () {

    $('#btnSubmit').click(function () {
        Submit();
    })

});

function Submit() {

    if ($("#question").val().trim() == "") {
        alert("请输入问题")
        return false;
    }

   var question=$("#question").val();
   var answer=$("#answer").val();
   var cId=$("#cId").val();
   var teacher_id = 1 ;
   var status = "0";

    $.ajax({
        // url: _ctx + '/question/add.do',   http://47.100.116.100/network/question/add.do
        url:'./add.do',
        type: 'POST',
        dataType: "JSON",
        contentType: "application/x-www-form-urlencoded;charset=utf-8",
        data: {cId:cId,question:question,answer:answer,status:status},
        success: function (data) {
            console.log(data)
        },
        error: function (request) {
            console.error()
            alert('提交成功');
        }
    });

}
