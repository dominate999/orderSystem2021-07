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
    <script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/InputSpinner.js" type="text/javascript"></script>
    <style type="text/css">
        .imgSizeControll {
            width: 120px;
            height: 100px;
        }
        .but{
            color: white;
        }
        .alert {
            display: none;
            position: fixed;
            top: 50%;
            left: 50%;
            min-width: 300px;
            max-width: 600px;
            transform: translate(-50%,-50%);
            z-index: 99999;
            text-align: center;
            padding: 20px;
            border-radius: 3px;
        }

    </style>
</head>
<body>

<%--引入头部--%>
<jsp:include page="userNav.jsp"></jsp:include>
<%--引入头部--%>

<div class="container">
    <div class="row">
        <div class="col-md-12 column">
            <span id = "IfUserInfoExist" hidden>${sessionScope.userInfo}</span>
            <table class="table">
                <thead style="background-color: #0D62B2;color: white;">
                <tr>
                    <th style="vertical-align: middle !important;text-align: center;">
                        编号
                    </th>
                    <th style="vertical-align: middle !important;text-align: center;">
                        菜品
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
                    <th style="vertical-align: middle !important;text-align: center;">
                        操作
                    </th>
                </tr>
                </thead>
                <c:forEach items="${cartList}" var="cartList">
                    <tbody class="border">
                    <tr>
                        <td class = "cartId" style="vertical-align: middle !important;text-align: center;">${cartList.id}</td>
                        <td style="vertical-align: middle !important;text-align: center;">${cartList.name}</td>
                        <td style="vertical-align: middle !important;text-align: center;"><img src="${pageContext.request.contextPath}/images/foodImg/${cartList.photo}" alt="..." class="imgSizeControll"></td>
                        <td style="vertical-align: middle !important;text-align: center;">${cartList.price}</td>
                        <td style="vertical-align: middle !important;text-align: center; width: 150px;">
                            <input type="number" class="numberInput" value="${cartList.count}" min="0" max="99" step="1">
                        </td>
                        <td style="vertical-align: middle !important;text-align: center;" class = "currentTotalMoney">${cartList.totalMoney}</td>
                        <td style="vertical-align: middle !important;text-align: center;">
                            <a  onclick="return confirm('您确定要移除嘛？')" href="${pageContext.request.contextPath}/cartInfo/deleteCart?deleteCartID=${cartList.id}" class="removeCart"><i class="bi bi-cart-dash"  style="font-size: 1.6rem; color: cornflowerblue;"></i></a>
                        </td>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>
        </div>
    </div>
    <table class="table" style="background-color: #e6e6e6; height: 40px;">

        <td style="vertical-align: middle !important;text-align: center;" >已选菜品<span id = "totalCount">${totalCount}</span>件</td>
        <td style="vertical-align: middle !important;text-align: center;"><a href="${pageContext.request.contextPath}/cartInfo/clearCart"> <button type="button" class="btn btn-danger">清空购物车</button></a></td>
        <td style="vertical-align: middle !important;text-align: center;" >应付<span id="cartTotalMoney">${totalMoney}</span>元</td>
        <td style="float: right;">
            <a href="${pageContext.request.contextPath}/dishes/browsePro?productionCate=菜类" class="but"><button type="button" class="btn btn-primary">继续购物</button></a>
            <a href="${pageContext.request.contextPath}/orderInfo/saveUserOrder" class="but" id = "payMoney"><button type="button" class="btn btn-outline-success" >结算</button></a>

        </td>
    </table>

</div>

<div style="margin-top: 275px;"></div>
<!-- footer -->
<jsp:include page="userFooter.jsp"></jsp:include>
<!-- footer -->

</body>

<script type="text/javascript">

    $(document).ready(function () {

        $("input[type='number']").InputSpinner()
        $("input.small").InputSpinner({
            groupClass: "input-group-sm"
        })
        $("input.large").InputSpinner({
            groupClass: "input-group-lg"
        })
    });

</script>

<%--<script>--%>
<%--    $("a.removeCart").click(function(){--%>
<%--        $('<div>').appendTo('body').addClass('alert alert-success').html('移除成功').show().delay(1000).fadeOut();--%>
<%--    })--%>
<%--</script>--%>
<script>
    $(document).ready(function () {
        $(".numberInput").change(function (){
            // alert($(".numberInput").val());
            var cartId  = $(this).parents("tr").children("td.cartId").text();
            var thisTr = $(this).parents("tr");
            var count = $(this).val();
            console.log(cartId);
            console.log(count);
            data = "cartId="+cartId+"&count="+count;
            $.ajax({
                type: 'post',
                url: "${pageContext.request.contextPath}/cartInfo/updateCart",//action方式
                data: data, //参数，如果参数多，可用date后跟一个大括号
                dataType: 'json',
                success: function (cartInfoList) {//回调函数

                    console.log(cartInfoList);
                    $("#totalCounts").text(cartInfoList[0]);/*购物车总数*/
                    $("#totalCount").text(cartInfoList[0]);/*购物车总数*/
                    thisTr.children("td.currentTotalMoney").text(cartInfoList[1])/*当前修改商品的价格*/
                    // console.log(thisTr.children("td"));
                    $("#cartTotalMoney").text(cartInfoList[2]);/*购物车里面的总价格*/
                }
            });
        });
        $("#payMoney").click(function () {
            // alert($("#IfUserInfoExist").text());
            if($("#IfUserInfoExist").text()==null||$("#IfUserInfoExist").text()==""){
                alert("请先登录！")
                return false;
            }
        });

        $("#payMoney").click(function () {
            // alert($("#IfUserInfoExist").text());
            if($("#IfUserInfoExist").text()!=null&&$("#IfUserInfoExist").text()!=""){
                var totalMoney = '<%= session.getAttribute("totalMoney")%>';
                console.log("totalMoney:::" + totalMoney);
                if( totalMoney == 0){
                    alert("您的购物车空空如也！")
                    return false;
                }

            }
        });


    });


</script>
</html>