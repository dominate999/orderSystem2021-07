<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-light navbar-expand bg-white shadow mb-4 topbar static-top">
    <div class="container-fluid">
        <button class="btn btn-link d-md-none rounded-circle mr-3" id="sidebarToggleTop" type="button"><i
                class="fas fa-bars"></i></button>
        <ul class="nav navbar-nav flex-nowrap ml-auto">
            <li class="nav-item dropdown no-arrow" role="presentation">
                <div class="nav-item dropdown show no-arrow"><a class="dropdown-toggle nav-link"
                                                                data-toggle="dropdown" aria-expanded="true"
                                                                href="#"><span
                        class="d-none d-lg-inline mr-2 text-gray-600 small">管理员</span><img
                        class="border rounded-circle img-profile"
                        src="${pageContext.request.contextPath}/images/mainfood.png" alt="头像"></a>
                    <div
                            class="dropdown-menu shadow dropdown-menu-right animated--grow-in"
                            role="menu"><a class="dropdown-item" role="presentation" href="${pageContext.request.contextPath}/indexInfo/findIndexAll"><i
                            class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>&nbsp;回到前台界面</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" role="presentation" onclick="return confirm('您确定要退出吗？')" href="${pageContext.request.contextPath}/userInfo/logOut"><i
                                class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>&nbsp;退出登录</a>
                    </div>
                </div>
            </li>
        </ul>
    </div>
</nav>