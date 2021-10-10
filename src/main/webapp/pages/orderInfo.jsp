<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>饿麻了在线订餐服务——快来订餐吧！！！</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
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
                <div class="d-sm-flex justify-content-between align-items-center mb-4">
                    <h3 class="text-dark mb-0">订单信息</h3>
                </div>
                <div class="card shadow">
                    <div class="card-header py-3">
                        <p class="text-primary m-0 font-weight-bold"></p>
                    </div>
                    <div class="card-body">
                        <div class="row">
                            <div class="col-md-6 text-nowrap">
                                <div id="dataTable_length" class="dataTables_length" aria-controls="dataTable"></div>
                                <a role="button" href="${pageContext.request.contextPath}/orderInfo/orderExcelExport"><button type="button" class="btn btn-info">下载订单信息</button></a>

                            </div>
                            <div class="col-md-6">
                                <div class="text-md-right dataTables_filter" id="dataTable_filter">
                                    <form method="get" action="${pageContext.request.contextPath}/orderInfo/searchOrder" class="d-none d-sm-inline-block mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                                        <div class="input-group"><input class="bg-light form-control border-0 small" name="searchKw" id ="searchKw"
                                                                      value="${requestScope.kw}"  type="text" placeholder="输入关键词查询 ...">
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
                                    <th>订单号</th>
                                    <th>用户昵称</th>
                                    <th>下单时间</th>
                                    <th>地址</th>
                                    <th>数量</th>
                                    <th>状态</th>
                                    <th>总金额</th>
                                    <th>操作</th>
                                </tr>
                                </thead>

                                <tbody>
                                <c:forEach items="${requestScope.pageInfo.list}" var="orderInfo">
                                    <tr>
                                         <input type ="hidden" value="${orderInfo.order_id}" name = "currentOrderId" >
                                        <td>${orderInfo.order_name}</td>
                                        <td>${orderInfo.user_name}</td>
                                        <td>${orderInfo.order_time}</td>
                                        <td>${orderInfo.user_addressed}</td>
                                        <td>${orderInfo.order_number}</td>
                                        <td class = "order_status">${orderInfo.order_status}</td>
                                        <td>${orderInfo.order_money}</td>
                                        <td>
                                            <div class="btn-group" role="group">
                                                <a role="button" href="${pageContext.request.contextPath}/orderInfo/findOrderItem?findOrderId=${orderInfo.order_id}"><button class="btn btn-success" type="button">详情</button></a>
                                                <div class="dropdown btn-group" role="group" >
                                                    <button class="btn btn-primary dropdown-toggle orderOpBt"  data-toggle="dropdown"
                                                            aria-expanded="false" type="button" >操作&nbsp;
                                                    </button>
                                                    <div class="dropdown-menu" role="menu">
                                                        <a class="dropdown-item receipt statusChange"   role="presentation" href="">接单</a>
                                                        <a class="dropdown-item distribution statusChange"  role="presentation" href="">配送</a>
                                                        <a class="dropdown-item cancelled statusChange"   role="presentation" href="">取消订单</a>
                                                        <a class="dropdown-item completed statusChange"  role="presentation" href="">完成订单</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
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

        $(".orderOpBt").click(function () {

            /*获取当前订单的状态*/
            var status  = $(this).parents("tr").children("td").eq(5).html() ;
            console.log(status);

            if(status == "未接单"){ /*当前状态是未接单，只允许使用接单、取消订单*/
                $('.distribution').removeAttr('href');//去掉a标签中的href属性
                $('.distribution').removeAttr('onclick');//去掉a标签中的onclick事件

                $('.completed').removeAttr('href');//去掉a标签中的href属性
                $('.completed').removeAttr('onclick');//去掉a标签中的onclick事件

            }else if(status =="已接单"){/*当前状态是未配送，只允许使用配送和取消订单*/

                $('.receipt').removeAttr('href');//去掉a标签中的href属性
                $('.receipt').removeAttr('onclick');//去掉a标签中的onclick事件

                $('.completed').removeAttr('href');//去掉a标签中的href属性
                $('.completed').removeAttr('onclick');//去掉a标签中的onclick事件
            }else if(status == "已配送"){/*当前状态是已配送，只允许使用完成订单*/

                $('.receipt').removeAttr('href');//去掉a标签中的href属性
                $('.receipt').removeAttr('onclick');//去掉a标签中的onclick事件

                $('.distribution').removeAttr('href');//去掉a标签中的href属性
                $('.distribution').removeAttr('onclick');//去掉a标签中的onclick事件

                $('.cancelled').removeAttr('href');//去掉a标签中的href属性
                $('.cancelled').removeAttr('onclick');//去掉a标签中的onclick事件
            }else if(status == "已完成"||status == "已取消"){ /*当前状态是已完成，所有按钮都禁止使用*/

                $('.receipt').removeAttr('href');//去掉a标签中的href属性
                $('#receipt').removeAttr('onclick');//去掉a标签中的onclick事件


                $('.distribution').removeAttr('href');//去掉a标签中的href属性
                $('.distribution').removeAttr('onclick');//去掉a标签中的onclick事件


                $('.cancelled').removeAttr('href');//去掉a标签中的href属性
                $('.cancelled').removeAttr('onclick');//去掉a标签中的onclick事件


                $('.completed').removeAttr('href');//去掉a标签中的href属性
                $('.completed').removeAttr('onclick');//去掉a标签中的onclick事件
            }


        });



    });

</script>
<script>

    $(document).ready(function () {

        $(".statusChange").click(function () {

            /*需要传送两个数据：一个是当前的订单的id，还有是修改的状态是什么？*/
            /*首先获取到当前点击的超链接的值*/
            var statusChange = $(this).text();
            console.log(statusChange);
            // alert(statusChange);
            var updateStatus = undefined;

            if(statusChange == "接单"){
                updateStatus = "已接单";
            }else if(statusChange == "配送"){
                updateStatus = "已配送";
            }else if(statusChange == "取消订单"){
                updateStatus = "已取消";
            }else if(statusChange == "完成订单"){
                updateStatus = "已完成";
            }
            var currentOrderId = $(this).parents("tr").children("input").val();
            // alert(currentOrderId);
            var data = "updateOrderId="+currentOrderId+"&updateStatus="+updateStatus;
            // alert(data);
            var thisUpdateStatus = $(this).parents("tr").children("td").eq(5);
            // alert(thisUpdateStatus.html());

            $.ajax({
                type: 'post',
                url: "${pageContext.request.contextPath}/orderInfo/updateOrderStatus",//action方式
                data: data, //参数，如果参数多，可用date后跟一个大括号
                dataType: 'json',
                success: function (updateStatus) {//回调函数
                    alert(updateStatus);
                    /*获取当前订单的状态并修改*/
                    thisUpdateStatus.text(updateStatus);
                }
            });

        });
    });

</script>
</html>