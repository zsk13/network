$(document).ready(function () {

    $('#btnEdit').click(function () {
        var a=document.getElementById("tNumber").innerText;
        var url = "./editteacher.do?id=" + a;
        location.href = url;
    })

    $('#btnReturn').click(function () {
        Home();
    })


});

function Home() {
    location.href ="./teacherlist.do";
}