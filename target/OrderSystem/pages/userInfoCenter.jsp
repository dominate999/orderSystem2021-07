s<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</head>
<body>

<%--引入头部--%>
<jsp:include page="userNav.jsp"></jsp:include>
<%--引入头部--%>

<div style="margin-top: 80px;"></div>

<div class="container">
    <div class="row">

        <%--引入用户信息左侧导航栏--%>
        <jsp:include page="userInfoLeftNav.jsp"></jsp:include>
        <%--引入用户信息左侧导航栏--%>

        <div class="col-sm-2 border border-right-0">
            <img src="${pageContext.request.contextPath}/images/${sessionScope.userInfo.user_photo}" class="img-thumbnail" alt="Cinque Terre" width="154" height="106">
        </div>
        <div class="col-sm-7 border border-left-0" style="font-size: 20px;">

            <p class="border-bottom"><span class="font-weight-bolder">账号名：</span><span>${sessionScope.userInfo.user_account}</span></p>
            <p><span class="font-weight-bolder">姓名：</span><span>${sessionScope.userInfo.user_name}</span></p>

            <p><span class="font-weight-bolder">手机号：</span><span>${sessionScope.userInfo.user_phone}</span></p>
            <p><span class="font-weight-bolder">主地址：</span><span>${sessionScope.userInfo.user_addressed}</span></p>
            <p><span class="font-weight-bolder">密码：</span><span>${sessionScope.userInfo.user_password}</span></p>
            <p><span class="font-weight-bolder">积分: </span><span>${sessionScope.userInfo.user_integral}</span>分</p>
        </div>

    </div>
</div>


<!-- footer -->
<jsp:include page="userFooter.jsp"></jsp:include>
<!-- footer -->

</body>
</html>
