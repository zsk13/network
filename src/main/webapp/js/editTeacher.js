$(document).ready(function () {
    var url=location.href;
    var i=url.indexOf('=');
    var id=url.substr(i+1);
    Edit(id);

});

function Edit(id) {

    $.ajax({
        // url: _ctx + '/question/add.do',   http://47.100.116.100/network/question/add.do
        url:'./edit.do',
        type: 'POST',
        dataType: "JSON",
        contentType: "application/x-www-form-urlencoded;charset=utf-8",
        data: {tNumber: id},
        success: function (data) {
            console.log(data)
            var name = document.getElementById("tName");
            name.value = data.name;
            var password = document.getElementById("tPassword");
            password.value = data.password;
            var number = document.getElementById("tNumber");
            number.value = data.number;
            var mail = document.getElementById("tMail");
            mail.value = data.mail;
            var phone = document.getElementById("tPhone");
            phone.value = data.phone;
            console.log("success")
        },
        error: function (data) {
            console.log("why")
            console.log(data)
            console.error()
            alert('fail: 编辑失败');
        }
    });

}
