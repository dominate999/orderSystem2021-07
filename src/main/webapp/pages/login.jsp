<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>饿麻了在线订餐服务——快来订餐吧！！！</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link href="${pageContext.request.contextPath}/images/bitbug_favicon.ico" rel="icon" type="image/x-ico">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/verify.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/verify.js"></script>
</head>

<body background="${pageContext.request.contextPath}/images/loginBackground.jpg">

<div class="section dwo">
    <div class="container">
        <div class="row full-height justify-content-center">
            <div class="col-12 text-center align-self-center py-5">
                <div class="section pb-5 pt-5 pt-sm-2 text-center">
                    <input class="checkbox" type="checkbox" id="reg-log" name="reg-log">
                    <div class="card-3d-wrap mx-auto">
                        <div class="card-3d-wrapper">
                            <div class="card-front">
                                <div class="center-wrap">
                                    <div class="section text-center">
                                        <h3 class="mb-4 pb-3" style="color: #ddd;">饿麻了</h3>

                                    <form action="${pageContext.request.contextPath}/userInfo/login" method="post" id = "loginForm">
                                        <div class="form-group">
                                            <a href="#">
                                                <span class="glyphicon glyphicon-user"></span>
                                            </a>
                                            <input type="text" name="loginUsername" class="form-style" value="${requestScope.ErrorLoginUsername}"
                                                   placeholder="请输入账号" id="loginUsername" autocomplete="off"
                                                   style="width: 90%;height: 40px;">

                                            <i class="input-icon uil uil-at"></i>
                                        </div>
                                        <div style="margin-top: 30px;"></div>

                                        <div class="form-group mt-2">
                                            <a href="#">
                                                <span class="glyphicon glyphicon-lock"></span>
                                            </a>
                                            <input type="password" name="loginPassword" class="form-style"
                                                   placeholder="请输入密码" id="loginPassword" autocomplete="off"
                                                   style="width: 90%;height: 40px;">
                                            <i class="input-icon uil uil-lock-alt"></i>
                                        </div>
                                        <span id = "loginError" style="color: #d45a5a">${requestScope.Error}</span>
                                        <div id="mpanel1" style="margin-top:10px; margin-bottom: 10px; margin-left: 40px">

                                        </div>
                                        <button id = "loginSubmitBt" class="btn btn-default" style="background-color: #f6c23e; width: 100px;" type="submit">登录</button>
                                    </form>

                                        <div class="d-flex justify-content-between mt-4 text-left">
                                            <div class="flex-fill">
                                                <p>没有帐号？<label for="reg-log">立即注册</label></p>
                                            </div>
                                            <div class="flex-fill text-right">
                                                <p><a href="javascript:" class="forgot link">忘记密码？</a></p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="card-back">
                                <div class="center-wrap">
                                    <div class="section text-center">
                                        <h4 class="mb-4 pb-3" style="margin-top: 50px;color: #ddd;">注册</h4>
                                        <form method="post" action="${pageContext.request.contextPath}/userInfo/register">
                                            <div class="form-group">
                                                <a href="#">
                                                    <span class="glyphicon glyphicon-user"></span>
                                                </a>
                                                <input type="text" name="registerUsername" class="form-style"
                                                       placeholder="请输入用户名" id="registerUsername" autocomplete="off"
                                                       style="width: 90%;height: 40px;">
                                                <span id="verifyRegisterUsername" style="font-size: 18px;" >&nbsp;</span>
                                                <i class="input-icon uil uil-user"></i>
                                            </div>
                                            <div class="form-group mt-2">
                                                <a href="#">
                                                    <span class="glyphicon glyphicon-lock"></span>
                                                </a>
                                                <input type="password" name="registerPassword" class="form-style"
                                                       placeholder="请输入密码" id="registerPassword" autocomplete="off"
                                                       style="width: 90%;height: 40px;">
                                                <span style="font-size: 18px;">&nbsp;</span>
                                                <i class="input-icon uil uil-at"></i>
                                            </div>
                                            <div class="form-group mt-2">
                                                <a href="#">
                                                    <span class="glyphicon glyphicon-lock"></span>
                                                </a>
                                                <input type="password" name="registerConfirmPassword" class="form-style"
                                                       placeholder="请确认密码" id="registerConfirmPassword" autocomplete="off"
                                                       style="width: 90%;height: 40px;">
                                                <span id="verifyPassword" style="font-size: 18px;">&nbsp;</span>
                                                <i class="input-icon uil uil-lock-alt"></i>
                                            </div>
                                            <div class="form-group mt-2">
                                                <a href="#">
                                                    <span class="glyphicon glyphicon-asterisk"></span>
                                                </a>
                                                <input type="text" name="registerAddressed" class="form-style"
                                                       placeholder="请输入地址" id="registerAddressed" autocomplete="off"
                                                       style="width: 90%;height: 40px;">
                                                <span id="verifyAddressed" style="font-size: 18px;">&nbsp;</span>
                                                <i class="input-icon uil uil-at"></i>
                                            </div>
                                            <div class="form-group mt-2">
                                                <a href="#">
                                                    <span class="glyphicon glyphicon-phone"></span>
                                                </a>
                                                <input type="text" name="registerPhone" class="form-style"
                                                       placeholder="请输入手机号" id="registerPhone" autocomplete="off"
                                                       style="width: 90%;height: 40px;">
                                                <span id="verifyPhone" style="font-size: 18px;">&nbsp;</span>
                                                <i class="input-icon uil uil-at"></i>
                                            </div>
                                            <button id = "RegisterSubmitBt" style="    width: 100px; background-color: #f6c23e;margin-bottom: 40px;margin-left: 120px;" class="btn mt-4" type="submit">注册</button>
                                         <label for="reg-log" style="margin-left: 30px;">   已有帐号？立即登录</label>

                                        </form>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    $(document).ready(function() {


        $('#mpanel1').slideVerify({
            type: 1, //类型
            vOffset: 5, //误差量，根据需求自行调整
            barSize: {
                width: '300px',
                height: '40px',
            },
            ready: function () {
                $("#loginSubmitBt").prop("disabled", true);
            },
            success: function () {
                $("#loginSubmitBt").prop("disabled", false);//设置按钮可用
            },
            error: function () {
                $("#loginSubmitBt").prop("disabled", true);
            }

        });

        var istruename = false;
        var istruepassword = false;
        var istrueaddressed = false;
        var istruephone = false

        $("#registerUsername").blur(function(){
            var registerInfomation = $("#registerUsername").val();
            console.log($("#registerUsername").val());

            //ajax传输数据进行判断校验
            $.ajax({
                type: 'post',
                url: "${pageContext.request.contextPath}/userInfo/ajaxVerifyUsername",//action方式
                data: {registerInfomation: registerInfomation}, //参数，如果参数多，可用date后跟一个大括号
                dataType: 'json',
                success: function (res) {//回调函数
                    console.log(res);
                    if (res==1) {
                        $("#verifyRegisterUsername").show();
                        $("#verifyRegisterUsername").css("color","#11ff00");
                        $("#verifyRegisterUsername").text("√");
                        istruename = true;
                    } else {
                        $("#verifyRegisterUsername").show();
                        $("#verifyRegisterUsername").css("color","#ff0000");
                        $("#verifyRegisterUsername").text("*");
                        $("#RegisterSubmitBt").prop("disabled", true); //设置按钮不可用
                        istruename = false;
                    }

                }
            });

        });


        $("#loginUsername").focus(function(){
            $("#verifyUsername").hide();
        });

        var password1 = undefined;
        var password2 = undefined;

        $("#registerConfirmPassword").blur(function(){
             password1 = $("#registerPassword").val();
             password2 = $("#registerConfirmPassword").val();
            console.log(password1);
            console.log(password2);
            if(password1!=password2 || !password1 || !password2){
                $("#verifyPassword").css("color","#ff0000");
                $("#verifyPassword").text("*");
                $("#RegisterSubmitBt").prop("disabled", true); //设置按钮不可用
                istruepassword = false;
            }else {
                $("#verifyPassword").css("color","#11ff00");
                $("#verifyPassword").text("√");
                istruepassword = true;
            }
        });

        $("#registerPassword").blur(function(){
            password1 = $("#registerPassword").val();
            password2 = $("#registerConfirmPassword").val();
            console.log(password1);
            console.log(password2);
            if(password1!=password2  || !password1 || !password2){
                $("#verifyPassword").css("color","#ff0000");
                $("#verifyPassword").text("*");
                $("#RegisterSubmitBt").prop("disabled", true); //设置按钮不可用
                istruepassword = false;
            }
            else{
                $("#verifyPassword").css("color","#11ff00");
                $("#verifyPassword").text("√");
                istruepassword = true;
            }
        });

        var address = undefined;
        var phone = undefined;
        var patter_phone = /^\d{11}$/;
        $("#registerAddressed").blur(function(){
            address = $("#registerAddressed").val();
            console.log(address);
            if(!address){
                $("#verifyAddressed").css("color","#ff0000");
                $("#verifyAddressed").text("*");
                $("#RegisterSubmitBt").prop("disabled", true); //设置按钮部不可用
                istrueaddressed = false;
            }else{
                $("#verifyAddressed").css("color","#11ff00");
                $("#verifyAddressed").text("√");
                istrueaddressed = true;
            }
        });

        $("#registerPhone").blur(function(){
            phone = $("#registerPhone").val();
            var matchResult = patter_phone.test(phone);
            console.log(phone);
            if(!matchResult){
                $("#verifyPhone").css("color","#ff0000");
                $("#verifyPhone").text("*");
                $("#RegisterSubmitBt").prop("disabled", true); //设置按钮部不可用
                istruephone = false;
            }else{
                $("#verifyPhone").css("color","#11ff00");
                $("#verifyPhone").text("√");
                istruephone = true;

            }
        });

        $("#registerPhone").mousemove(function (){
            if(istruepassword && istrueaddressed && istruephone && istruename){
                $("#RegisterSubmitBt").prop("disabled", false);
            }
        })


        $("#registerPassword").focus(function(){
            $("#verifyPassword").text(" ");
        });

        $("#registerConfirmPassword").focus(function(){
            $("#verifyPassword").text(" ");
        });

    });
</script>
</html>
