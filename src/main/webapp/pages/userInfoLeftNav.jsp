<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<div class="col-md-3 column mb-5">
    <div class="list-group" style="width: 200px; float: right;">
        <div class="list-group-item" style="background-color: #0D62B2;">
            <span style="font-size: 20px;color: white">订单信息</span>
        </div>
        <div class="list-group-item" style="background-color: #DCDCDC;">
            <a href="${pageContext.request.contextPath}/orderInfo/findUserOrder?userId=${sessionScope.userInfo.user_id}">
                <span style="color: #000000;">订单查看</span>
            </a>
        </div>
        <div class="list-group-item" style="background-color: #DCDCDC;">
            <a href="${pageContext.request.contextPath}/evaInfo/findUserEvaInfo">
                <span style="color: #000000;">评价查看</span>
            </a>
        </div>
        <div class="list-group-item" style="background-color: #0D62B2;">
            <span style="font-size: 20px;color: white">信息管理</span>
        </div>
        <div class="list-group-item" style="background-color: #DCDCDC;">
            <a href="${pageContext.request.contextPath}/userInfo/toUserInfoCenter">
                <span style="color: #000000;">个人信息</span>
            </a>
        </div>
        <div class="list-group-item" style="background-color: #DCDCDC;">
            <a href="${pageContext.request.contextPath}/pages/updateUserInfo.jsp">
                <span style="color: #000000;">信息修改</span>
            </a>
        </div>

    </div>
</div>