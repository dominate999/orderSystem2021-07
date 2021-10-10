<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no"/>
    <title>饿麻了在线订餐服务——快来订餐吧！！！</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Features-Boxed.css"/>
     <link rel="stylesheet" href="${pageContext.request.contextPath}/css/fonts.googleapis.com.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/fonts/fontawesome-all.min.css"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <link href="${pageContext.request.contextPath}/images/bitbug_favicon.ico" rel="icon" type="image/x-ico">
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


<div style="background: -webkit-linear-gradient(top,#efefef,#bfdcda);">
    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="${pageContext.request.contextPath}/images/indexpic2.jpg" class="d-block w-100"
                                 alt="...">
                        </div>
                        <div class="carousel-item">
                            <img src="${pageContext.request.contextPath}/images/indexpic1.jpeg" class="d-block w-100"
                                 alt="...">
                        </div>
                        <div class="carousel-item">
                            <img src="${pageContext.request.contextPath}/images/indexpic3.jpg" class="d-block w-100"
                                 alt="...">
                        </div>
                    </div>
                    <button class="carousel-control-prev" type="button" data-target="#carouselExampleIndicators"
                            data-slide="prev" style="background-color: rgba(0,0,0,0); border: 1px;">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-target="#carouselExampleIndicators"
                            data-slide="next" style="background-color: rgba(0,0,0,0); border: 1px;">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <h3 class="card-title text-center "><a class="nav-link" href="#"><i class="bi bi-hand-thumbs-up"
                                                                               style="font-size: 2.5rem; color: cornflowerblue;"></i>用户好评</a>
            </h3>

        </div>

        <ul class="list-unstyled">
            <c:forEach items="${evaInfoVOList}" var="evaInfoVO" begin="0" end="2">
                <div class="col-md-12">
                    <div class="shadow-lg p-3 mb-3 bg-white rounded" style="width: 1095px;;">
                        <li class="media">
                            <img src="${pageContext.request.contextPath}/images/${evaInfoVO.user_photo}" class="mr-3"
                                 alt="..." style="width: 64px;height: 64px">
                            <div class="media-body">
                                <h5 class="mt-0 mb-1">${evaInfoVO.user_account} <span
                                        style="float: right">${evaInfoVO.eva_time}</span></h5>
                                <p>${evaInfoVO.eva_content}</p>
                                <p style="text-align:right;">${evaInfoVO.user_addressed}</p>
                                <span style="float:right;color: #f70000">好评度：${evaInfoVO.eva_degree}</span>

                            </div>
                        </li>
                    </div>
                </div>
            </c:forEach>
        </ul>

    </div>

    <div class="row">
        <div class="col-sm-12">
            <h3 class="card-title text-center"><a href="${pageContext.request.contextPath}/dishes/browsePro?productionCate=菜类"><img
                    src="${pageContext.request.contextPath}/images/mainfood.png" width="80px"
                    height="80px">美食热推</a></h3>
            <h5 class="card-subtitle mb-2 text-muted text-center">为您推荐最近好评度爆炸的美食</h5>
        </div>

        <c:forEach items="${ foodList}" var="foodList">
            <div class="col-sm-4">
                <div class="card " style="width: 18rem;margin-top: 20px;">

                    <img src="${pageContext.request.contextPath}/images/foodImg/${foodList.dishes_photo}" alt="..."
                         class="imgSizeControll" >
                    <div class="card-body">
                        <input type="hidden" name="dishesId" class="dishesId" value="${ foodList.dishes_id}">
                        <h3>${foodList.dishes_name}</h3>

                        <div class="col-20 text-truncate">
                                ${foodList.dishes_des}
                        </div>
                        <div style="color: red;">
                            价格：${foodList.dishes_price}
                            <span style="float: right">销量：${foodList.dishes_sales}</span>
                        </div>
                        <p style="text-align: center">
                            <a href="${pageContext.request.contextPath}/dishes/buyProduction?productionId=${foodList.dishes_id}&productionCate=${foodList.dishes_cate}"
                               class="btn btn-primary" role="button" style="width: 100px;">购买</a>
                            <a style="float: right;" class="addCart"><i class="bi bi-cart-plus"
                                                                        style="font-size: 1.4rem; color: #01B6FD;"></i></a>
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>

    </div>

    <div class="row">
        <div class="col-sm-12">
            <h3 class="card-title text-center"><a href="${pageContext.request.contextPath}/dishes/browsePro?productionCate=水果类"><img
                    src="${pageContext.request.contextPath}/images/fruit.png" width="80px"
                    height="80px">水果热推</a></h3>
            <h5 class="card-subtitle mb-2 text-muted text-center">为您推荐最近好评度爆炸的美食</h5>
        </div>

        <c:forEach items="${ fruitList}" var="fruitList">
            <div class="col-sm-4">
                <div class="card" style="width: 18rem;margin-top: 20px;">
                    <img src="${pageContext.request.contextPath}/images/foodImg/${fruitList.dishes_photo}" alt="..."
                         class="imgSizeControll">
                    <div class="card-body">
                        <input type="hidden" name="dishesId" class="dishesId" value="${ fruitList.dishes_id}">
                        <h3>${fruitList.dishes_name}</h3>
                        <div class="col-20 text-truncate">
                                ${fruitList.dishes_des}
                        </div>
                        <div style="color: red;">
                            价格：${fruitList.dishes_price}
                            <span style="float: right">销量：${fruitList.dishes_sales}</span>
                        </div>
                        <p style="text-align: center"><a
                                href="${pageContext.request.contextPath}/dishes/buyProduction?productionId=${fruitList.dishes_id}&productionCate=${fruitList.dishes_cate}"
                                class="btn btn-primary" role="button"
                                style="width: 100px;">购买</a>
                            <a style="float: right;" class="addCart"><i class="bi bi-cart-plus"
                                                                        style="font-size: 1.4rem; color: #01B6FD;"></i></a>
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <div class="row">
        <div class="col-sm-12">
            <h3 class="card-title text-center"><a href="${pageContext.request.contextPath}/dishes/browsePro?productionCate=奶茶类"><img
                    src="${pageContext.request.contextPath}/images/drink.png" width="80px"
                    height="80px">奶茶热推</a></h3>
            <h5 class="card-subtitle mb-2 text-muted text-center">为您推荐最近好评度爆炸的美食</h5>
        </div>

        <c:forEach items="${ drinkList}" var="drinkList">
            <div class="col-sm-4">
                <div class="card" style="width: 18rem;margin-top: 20px;">
                    <img src="${pageContext.request.contextPath}/images/foodImg/${drinkList.dishes_photo}" alt="..."
                         class="imgSizeControll">
                    <div class="card-body">
                        <input type="hidden" name="dishesId" class="dishesId" value="${ drinkList.dishes_id}">
                        <h3>${ drinkList.dishes_name}</h3>

                        <div class="col-20 text-truncate">
                                ${ drinkList.dishes_des}
                        </div>
                        <div style="color: red;">
                            价格：${drinkList.dishes_price}
                            <span style="float: right">销量：${drinkList.dishes_sales}</span>
                        </div>
                        <p style="text-align: center">
                            <a href="${pageContext.request.contextPath}/dishes/buyProduction?productionId=${drinkList.dishes_id}&productionCate=${drinkList.dishes_cate}"
                               class="btn btn-primary" role="button" style="width: 100px;">购买</a>
                            <a style="float: right;" class="addCart"><i class="bi bi-cart-plus"
                                                                        style="font-size: 1.4rem; color: #01B6FD;"></i></a>
                        </p>
                    </div>
                </div>
            </div>

        </c:forEach>

    </div>

    <div class="row">
        <div class="col-sm-12">
            <h3 class="card-title text-center"><a href="${pageContext.request.contextPath}/dishes/browsePro?productionCate=类"><img
                    src="${pageContext.request.contextPath}/images/eating.png" width="80px"
                    height="80px">甜品热推</a></h3>
            <h5 class="card-subtitle mb-2 text-muted text-center">为您推荐最近好评度爆炸的美食</h5>
        </div>

        <c:forEach items="${ dessertList}" var="dessertList">
            <div class="col-sm-4">
                <div class="card" style="width: 18rem;margin-top: 20px;">
                    <img src="${pageContext.request.contextPath}/images/foodImg/${dessertList.dishes_photo}" alt="..."
                         class="imgSizeControll">
                    <div class="card-body">
                        <input type="hidden" name="dishesId" class="dishesId" value="${ dessertList.dishes_id}">
                        <h3>${ dessertList.dishes_name}</h3>
                        <div class="col-20 text-truncate">
                                ${ dessertList.dishes_des}
                        </div>
                        <div style="color: red;">
                            价格：${dessertList.dishes_price}
                            <span style="float: right">销量：${dessertList.dishes_sales}</span>
                        </div>
                        <p style="text-align: center">
                            <a href="${pageContext.request.contextPath}/dishes/buyProduction?productionId=${dessertList.dishes_id}&productionCate=${dessertList.dishes_cate}"
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
<script src ="${pageContext.request.contextPath}/js/jquery.easing.js"></script>
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
    });
</script>
</html>
