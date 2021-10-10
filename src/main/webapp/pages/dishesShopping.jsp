<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no" />
    <title>饿麻了在线订餐服务——快来订餐吧！！！</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
     <link rel="stylesheet" href="${pageContext.request.contextPath}/css/fonts.googleapis.com.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/fonts/fontawesome-all.min.css" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <link href="${pageContext.request.contextPath}/images/bitbug_favicon.ico" rel="icon" type="image/x-ico">
    <link rel="stylesheet"  href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <style>
        .imgSizeControll {
            width: 17.88rem;
            height: 200px;
        }
        .alert {
            display: none;
            position: fixed;
            top: 50%;
            left: 50%;
            min-width: 300px;
            max-width: 600px;
            transform: translate(-50%,-50%);
            z-index: 99999;
            text-align: center;
            padding: 20px;
            border-radius: 3px;
        }
    </style>
</head>
<body id="page-top">

<%--引入头部--%>
<jsp:include page="userNav.jsp"></jsp:include>
<%--引入头部--%>

<div class="container">

    <%--导航1--%>
    <div class="row" style="margin-top: 20px;">
        <div class="col-sm-12">
            <ul class="nav nav-pills mb-3 " id="pills-tab" role="tablist">
                <li class="nav-item border  bg-success rounded-pill shadow-sm" role="presentation">
                    <a class="nav-link" id="pills-deliciousFood-tab" href="${pageContext.request.contextPath}/dishes/browsePro?productionCate=菜类"
                        aria-selected="true">美食一览</a>
                </li>
                <li class="nav-item border bg-warning rounded-pill shadow-sm" role="presentation">
                    <a class="nav-link" id="pills-fruit-tab"  href="${pageContext.request.contextPath}/dishes/browsePro?productionCate=水果类"
                       aria-selected="false">水果狂欢</a>
                </li>
                <li class="nav-item border bg-secondary rounded-pill shadow-sm" role="presentation">
                    <a class="nav-link" id="pills-tea-tab"  href="${pageContext.request.contextPath}/dishes/browsePro?productionCate=奶茶类"
                       aria-selected="false">可口奶茶</a>
                </li>
                <li class="nav-item border bg-info rounded-pill shadow-sm" role="presentation">
                    <a class="nav-link" id="pills-desserts-tab"  href="${pageContext.request.contextPath}/dishes/browsePro?productionCate=甜点类"
                       aria-selected="false">甜点小吃</a>
                </li>
            </ul>

        </div>

    </div>
    <%--导航1--%>

    <%--导航2--%>
    <div class="row">
        <div class="col-sm-12">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/dishes/browsePro?productionCate=${requestScope.productionCate}">默认</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <input type="hidden" value="${requestScope.oderByKw}" id = "oderByKw">
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item dropdown active">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownPrice" role="button"
                               data-toggle="dropdown" aria-expanded="false">
                                价格
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/dishes/browsePro?productionCate=${requestScope.productionCate}&oderByKw=价格升&searchKw=${requestScope.kw}">价格<i class="bi bi-arrow-up"></i></a>
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/dishes/browsePro?productionCate=${requestScope.productionCate}&oderByKw=价格降&searchKw=${requestScope.kw}">价格<i class="bi bi-arrow-down"></i></a>
                            </div>
                        </li>

                        <li class="nav-item active">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownSales" role="button"
                               data-toggle="dropdown" aria-expanded="false">
                                销量
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/dishes/browsePro?productionCate=${requestScope.productionCate}&oderByKw=销量升&searchKw=${requestScope.kw}">销量<i class="bi bi-arrow-up"></i></a>
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/dishes/browsePro?productionCate=${requestScope.productionCate}&oderByKw=销量降&searchKw=${requestScope.kw}">销量<i class="bi bi-arrow-down"></i></a>
                            </div>

                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">我的积分:(${sessionScope.userInfo.user_integral})</a>
                        </li>
                    </ul>
                    <form action="${pageContext.request.contextPath}/dishes/browsePro" method="get" class="form-inline my-2 my-lg-0">
                        <input type="hidden" value="${requestScope.productionCate}" name="productionCate" id = "productionCate">
                        <input class="form-control mr-sm-2" type="search" placeholder="输入关键词查询..."
                            value = "${requestScope.kw}"   name = "searchKw" id = "searchKw" aria-label="Search">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">搜索</button>
                    </form>
                </div>
            </nav>
        </div>
    </div>
    <%--导航2--%>

    <%-- 循环遍历部分--%>
    <div class="row">
        <c:forEach items="${pageInfo.list}" var="dishesList">
        <div class="col-sm-4">
            <div class="card" style="width: 18rem;margin-top: 20px;">
                <img src="${pageContext.request.contextPath}/images/foodImg/${dishesList.dishes_photo}" alt="..." class="imgSizeControll">
                <div class="card-body">
                    <input type="hidden" name = "dishesId" class =  "dishesId" value="${ dishesList.dishes_id}">
                    <h3>${ dishesList.dishes_name}</h3>
                    <div class="col-20 text-truncate">
                            ${dishesList.dishes_des}
                    </div>
                    <div style="color: red;">
                        价格：${dishesList.dishes_price}
                        <span style="float: right">销量：${dishesList.dishes_sales}</span>
                    </div>
                    <input type="hidden" value="${dishesList.dishes_cate}" id = "dishesCate" name  = "dishesCate">
                    <p style="text-align: center"><a href="${pageContext.request.contextPath}/dishes/buyProduction?productionId=${dishesList.dishes_id}&productionCate=${dishesList.dishes_cate}" class="btn btn-primary" role="button" style="width: 100px;">购买</a>
                        <a  style="float: right;" class = "addCart"><i class="bi bi-cart-plus"
                                                                       style="font-size: 1.4rem; color: #01B6FD;"></i></a></p>
                </div>
            </div>
        </div>
        </c:forEach>
    </div>

    <%-- 循环遍历部分--%>

        <%--引入pageNav导航--%>
        <jsp:include page="pageNav.jsp"></jsp:include>
        <%--引入pageNav导航--%>
</div>
        <!-- footer -->
        <jsp:include page="userFooter.jsp"></jsp:include>
        <!-- footer -->
<!-- 回到顶部引入 -->
<a class="border rounded d-inline scroll-to-top" href="#page-top"><i class="fas fa-angle-up"></i></a>
<!-- 回到顶部引入 -->
</body>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script>
    $(document).ready(function (){

        <%--layuiPage JS模块--%>
        layui.use(['laypage', 'layer'], function(){
            var laypage = layui.laypage;
            // layer = layui.layer;

            //完整功能
            laypage.render({
                elem: 'layuipager'
                // yj  这里是你想显示在界面上的总数据,分页 *页数
                ,count: ${pageInfo.total}
                ,page: true
                ,curr: ${pageInfo.pageNum},//这个是你当前的页数，设置好 页面跳转后他会自动选择对应的页码、也就是第几页的背景改变颜色
                limit : ${pageInfo.pageSize},//这个是每页面显示多少条，页面跳转后他会自动让下拉框里对应的值设为选中状态
                limits: [5,10,15,20],//这个是下拉框里显示的option
                layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip','first','last'],
                jump: function(obj,first){
                    console.log(obj.curr);
                    console.log(obj.limit);
                    console.log(obj.href);
                    if (first) {
                        return;
                    }
                    //跳转到对应的页面
                    var url = '?pageNum='+obj.curr+'&pageSize='+obj.limit;
                    var kw = $("#searchKw").val();
                    var productionCate = $("#productionCate").val();
                    var oderByKw = $("#oderByKw").val();
                    url += "&productionCate="+productionCate;
                    url += "&oderByKw="+oderByKw;
                    if(typeof(kw) == undefined){

                    }else{
                        url += "&searchKw="+kw;
                    }
                    window.location.href = url;
                }
            });
        });

    });
</script>

<script>
    $("a.addCart").click(function(){
        $('<div>').appendTo('body').addClass('alert alert-success').html('加入成功').show().delay(200).fadeOut();
    })
</script>

<script>
    $(document).ready(function () {
        $(".addCart").click(function () {
            var dishesId = $(this).parents("div.card-body").children(".dishesId").val();
            $.ajax({
                type: 'post',
                url: "${pageContext.request.contextPath}/cartInfo/addCart",//action方式
                data: {dishesId: dishesId}, //参数，如果参数多，可用date后跟一个大括号
                dataType: 'json',
                success: function (totalCounts) {//回调函数

                    console.log(totalCounts);
                    $("#totalCounts").text(totalCounts);
                }
            });
        });

    });

</script>

</html>
