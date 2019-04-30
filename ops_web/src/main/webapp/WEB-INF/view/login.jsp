<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="zh-CN">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>OpsManage</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="${ctx}/assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="${ctx}/assets/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="${ctx}/assets/css/form-elements.css">
        <link rel="stylesheet" href="${ctx}/assets/css/style.css">


            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="${ctx}/assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${ctx}/assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${ctx}/assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${ctx}/assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="${ctx}/assets/ico/apple-touch-icon-57-precomposed.png">



        <!-- Javascript -->
        <script src="${ctx}/assets/js/jquery-1.10.2.js"></script>
        <script src="${ctx}/assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="${ctx}/assets/js/jquery.backstretch.min.js"></script>
        <script src="${ctx}/assets/js/scripts.js"></script>
        <script src="${ctx}/assets/js/placeholder.js"></script>


    </head>

    <body>

        <!-- Top content -->
        <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1><strong>OpsManage</strong></h1>

                            <h1><strong>运维管理平台</strong></h1>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h1>用户登录</h1>

                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-key"></i>
                        		</div>
                            </div>
                            <div class="form-bottom">
			                    <form role="form" action="" method="post" class="login-form">

                                    <div class="form-group-lg"  id="accountDiv">
                                        <label class="sr-only" for="inputAccount">用户名</label>
                                        <div class="input-group">
                                            <div class="input-group-addon"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></div>
                                            <input class="form-control" id="inputAccount" name="username" type="text" placeholder="用户名" required autofocus>
                                        </div>
                                        <div class="hidden text-center" id="accountMsg"><span class="glyphicon glyphicon-exclamation-sign"></span>用户名不存在</div>
                                    </div>
                                    <br>
                                    <div class="form-group-lg" id="pwdDiv">
                                        <label class="sr-only" for="inputPassword">密码</label>
                                        <div class="input-group">
                                            <div class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></div>
                                            <input class="form-control" id="inputPassword" name="pwd" type="password" placeholder="密码" required>
                                            <div class="input-group-addon"><span class="glyphicon glyphicon-eye-open"></span></div>
                                        </div>
                                        <div class="hidden text-center" id="pwdMsg"><span class="glyphicon glyphicon-exclamation-sign"></span>用户名密码错误</div>
                                    </div>
			                        <button id="btn_login" class="btn" type="button" >登录</button>

			                    </form>
		                    </div>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>
        <div class="copyrights">Collect from <a href="http://www.cssmoban.com/"  title="网站模板">网站模板</a></div>


        <script type="text/javascript">
            $("#btn_login").click(function(){
                var loginObj = new Object();
                loginObj.username= $("#inputAccount").val();
                loginObj.pwd= $("#inputPassword").val();
                var loginJson = JSON.stringify(loginObj); //将JSON对象转化为JSON字符
                $.post('validateLogin',
                    {"loginObj":loginJson},
                    function(e){
                        e=JSON.parse(e); //由JSON字符串转换为JSON对象
                        if(e.accountMsg){
                            $("#accountDiv").addClass("has-error");
                            $("#accountMsg").removeClass("hidden");

                            $("#pwdDiv").removeClass("has-error");
                            $("#pwdMsg").addClass("hidden");
                        }else if (e.pwdMsg){
                            $("#accountDiv").removeClass("has-error");
                            $("#accountMsg").addClass("hidden");

                            $("#pwdDiv").addClass("has-error");
                            $("#pwdMsg").removeClass("hidden");
                        }else if (e.user){
                            location.href="successLogin";
                            $("#loginForm").submit();
                        }
                    });
            });
        </script>






    </body>

</html>