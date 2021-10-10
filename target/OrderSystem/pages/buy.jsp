<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no"/>
    <title>饿麻了在线订餐服务——快来订餐吧！！！</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
     <link rel="stylesheet" href="${pageContext.request.contextPath}/css/fonts.googleapis.com.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/fonts/fontawesome-all.min.css"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <link href="${pageContext.request.contextPath}/images/bitbug_favicon.ico" rel="icon" type="image/x-ico">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/InputSpinner.js" type="text/javascript"></script>
    <style>
        .wit dd p span {
            color: #9e9e9e;
        }

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
            transform: translate(-50%, -50%);
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
    <div class="row">
        <div class="col-sm-12" style="font-size: 24px;margin-top: 40px;">
            <span>您现在的位置：</span>
            <a href="${pageContext.request.contextPath}/indexInfo/findIndexAll">&nbsp;<span>首页</span>&nbsp;</a><span>></span>&nbsp;
            <a href="${pageContext.request.contextPath}/dishes/browsePro">&nbsp;<span>订餐</span>&nbsp;</a><span>></span>&nbsp;
            <span>${requestScope.dishes.dishes_name}</span>
        </div>
    </div>

    <div class="row" style="margin-top: 40px;">
        <div class="col-sm-5">
            <img src="${pageContext.request.contextPath}/images/foodImg/${dishes.dishes_photo}" class="img-thumbnail"
                 alt="Cinque Terre" style="width: 500px;height: 333px" >
        </div>
        <div class="col-sm-4">
            <dl class="wit">
                <dt style="color: #0073ee;font-size: 24px;">
                    <p>${dishes.dishes_name}</p>
                </dt>
                <dd class="border border-left-0 border-right-0">
                    ${dishes.dishes_des}

                </dd>

                <dd>
                    <p><span>价格：</span><input type="text" readonly value="${dishes.dishes_price}"
                                              class="border-0 font-weight-bolder"
                                              style="color: #f03b0e;font-size: 20px;"></p>
                </dd>
                <dd>
                    <p><span>月销量：</span>${dishes.dishes_sales}</p>
                </dd>
                <dd>
                    <p><span>积分：</span>${dishes.dishes_price*10}</p>
                </dd>
            </dl>
            <div style="text-align: center">
                <input type = "hidden" id = "dishesId" value="${dishes.dishes_id}">
                <a id="addCart" class = "mr-5 mt-5">
                    <button type="button" class="btn btn-primary" style="width: 150px;">加入购物车</button>
                </a>

            </div>
        </div>
    </div>

    <div style="margin-top: 50px;"></div>


    <div class="row">
        <div class="col-sm-12">
            <h3 class="card-title text-center"><a class="nav-link" href="#"><i class="bi bi-hand-thumbs-up"
                                                                               style="font-size: 2.5rem; color: cornflowerblue;"></i>推荐</a>
            </h3>
            <h5 class="card-subtitle mb-2 text-muted text-center">为您推荐最近好评度爆炸的美食</h5>
        </div>

        <c:forEach items="${introList}" var="introList">
            <div class="col-sm-4">
                <div class="card" style="width: 18rem;margin-top: 20px;">
                    <img src="${pageContext.request.contextPath}/images/foodImg/${introList.dishes_photo}" alt="..."
                         class="imgSizeControll">
                    <div class="card-body">
                        <input type="hidden" name="dishesId" class="dishesId" value="${ introList.dishes_id}">
                        <h3>${introList.dishes_name}</h3>
                        <div class="col-20 text-truncate">
                                ${introList.dishes_des}
                        </div>
                        <div style="color: red;">
                            价格：${introList.dishes_price}
                            <span style="float: right">销量：${introList.dishes_sales}</span>
                        </div>
                        <p style="text-align: center"><a
                                href="${pageContext.request.contextPath}/dishes/buyProduction?productionId=${introList.dishes_id}&productionCate=${introList.dishes_cate}"
                                class="btn btn-primary" role="button" style="width: 100px;">购买</a>
                            <a style="float: right;" class="addCart"><i class="bi bi-cart-plus"
                                                                        style="font-size: 1.4rem; color: #01B6FD;"></i></a>
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>

    </div>
</div>


<!-- footer -->
<jsp:include page="userFooter.jsp"></jsp:include>
<!-- footer -->

<!-- 回到顶部引入 -->
<a class="border rounded d-inline scroll-to-top" href="#page-top"><i class="fas fa-angle-up"></i></a>
<!-- 回到顶部引入 -->
</body>
<script type="text/javascript">
    $("input[type='number']").InputSpinner()
    $("input.small").InputSpinner({
        groupClass: "input-group-sm"
    })
    $("input.large").InputSpinner({
        groupClass: "input-group-lg"
    })
</script>

<script>
    $("a.addCart").click(function () {
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
        $("#addCart").click(function () {
            var dishesId = $(this).parent("div").children("#dishesId").val();

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
