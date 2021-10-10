<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>饿麻了在线订餐服务——快来订餐吧！！！</title>
    <link href="${pageContext.request.contextPath}/images/bitbug_favicon.ico" rel="icon" type="image/x-ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
     <link rel="stylesheet" href="${pageContext.request.contextPath}/css/fonts.googleapis.com.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/fonts/fontawesome-all.min.css">
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
                        <h3 class="text-dark mb-0">新增美食信息</h3>
                    </div>
                    <div class="card shadow">
                        <div class="card-body">
                            <div class="row">
                                <div class="col"></div>
                                <div class="col-xl-5">
                                    <form method="post" action="../dishes/addDishes" enctype="multipart/form-data">
                                        <div class="col">
                                            <div class="form-group"><label>菜名：</label><input class="form-control" type="text" name = "dishes_name" id = "dishes_name"></div>
                                        </div>
                                        <div class="col">
                                            <div class="form-group"><label>描述：</label><textarea class="form-control" name="dishes_des" id = "dishes_des"></textarea>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="form-group">
                                                <label>图片：</label>
                                                <input type="file" name = "upload"  />
                                                <img src="assets/img/mdvo58.jpg" style="width:120px;height: 100px;">
<%--                                                <button type="button" id = "confirmPhotoBt">确认图片</button>--%>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="form-group"><label>类型：</label>
                                                <select class="form-control" name = "dishes_cate" id = "dishes_cate">
                                                        <option value="蔬菜类" selected="">蔬菜类</option>
                                                        <option value="荤菜类">荤菜类</option>
                                                        <option value="奶茶类">奶茶类</option>
                                                        <option value="甜点类">甜点类</option>
                                                        <option value="面食类">面食类</option>
                                                        <option value="水果类">水果类</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="form-group"><label>库存：</label><input class="form-control" type="number" name = "dishes_number" id = "dishes_number">
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="form-group"><label>单价：</label><input class="form-control" type="number" name = "dishes_price" id = "dishes_price">
                                            </div>
                                        </div>

                                        <div class="col-xl-3 offset-xl-0"><button class="btn btn-primary" type="submit">确认</button></div>

                                    </form>
                                </div>
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
<script>
    $(document).ready(function () {



    });


</script>
</body>
</html>