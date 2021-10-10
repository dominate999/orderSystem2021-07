<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<nav class="navbar navbar-dark align-items-start sidebar sidebar-dark accordion bg-gradient-primary p-0"
     style="background-color: #009688;background-image: none">
    <div class="container-fluid d-flex flex-column p-0">
        <a class="navbar-brand d-flex justify-content-center align-items-center sidebar-brand m-0" href="#">
            <div class="sidebar-brand-icon "><img src="${pageContext.request.contextPath}/images/backlogo.png" width="60px" height="60px" alt=""
                                                           ></div>
            <div class="sidebar-brand-text mx-3"><span>饿麻了后台管理</span></div>
        </a>
        <hr class="sidebar-divider my-0">
        <ul class="nav navbar-nav text-light" id="accordionSidebar">
            <li class="nav-item" role="presentation"><a class="nav-link" href="${pageContext.request.contextPath}/orderInfo/findAllOrder"><i
                    class="fas fa-tachometer-alt"></i><span>订单处理</span></a></li>
            <li class="nav-item" role="presentation"><a class="nav-link" href="${pageContext.request.contextPath}/userInfo/findAllUser"><i
                    class="fas fa-user"></i><span>会员管理</span></a></li>
            <li class="nav-item" role="presentation"><a class="nav-link" href="${pageContext.request.contextPath}/dishes/findAll"><i
                    class="fas fa-table"></i><span>美食管理</span></a></li>
            <li class="nav-item" role="presentation"></li>
            <li class="nav-item" role="presentation"></li>
        </ul>
        <div class="text-center d-none d-md-inline">
            <button class="btn rounded-circle border-0" id="sidebarToggle" type="button"></button>
        </div>
    </div>
</nav>