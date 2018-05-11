$(document).ready(function () {

    $('#btnUpdate').click(function () {
        var url=location.href;
        var i=url.indexOf('=');
        var id=url.substr(i+1);
        var msg = "确认提交？";
        if (confirm(msg)==true){
            Update(id);
        }

    })

    $('#btnReturn').click(function () {
        Home();
    })

});

function Update(id) {

    if ($("#tName").val().trim() == "") {
        alert("请输入姓名")
        return false;
    }

    if ($("#tPassword").val().trim() == "") {
        alert("请输入密码")
        return false;
    }

    if ($("#tNumber").val().trim() == "") {
        alert("请输入工号")
        return false;
    }

    if ($("#tMail").val().trim() == "") {
        alert("请输入邮箱")
        return false;
    }

    if ($("#tPhone").val().trim() == "") {
        alert("请输入手机号")
        return false;
    }


    var name=$("#tName").val();
    var password=$("#tPassword").val();
    var number=$("#tNumber").val();
    var mail=$("#tMail").val();
    var phone=$("#tPhone").val();


    $.ajax({
        // url: _ctx + '/question/add.do',   http://47.100.116.100/network/question/add.do
        url:'./update.do',
        type: 'POST',
        dataType: "JSON",
        contentType: "application/x-www-form-urlencoded;charset=utf-8",
        data: {tName: name,tPassword: password,tNumber: number,tMail: mail,tPhone: phone,tid:id},
        success: function (data) {
            console.log("success")
            console.log(data)
            if (data.message == "success") {
                //alert("编辑成功");
                location.href ="./teacherlist.do";
            } else {
                //alert(info.msg)
            }


        },
        error: function (data) {
            console.log("why")
            console.log(data)
            console.error()
            alert('fail: 编辑失败');
        }
    });

}

function Home() {
    location.href ="./teacherlist.do";
}

