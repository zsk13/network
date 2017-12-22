$(document).ready(function () {
    $('#searchInput').bind('keypress',function(event){

        if(event.keyCode == "13")

        {
            console.log('你输入的内容为：' + $('#searchInput').val());
            $('#searchInput').focus();
            location.href="./detailteacher.do?name="+$('#searchInput').val();

        }

    });
});
