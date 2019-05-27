<%--
  Created by IntelliJ IDEA.
  User: rsh
  Date: 2019/4/23
  Time: 8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="style/images/favicon.ico">

    <title>注册</title>

    <!-- Bootstrap core CSS -->
    <link href="style/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="style/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="style/css/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]>
    <script src="style/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="style/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container">

    <!-- Static navbar -->
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                        aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">BookStore</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li><a href="index">主页</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="signin.jsp">登录</a></li>
                    <li><a href="help.jsp">帮助</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
    </nav>

    <form class="form-signin" action="signup" method="post">
        <h2 class="form-signin-heading">请输入信息</h2>
        <label>昵称</label>
        <input type="text" id="logname" class="form-control" required autofocus name="logname"><br>
        <label>真实姓名</label>
        <input type="text" id="realname" class="form-control" name="realname"><br>
        <label>性别</label>
        <input type="text" id="gender" class="form-control" name="gender"><br>
        <label>联系方式</label>
        <input type="text" id="phone" class="form-control" name="phone"><br>
        <label>省份</label>
        <input type="text" id="provincee" class="form-control" name="province"><br>
        <label>受教育程度</label>
        <input type="text" id="education" class="form-control" name="education"><br>
        <label>爱好</label>
        <input type="text" id="hobbies" class="form-control" name="hobbies"><br>
        <label>自我介绍</label>
        <input type="text" id="selfintro" class="form-control" name="selfintro"><br>
        <label for="inputEmail">邮箱地址</label>
        <input type="email" id="inputEmail" class="form-control" required name="email"><br>
        <label for="inputPassword">请输入密码</label>
        <input type="password" id="inputPassword" class="form-control" required name="password"><br>
        <label for="inputPassword">再次输入密码</label>
        <input type="password" id="inputSamePassword" class="form-control" required name="samepassword">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
    </form>

</div> <!-- /container -->


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="style/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
