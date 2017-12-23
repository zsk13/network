$(document).ready(function () {

    $('#btnSubmit').click(function () {
        Submit();
    })

});

function Submit() {

    if ($("#sno").val().trim() == "") {
        alert("请输入学号");
        return false;
    }

    if ($("#sName").val().trim() == "") {
        alert("请输入姓名");
        return false;
    }

    var sno=$("#sno").val();
    var sName=$("#sName").val();

    $.ajax({
        // url: _ctx + '/question/add.do',   http://47.100.116.100/network/question/add.do
        url:'./add.do',
        type: 'POST',
        dataType: "JSON",
        contentType: "application/x-www-form-urlencoded;charset=utf-8",
        data: {sno: sno, sName: sName},
        success: function (data) {
            console.log(data)
            var info = JSON.parse(data);
            if (info.success) {
                alert("注册成功");
                // location.href ="/teacher/teacherlist.do";
            } else {
                //alert(info.msg)
            }

        },
        error: function (request) {
            console.error()
            alert('注册失败');
        }
    });

}