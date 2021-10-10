<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<nav class="navbar navbar-light bg-light fixed-top">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/indexInfo/findIndexAll"
       style="font-family: SimSun;font-size: 30px;font-weight: bold;color: #01B6FD;">
        <img src="${pageContext.request.contextPath}/images/logo.png" width="60px" height="60px" class="d-inline-block align-top" alt=""
             style="margin-left: 100px;">
        饿麻了在线订餐
    </a>
    <ul class="nav justify-content-end">
        <li class="nav-item">
            <a class="nav-link" id = "adminManagerHref"  href="${pageContext.request.contextPath}/dishes/findAll"><i class="bi bi-box-arrow-in-right"
                                                                                              style="font-size: 1.4rem; color: #01B6FD;"></i>进入管理后台</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/dishes/browsePro"><i class="bi bi-house-fill"
                                                    style="font-size: 1.4rem; color: #01B6FD;"></i>订餐首页</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/cartInfo/findCart"><i class="bi bi-cart2"
                                                                                               style="font-size: 1.4rem; color: #01B6FD;"></i>购物车<span id = "totalCounts" class="badge badge-danger">${sessionScope.totalCount}</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" id = "personCenterHref" href="${pageContext.request.contextPath}/pages/userInfoCenter.jsp"><i class="bi bi-people-fill"
                                                      style="font-size: 1.4rem; color: #01B6FD;"></i>个人中心</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" id = "loginHref" href="${pageContext.request.contextPath}/pages/login.jsp"><i class="bi bi-box-arrow-in-right"
                                                     style="font-size: 1.4rem; color: #01B6FD;"></i>登录</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" id = "logoutHref" onclick="return confirm('您确定要退出吗？')" href="${pageContext.request.contextPath}/userInfo/logOut"><i class="bi bi-box-arrow-in-left"
                                                                                             style="font-size: 1.4rem; color: #01B6FD;"></i>退出</a>
        </li>
    </ul>
    <span id = "userInfoSession" hidden >${sessionScope.userInfo.user_account}</span>
</nav>
<div style="margin-top:100px"></div>
<div style="margin-top: 50px;"></div>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script>
    $(document).ready(function (){
       var state =  $("#userInfoSession").text();
       console.log("login:");
       console.log(state);
       if(state == ""){
           $("#personCenterHref").hide();
           $("#logoutHref").hide();
           $("#loginHref").show();

       }else{
           $("#personCenterHref").show();
           $("#loginHref").hide();
           $("#logoutHref").show();
       }

       if(state != "admin"){

            $("#adminManagerHref").hide();
       }else{
           $("#adminManagerHref").show();
       }

    });
</script>
