<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <link rel="stylesheet"  href="${pageContext.request.contextPath}/layui/css/layui.css">
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
                <h3 class="text-dark mb-4">用户信息</h3>
                <div class="card shadow">
                    <div class="card-header py-3">
                        <p class="text-primary m-0 font-weight-bold"></p>
                    </div>
                    <div class="card-body">
                        <div class="row">
                            <div class="col-md-6 text-nowrap">
                                <div id="dataTable_length" class="dataTables_length" aria-controls="dataTable"></div>
                            </div>
                            <div class="col-md-6">
                                <div class="text-md-right dataTables_filter" id="dataTable_filter">
                                    <form action="${pageContext.request.contextPath}/userInfo/searchUser" method="get" class="d-none d-sm-inline-block mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                                        <div class="input-group"><input class="bg-light form-control border-0 small" name="searchKw" id ="searchKw"
                                                                    value="${requestScope.kw}"    type="text" placeholder="请输入关键字...">
                                            <div class="input-group-append">
                                                <button class="btn btn-primary py-0" type="submit"><i
                                                        class="fas fa-search"></i></button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="table-responsive table mt-2" id="dataTable" role="grid"
                             aria-describedby="dataTable_info">
                            <table class="table my-0">
                                <thead>
                                <tr>
                                    <th>账号</th>
                                    <th>姓名</th>
                                    <th>密码</th>
                                    <th>地址</th>
                                    <th>电话</th>
                                    <th>积分</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${requestScope.pageInfo.list}" var="userInfo">
                                    <tr>
                                        <td>${userInfo.user_account}</td>
                                        <td>${userInfo.user_name}</td>
                                        <td>${userInfo.user_password}</td>
                                        <td>${userInfo.user_addressed}</td>
                                        <td>${userInfo.user_phone}<br></td>
                                        <td>${userInfo.user_integral}</td>
                                    </tr>
                                </c:forEach>

                                </tbody>

                            </table>
                        </div>

                        <%--引入pageNav导航栏--%>
                        <jsp:include page="pageNav.jsp"></jsp:include>
                        <%--引入pageNav导航栏--%>

                    </div>
                </div>
            </div>

                <%--引入footer导航栏--%>
                <jsp:include page="footer.jsp"></jsp:include>
                <%--引入footer导航栏--%>
        </div>

    </div>

    <a class="border rounded d-inline scroll-to-top" href="#page-top"><i class="fas fa-angle-up"></i></a>
</div>
</body>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src ="${pageContext.request.contextPath}/js/jquery.easing.js"></script>
<script src="${pageContext.request.contextPath}/js/theme.js"></script>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script>
    $(document).ready(function (){

        <%--layuiPage JS模块--%>
        layui.use(['laypage', 'layer'], function(){
            var laypage = layui.laypage;
            // layer = layui.layer;

            //完整功能
            laypage.render({
                elem: 'layuipager'
                // yj  这里是你想显示在界面上的总数据,分页 *页数
                ,count: ${pageInfo.total}
                ,page: true
                ,curr: ${pageInfo.pageNum},//这个是你当前的页数，设置好 页面跳转后他会自动选择对应的页码、也就是第几页的背景改变颜色
                limit : ${pageInfo.pageSize},//这个是每页面显示多少条，页面跳转后他会自动让下拉框里对应的值设为选中状态
                limits: [5,10,15,20],//这个是下拉框里显示的option
                layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip','first','last'],
                jump: function(obj,first){
                    console.log(obj.curr);
                    console.log(obj.limit);
                    console.log(obj.href);
                    if (first) {
                        return;
                    }
                    //跳转到对应的页面
                    var url = '?pageNum='+obj.curr+'&pageSize='+obj.limit;
                    var kw = $("#searchKw").val();
                    console.log("kw"+kw);
                    if(typeof(kw) == undefined){

                    }else{
                        url += "&searchKw="+kw;
                    }
                    window.location.href = url;
                }
            });
        });

    });

</script>
</html>