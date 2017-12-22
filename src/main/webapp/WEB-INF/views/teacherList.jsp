<%--
  Created by IntelliJ IDEA.
  User: 64167
  Date: 2017/12/21
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<meta http-equiv=Content-Type content="text/html;charset=utf-8">

<%--<script type="text/javascript" src="${ctx}/js/questionList.js"></script>--%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>

    <title>教师管理</title>

    <link rel="stylesheet"
          href="http://res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css" />

    <style type="text/css">
        .weui-input {
            text-align: right;
        }
    </style>

</head>

<body>

    <div class="page__bd">
        <div class="weui-tab">
            <div class="page__hd">
                <h1 class="page__title">教师管理</h1>
                <div class="weui-cell__ft">
                    <a href="./addteacher.do" class="weui-btn weui-btn_mini weui-btn_primary">添加教师</a>
                </div>
            </div>

            <div class="page__bd">
                <!--<a href="javascript:;" class="weui-btn weui-btn_primary">点击展现searchBar</a>-->
                <div class="weui-search-bar" id="searchBar">
                    <form class="weui-search-bar__form" style="height: 30px;" onsubmit="return false;">
                        <div class="weui-search-bar__box">
                            <i class="weui-icon-search"></i>
                            <input type="search" class="weui-search-bar__input" id="searchInput" placeholder="搜索" required="">
                            <a href="javascript:" class="weui-icon-clear" id="searchClear"></a>
                        </div>
                        <label class="weui-search-bar__label" id="searchText" style="transform-origin: 0px 0px 0px; opacity: 1; transform: scale(1, 1);">
                            <i class="weui-icon-search"></i>
                            <span>搜索</span>
                        </label>
                    </form>
                    <a href="javascript:" class="weui-search-bar__cancel-btn" id="searchCancel">取消</a>
                </div>
            </div>

            <div class="weui-cells">
                <c:forEach items="${ts }" var="t" >
                    <div class="weui-cell">
                        <div class="weui-cell__bd">
                            <div class="weui-cell">
                                <div class="weui-cell__bd" id="name">
                                    <p>${t.tName}</p>
                                </div>
                                <div class="weui-cell__ft" > <p>工号：${t.tNumber} 邮箱：${t.tMail} 电话：${t.tPhone}</p> </div>
                            </div>
                        </div>
                        <div class="weui-cell__ft">
                            <a href="./editteacher.do?id=${t.tNumber}" class="weui-btn weui-btn_mini weui-btn_primary">编辑</a>
                        </div>
                        <div class="weui-cell__ft">
                            <a href="javascript:;" class="del-btn weui-btn weui-btn_mini weui-btn_warn" id="${t.tNumber}">删除</a>

                        </div>
                    </div>
                </c:forEach>
            </div>

        </div>
    </div>
</div>

</div>

</body>
<script src="../js/jquery.min.js"></script>
<script src="../js/delTeacher.js"></script>
<script src="../js/seachTeacher.js"></script>
<script type="text/javascript" class="searchbar js_show">
    $(function(){
        var $searchBar = $('#searchBar'),
            $searchText = $('#searchText'),
            $searchInput = $('#searchInput'),
            $searchClear = $('#searchClear'),
            $searchCancel = $('#searchCancel');

        function cancelSearch(){
            // hideSearchResult();
            $searchBar.removeClass('weui-search-bar_focusing');
            $searchText.show();
        }

        $searchText.on('click', function(){
            $searchBar.addClass('weui-search-bar_focusing');
            $searchInput.focus();
        });


        $searchClear.on('click', function(){
            //hideSearchResult();
            $searchInput.focus();
        });
        $searchCancel.on('click', function(){
            cancelSearch();
            $searchInput.blur();
        });
    });</script>


</html>
