<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>饿麻了在线订餐服务——快来订餐吧！！！</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
     <link rel="stylesheet" href="${pageContext.request.contextPath}/css/fonts.googleapis.com.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/fonts/fontawesome-all.min.css">
    <link href="${pageContext.request.contextPath}/images/bitbug_favicon.ico" rel="icon" type="image/x-ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Features-Boxed.css">
</head>
<body id="page-top">
<div id="wrapper">

    <%--引入nav导航栏--%>
    <jsp:include page="leftNav.jsp"></jsp:include>
    <%--引入nav导航栏--%>

    <div class="d-flex flex-column" id="content-wrapper">
        <div id="content">

            <%--引入userNav头部导航栏--%>
            <jsp:include page="shopNav.jsp"></jsp:include>
            <%--引入userNav头部导航栏--%>

            <div class="container-fluid">
                <div class="d-sm-flex justify-content-between align-items-center mb-4">
                    <h3 class="text-dark mb-0">订单详情</h3>
                </div>
                <div class="card shadow">
                    <div class="card-body">
                        <div class="table-responsive table mt-2" id="dataTable" role="grid" aria-describedby="dataTable_info">
                            <table class="table my-0">
                                <thead>
                                <tr>
                                    <th>菜名</th>
                                    <th>图片</th>
                                    <th>类型</th>
                                    <th>单价</th>
                                    <th>数量</th>
                                    <th>总价</th>
                                </tr>
                                </thead>

                                <tbody>
                                <c:forEach items="${requestScope.orderItemVOList}" var="orderItemVOList">
                                    <tr>
                                        <td>${orderItemVOList.dishes_name}</td>
                                        <td><img src="${pageContext.request.contextPath}/images/foodImg/${orderItemVOList.dishes_photo}" alt ="图片：${orderItemVOList.dishes_photo}" style="width:200px;height: 120px"></td>
                                        <td>${orderItemVOList.dishes_cate}</td>
                                        <td>${orderItemVOList.dishes_price}</td>
                                        <td>${orderItemVOList.orderitem_number}</td>
                                        <td>${orderItemVOList.orderitem_money}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>

                            </table>
                        </div>
                        <div class="row">
                            <div class="col"></div>
                            <div class="col"></div>
                            <div class="col-xl-3 offset-xl-0">
                                <a role="button" href="${pageContext.request.contextPath}/orderInfo/findAllOrder"> <button class="btn btn-primary" type="button"
                                        style="margin-top: 20px;margin-left: 50px;">回到订单界面
                                </button></a>
                            </div>
                            <div class="col"></div>
                            <div class="col"></div>
                        </div>
                    </div>
                </div>
            </div>

                <jsp:include page="footer.jsp"></jsp:include>

        </div>



    </div>
    <a class="border rounded d-inline scroll-to-top" href="#page-top"><i class="fas fa-angle-up"></i></a>
</div>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src ="${pageContext.request.contextPath}/js/jquery.easing.js"></script>
<script src="${pageContext.request.contextPath}/js/theme.js"></script>
</body>
</html>