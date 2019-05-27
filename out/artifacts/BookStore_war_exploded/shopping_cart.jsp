<%--
  Created by IntelliJ IDEA.
  User: rsh
  Date: 2019/5/20
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="style/images/favicon.ico">

    <title>个人信息</title>

    <!-- Bootstrap core CSS -->
    <link href="style/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="style/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="style/css/dashboard.css" rel="stylesheet">

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

<nav class="navbar navbar-inverse navbar-fixed-top">
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
            <ul class="nav navbar-nav navbar-right">
                <li><a href="home?userid=${userid}">${username}</a></li>
                <li><a href="signup.jsp">注册</a></li>
                <li><a href="help.jsp">帮助</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li><a href="home?userid=${userid}">个人信息 <span class="sr-only">(current)</span></a></li>
                <li class="active"><a href="shopping_cart?userid=${userid}">购物车</a></li>
                <li><a href="purchase_record">购买记录</a></li>
                <li><a href="#">浏览记录</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <!-- Main component for a primary marketing message or call to action -->
            <c:forEach var="U" items="${carts}">
                <div class="jumbotron">
                    <div class="row-fluid">
                        <div class="span12"></div>
                        <div class="span12 pull-right">
                            <table class="table table-striped">
                                <tbody>
                                <tr>
                                    <td>书名</td>
                                    <td>${U.book_name}</td>
                                    <td style="width: 400px"></td>
                                </tr>
                                <tr>
                                    <td>单价</td>
                                    <td>${U.price}</td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>数量</td>
                                    <td>${U.book_number}</td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>总价</td>
                                    <td>${U.goods_price}</td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>提交时间</td>
                                    <td>${U.time}</td>
                                    <td></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="row-fluid">
                        <div class="span12">
                            <a href="book_detail?ID=${U.book_id}">
                                <img src="${U.path}" width="135" height="189" alt="Generic placeholder image">
                            </a>
                        </div>
                    </div>
                    <br>
                    <div class="row-fluid">
                        <div class="span12">
                            <a class="btn btn-primary" href="deleteCart?order_id=${U.order_id}" role="button"
                               type="submit">删除</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="style/js/jquery.min.js"><\/script>')</script>
<script src="style/js/bootstrap.min.js"></script>
<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
<script src="style/js/holder.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="style/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
