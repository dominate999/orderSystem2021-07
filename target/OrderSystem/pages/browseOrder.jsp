<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no" />
    <title>饿麻了在线订餐服务——快来订餐吧！！！</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <link href="${pageContext.request.contextPath}/images/bitbug_favicon.ico" rel="icon" type="image/x-ico">

    <style type="text/css">
        .imgSizeControll {
            width: 120px;
            height: 100px;

        }
    </style>
</head>
<body>
<%--引入头部--%>
<jsp:include page="userNav.jsp"></jsp:include>
<%--引入头部--%>
<div style="margin-top: 80px;"></div>

<div class="container">
    <div class="row clearfix">

        <%--引入用户信息左侧导航栏--%>
        <jsp:include page="userInfoLeftNav.jsp"></jsp:include>
        <%--引入用户信息左侧导航栏--%>

        <div class="col-md-9 column">
            <table class="table">
                <thead style="background-color: #0D62B2;color: white;">
                <tr>
                    <th style="vertical-align: middle !important;text-align: center;">
                        菜名
                    </th>
                    <th style="vertical-align: middle !important;text-align: center;">
                        图片
                    </th>
                    <th style="vertical-align: middle !important;text-align: center;">
                        单价
                    </th>
                    <th style="vertical-align: middle !important;text-align: center;">
                        数量
                    </th>
                    <th style="vertical-align: middle !important;text-align: center;">
                        总价
                    </th>
                </tr>
                </thead>
                <c:forEach items="${orderItemVOList}" var="orderItemVOList">
                    <tbody>
                    <tr class="border">
                        <td style="vertical-align: middle !important;text-align: center;">
                                ${orderItemVOList.dishes_name}
                        </td>
                        <td style="vertical-align: middle !important;text-align: center;">
                               <img src="${pageContext.request.contextPath}/images/foodImg/${orderItemVOList.dishes_photo}"  class="imgSizeControll">
                        </td>
                        <td style="vertical-align: middle !important;text-align: center;">
                                ${orderItemVOList.dishes_price}
                        </td>
                        <td style="vertical-align: middle !important;text-align: center;">
                                ${orderItemVOList.orderitem_number}
                        </td>
                        <td style="vertical-align: middle !important;text-align: center;">
                                ${orderItemVOList.orderitem_money}
                        </td>

                    </tr>
                    </tbody>
                </c:forEach>
            </table>
            <a href="${pageContext.request.contextPath}/orderInfo/findUserOrder?userId=${sessionScope.userInfo.user_id}"><button type="button" class="btn btn-primary">返回</button></a>
        </div>
    </div>
</div>





<!-- footer -->
<jsp:include page="userFooter.jsp"></jsp:include>
<!-- footer -->


</body>
</html>
