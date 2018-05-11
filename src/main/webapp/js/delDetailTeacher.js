$(document).ready(function () {

    $("#btnDel").click(function () {
        var id = document.getElementById("tNumber").innerText;
        var msg = "您真的确定要删除吗？";
            if (confirm(msg)==true){
                Delete(id);
            }
    })


});

function Delete(id) {
    $.ajax({
        // url: _ctx + '/question/add.do',   http://47.100.116.100/network/question/add.do
        url:'./del.do',
        type: 'POST',
        dataType: "JSON",
        contentType: "application/x-www-form-urlencoded;charset=utf-8",
        data: {tNumber: id},
        success: function (data) {
            console.log("success")
            console.log(data)
            if (data.message == "success") {
                //alert("删除成功");
                location.href ="./teacherlist.do";
            } else {
                //alert(info.msg)
            }


        },
        error: function (data) {
            console.log("why")
            console.log(data)
            console.error()
            alert('fail: 删除失败');
        }
    });

}