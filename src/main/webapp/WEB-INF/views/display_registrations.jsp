<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>点名列表</title>
    <link href="../css/example.css" rel='stylesheet' type='text/css'/>
    <link href="../css/weui.css" rel='stylesheet' type='text/css'/>
    <style>
        @
        -moz-keyframes nodeInserted {

        from {
            opacity: 0.99;
        }

        to {
            opacity: 1;
        }

        }
        @
        -webkit-keyframes nodeInserted {

        from {
            opacity: 0.99;
        }

        to {
            opacity: 1;
        }

        }
        @
        -o-keyframes nodeInserted {

        from {
            opacity: 0.99;
        }

        to {
            opacity: 1;
        }

        }
        @
        keyframes nodeInserted {

        from {
            opacity: 0.99;
        }

        to {
            opacity: 1;
        }

        }
        embed, object {
            animation-duration: .001s;
            -ms-animation-duration: .001s;
            -moz-animation-duration: .001s;
            -webkit-animation-duration: .001s;
            -o-animation-duration: .001s;
            animation-name: nodeInserted;
            -ms-animation-name: nodeInserted;
            -moz-animation-name: nodeInserted;
            -webkit-animation-name: nodeInserted;
            -o-animation-name: nodeInserted;
        }
    </style>
</head>
<body>
<div class="container" id="container">
    <div class="page home js_show">
        <div class="page list js_show">
            <div class="page__bd">
                <div class="weui-cells__title">点名列表</div>
                <div class="weui-cells">
                    <c:forEach var="registration" items="${registrationList}">
                        <div class="weui-cell weui-cell_access">
                            <div class="weui-cell__bd">
                                <a href="../manage/display_registration_records.do?registrationId=${registration.rId }"
                                   style="height: 50px; font-size: medium;">
                                    <fmt:formatDate value="${registration.sTime}" type="date"/>日 <c:out
                                        value="${registration.cName}"/>点名
                                </a>
                            </div>
                            <div class="weui-cell__ft" style="font-size: 0">
								<span style="vertical-align: middle; font-size: 17px;">

										 <a class="del-btn weui-btn weui-btn_mini weui-btn_warn"
                                            id="${registration.rId}"
                                            href="javascript:;">删除点名</a>
								</span>
                            </div>

                        </div>
                    </c:forEach>
                </div>

                <div class="button-sp-area">

                    <a href="./display_registrations.do?pageNo=${currentPage-1}"
                       class="weui-btn weui-btn_mini weui-btn_primary">上一页</a>
                    <a href="./display_registrations.do?pageNo=${currentPage+1}"
                       class="weui-btn weui-btn_mini weui-btn_primary">下一页</a>
                    <a href="javascript:;"
                       class="weui-btn weui-btn_mini weui-btn_default">共${totalPage}页，当前第${currentPage}页</a>

                </div>
            </div>
        </div>
    </div>

</div>
</body>
<script src="../js/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {

        $('.del-btn').click(function () {
            var id = $(this).attr('id');
            var msg = "确定要删除吗？";
            if (confirm(msg) == true) {
                Delete(id);
            }
        })


    });

    function Delete(id) {
        $.ajax({
            url: './delete.do',
            type: 'POST',
            dataType: "JSON",
            contentType: "application/x-www-form-urlencoded;charset=utf-8",
            data: {rId: id},
            //console.log(data);
            success: function (data) {
                //alert("Here is success");
                //console.log("success")
                //console.log(data)
                if (data.message == "success") {
                    alert("删除成功");
                    location.href = "./display_registrations.do";
                } else {
                    //alert(info.msg)
                }


            },
            error: function (data) {
                console.log("deletion failed?");
                console.log(data);
                //console.error()
                alert('fail: 删除失败');
            }
        });

    }
</script>
</html>