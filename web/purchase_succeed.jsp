<%--
  Created by IntelliJ IDEA.
  User: rsh
  Date: 2019/4/24
  Time: 15:56
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

    <title>书籍详情</title>

    <!-- Bootstrap core CSS -->
    <link href="style/css/bootstrap.min.css" rel="stylesheet">

    <link href="style/css/custom.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="style/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="style/css/navbar.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]>
    <script src="style/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="style/js/ie-emulation-modes-warning.js"></script>

    <script src="style/js/custom.js"></script>

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
                    <li><a href="index">首页</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="home?userid=${userid}">${username}</a></li>
                    <li><a href="signup.jsp">注册</a></li>
                    <li><a href="help.jsp">帮助</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
    </nav>


    <div class="alert alert-success" id="succeed">${succeed}</div>

    <!-- Main component for a primary marketing message or call to action -->
    <div class="jumbotron">
        <div class="row-fluid">
            <div class="span12">
                <h2>书籍详情</h2>
            </div>
            <div class="span12 pull-right">
                <table class="table table-striped">
                    <tbody>
                    <tr>
                        <td>书名</td>
                        <td>
                            <a name="book_id" class="custom">${book.name}</a>
                        </td>
                        <td style="width: 400px"></td>
                    </tr>
                    <tr>
                        <td>作者</td>
                        <td>
                            <a name="book_author" class="custom">${book.author}</a>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>语言</td>
                        <td>
                            <a name="book_language" class="custom">${book.language}</a>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>类别</td>
                        <td>
                            <a name="book_category" class="custom">${book.category}</a>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>是否包含光盘</td>
                        <td>
                            <a name="book_cdrom" class="custom">${book.cdrom}</a>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>上架时间</td>
                        <td>
                            <a name="book_on_sale_time" class="custom">${book.on_sale_time}</a>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>出版社</td>
                        <td>
                            <a name="book_publish_name" class="custom">${book.publish_name}</a>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>出版社地址</td>
                        <td>
                            <a name="book_publish_address" class="custom">${book.publish_address}</a>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>库存量</td>
                        <td>
                            <a name="book_num" class="custom">${book.book_num}</a>
                        </td>
                        <td></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="row-fluid">
            <div class="span12">
                <img src="${book.path}" width="235" height="330" alt="Generic placeholder image">
            </div>
        </div>
        <br>
        <div class="row-fluid">
            <div class="span12">
                <ul class="list-inline">
                    <li>
                        <p class="label label-primary">简介</p>
                    </li>
                </ul>
            </div>
        </div>
        <div class="row-fluid">
            <div class="span12">
                <ul class="list-inline">
                    <li>
                        <p>${book.content}</p>
                    </li>
                </ul>
            </div>
        </div>
        <div class="row-fluid">
            <div class="span12">
                <ul class="list-inline">
                    <li>
                        <p class="label label-primary">推荐</p>
                    </li>
                    <li>
                        <c:forEach begin="1" end="${book.commend}">
                            <img src="style/images/comment.png" alt="Generic placeholder image">
                        </c:forEach>
                    </li>
                </ul>
            </div>
        </div>
        <div class="row-fluid">
            <div class="span12">
                <ul class="list-inline">
                    <li>
                        <p class="label label-primary">价格</p>
                    </li>
                    <li>
                        <a name="book_price" class="custom" id="book_price">￥${book.price}</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="row-fluid">
            <div class="span12 text-center">
                <ul class="list-inline">
                    <li>
                        <label for="inputNum" class="sr-only">数量</label>
                        <input type="text" id="inputNum" class="form-control" placeholder="请输入购买数量，如：1" required
                               value="1" name="book_number">
                    </li>
                    <li>
                        <p>
                            <button class="btn btn-primary" data-toggle="modal" data-target="#myModal"
                                    onclick="purchase()">购买
                            </button>
                        </p>
                    </li>
                    <li>
                        <p>
                            <button class="btn btn-primary" href="#" role="button" type="submit">加入购物车</button>
                        </p>
                    </li>
                </ul>
            </div>
        </div>
    </div>

</div> <!-- /container -->
<form action="purchase" method="post">
    <!-- 模态框（Modal） -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">确认购买</h4>
                </div>
                <div class="modal-body">书名：${book.name}</div>
                <div class="modal-body">
                    <p>共<a id="book_num" name="number" class="custom">0</a>本</p>
                    <input type="hidden" value="${book.ID}" name="book_id">
                    <input type="hidden" value="1" id="number" name="book_number">
                </div>
                <div class="modal-body">
                    <p id="whole_price">共计0元</p>
                </div>
                <div class="modal-footer">
                    <a type="button" class="btn btn-default" data-dismiss="modal">取消</a>
                    <button type="submit" class="btn btn-primary" role="button">提交订单</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
</form>
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="style/js/jquery.min.js"><\/script>')</script>
<script src="style/js/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="style/js/ie10-viewport-bug-workaround.js"></script>
<script>
    function purchase() {
        var book_num = document.getElementById("inputNum").value;
        document.getElementById("book_num").innerText = book_num;
        document.getElementById("number").value = book_num;

        var price = '${book.price}';
        var whole = book_num * price;
        document.getElementById("whole_price").innerText = "共计￥" + whole + "元";
    }

    setTimeout(function () {
        $('#succeed').remove();
    }, 3000);
</script>
</body>
</html>

