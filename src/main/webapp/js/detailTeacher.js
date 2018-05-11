$(document).ready(function () {
    var url=decodeURI(location.href);
    var i=url.indexOf('=');
    var name=url.substr(i+1);
    Detail(name);
});

function Detail(name) {

    $.ajax({
        // url: _ctx + '/question/add.do',   http://47.100.116.100/network/question/add.do
        url:'./detail.do',
        type: 'POST',
        dataType: "JSON",
        contentType: "application/x-www-form-urlencoded;charset=utf-8",
        data: {tName: name},
        success: function (data) {
            console.log(data);

            var name=$("#tName");
            var password=$("#tPassword");
            var number=$("#tNumber");
            var mail=$("#tMail");
            var phone=$("#tPhone");
            name.html(data.name);
            password.html(data.password);
            number.html(data.number);
            mail.html(data.mail);
            phone.html(data.phone);

            console.log("success")
        },
        error: function (data) {
            console.log("no this people");
            console.log(data);
            alert('不好意思哦，这个老师被外星人绑架了');
            location.href ="./teacherlist.do";
        }
    });

}


