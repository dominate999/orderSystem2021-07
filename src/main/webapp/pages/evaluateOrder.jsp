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
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <style type="text/css">
        .imgSizeControll {
            width: 120px;
            height: 100px;

        }

        .stars {
            white-space: nowrap;
            text-align: center;
            margin-top: 20px;
            margin-bottom: 20px;
        }

        .stars li {
            display: inline-block;
            color: #ADADAD;
            font-size: 40px;
        }
    </style>
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

        <div class="col-md-9 column">
            <form action="${pageContext.request.contextPath}/evaInfo/addEvaInfo" method="get">
                <input type="hidden" name="orderId" id="orderId" value="${sessionScope.orderId}">
                <table class="table">
                    <thead style="background-color: #0D62B2">
                    <tr>
                        <th style="vertical-align: middle !important;text-align: center;color: white;">
                            订单编号
                        </th>
                        <th style="vertical-align: middle !important;text-align: center;color: white;">
                            星级
                        </th>
                        <th style="vertical-align: middle !important;text-align: center;color: white;">
                            评价内容
                        </th>

                        <th style="vertical-align: middle !important;text-align: center;color: white;">
                            操作
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="border">
                        <td style="vertical-align: middle !important;text-align: center;">
                            ${sessionScope.orderName}
                        </td>
                        <td style="vertical-align: middle !important;text-align: center;">
                            <input type="hidden" id="starNum" name="starNum" value="" />
                            <ul class="stars">
                                <li>★</li>
                                <li>★</li>
                                <li>★</li>
                                <li>★</li>
                                <li>★</li>
                            </ul>
                        </td>
                        <td style="vertical-align: middle !important;text-align: center;">
                            <textarea class="form-control" rows="3" id="txt" name="txt"></textarea>
                        </td>
                        <td style="vertical-align: middle !important;text-align: center;">
                            <input type="submit" value="评价">
                        </td>
                    </tr>

                    </tbody>
                </table>
            </form>
        </div>
    </div>
</div>


<!-- footer -->
<jsp:include page="userFooter.jsp"></jsp:include>
<!-- footer -->




</body>
<script>
    $(function() {
        //为星星设置hover效果
        var isClicked = false;
        var beforeClickedIndex = -1;
        var clickNum = 0; //点击同一颗星次数
        $('li').hover(
            function() {
                if (!isClicked) {
                    $(this).css('color', '#F0AD4E');
                    var index = $(this).index();
                    for (var i = 0; i <= index; i++) {
                        $('li:nth-child(' + i + ')').css('color', '#F0AD4E');
                    }
                }
            },
            function() {
                if (!isClicked) {
                    $('li').css('color', '#ADADAD');
                }
            }
        );
        //星星点击事件
        $('li').click(function() {
            $('li').css('color', '#ADADAD');
            isClicked = true;
            var index = $(this).index();
            for (var i = 1; i <= index + 1; i++) {
                $('li:nth-child(' + i + ')').css('color', '#F0AD4E');
            }
            if (index == beforeClickedIndex) { //两次点击同一颗星星 该星星颜色变化
                clickNum++;
                if (clickNum % 2 == 1) {
                    $('li:nth-child(' + (index + 1) + ')').css('color', '#ADADAD');
                } else {
                    $('li:nth-child(' + (index + 1) + ')').css('color', '#F0AD4E');
                }
            } else {
                clickNum = 0;
                beforeClickedIndex = index;
            }
            $("#starNum").val(index + 1);
        });
    });
</script>


</html>
