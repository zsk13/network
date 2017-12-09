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

    if ($("#answer").val().trim() == "") {
        alert("请输入答案")
        return false;
    }


   var question=$("#question").val();
   var answer=$("#answer").val();

    $.ajax({
        url: _ctx + '/question/add.do',
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
                alert(info.msg)
            }

        },
        error: function (request) {
            console.error(xhr)
            alert('fail: 提交失败');
        }
    });

}