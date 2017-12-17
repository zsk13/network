
function publishQuestion(qid){
	$.ajax({
        // url: _ctx + '/question/add.do',   http://47.100.116.100/network/question/add.do
        url:'./publishQuestion.do',
        type: 'POST',
        dataType: "JSON",
        contentType: "application/x-www-form-urlencoded;charset=utf-8",
        data: {qid:qid},
        success: function (data) {
                location.reload(); 
        },
        error: function (data) {
                location.reload(); 
        },
        fail: function (data) {
            location.reload(); 
        }
    }); 
}