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
     <link rel="stylesheet" href="${pageContext.request.contextPath}/css/fonts.googleapis.com.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/fonts/fontawesome-all.min.css" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <link href="${pageContext.request.contextPath}/images/bitbug_favicon.ico" rel="icon" type="image/x-ico">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

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

            <div class="col-sm-2 border border-right-0">
                <img  name = "userPhoto" id = "userPhoto" src="${pageContext.request.contextPath}/images/${sessionScope.userInfo.user_photo}" class="img-thumbnail" alt="Cinque Terre" width="154" height="106">
                <span>点击头像即可修改</span>
            </div>

            <div class="col-sm-7 border border-left-0" style="font-size: 20px;">
                <form action="${pageContext.request.contextPath}/userInfo/updateUser" method="post"  enctype="multipart/form-data">

                    <input type="file"  hidden id = "upadteUserPhoto" name = "upadteUserPhoto" accept="image/gif, image/jpeg , image/jpg, image/png" ></p>
                    <p><span class="font-weight-bolder">用户名：</span><input type="text" readonly value="${sessionScope.userInfo.user_account}" ></p>
                    <p><span class="font-weight-bolder">&nbsp;&nbsp;&nbsp;&nbsp;姓名：</span><input name = "updateUsername" id = "updateUsername" type="text"
                                                                                                 value="${sessionScope.userInfo.user_name}"></p>

                    <p><span class="font-weight-bolder">手机号：</span><input type="text" name = "updateUserphone" id = "updateUserphone" value="${sessionScope.userInfo.user_phone}"></p>
                    <p><span class="font-weight-bolder">主地址：</span><input type="text" name="updateUseraddressed" id = "updateUseraddressed" value="${sessionScope.userInfo.user_addressed}"></p>
                    <p><span class="font-weight-bolder">&nbsp;&nbsp;&nbsp;&nbsp;密码：</span><input type="text" name = "updatePassword" id="updatePassword"
                                                                                                 value="${sessionScope.userInfo.user_password}"></p>
                    <input type="submit" class="btn btn-info" style="width: 150px;margin-left: 100px;" value="确认修改">
                </form>
            </div>

    </div>
</div>

    <!-- footer -->
    <jsp:include page="userFooter.jsp"></jsp:include>
    <!-- footer -->

</body>
<script src ="${pageContext.request.contextPath}/js/jquery.easing.js"></script>
<script>
    $(document).ready(function(){
        $("#userPhoto").click(function (){
            $("#upadteUserPhoto").click();
        });

    });


</script>
</html>
