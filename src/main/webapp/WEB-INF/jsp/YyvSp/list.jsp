<%--
  Created by IntelliJ IDEA.
  User: 谢云龙
  Date: 2022/3/12
  Time: 5:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align: center">
    <table style="text-align: center;width: 300px;margin: 0 auto">
        <tr><td colspan="4">欢迎来到商品增加页</td></tr>
        <tr><td><a href="toadd">添加商品</a></td></tr>
        <tr>
            <td>商品编号</td>
            <td>商品名称</td>
            <td>修改操作</td>
            <td>删除操作</td>
        </tr>
        <c:forEach items="${yyvSpList}" var="y">
            <tr id="r${y.id}">
                <td>${y.id}</td>
                <td>${y.spName}</td>
                <td><a href="update?id=${y.id}">修改</a></td>
                <td><a href="javaScript:del(${y.id})">删除</a></td>
            </tr>

        </c:forEach>

    </table>
    <a href="/show/home">去往消费页</a>
</div>
<script src="../../../statics/js/jquery-1.8.3.min.js"></script>
<script>
    function del(id) {
        var con=confirm("确定要删除吗,删除之后该商品的记录也会随之删除");
        if(con){
            $.get("/sp/del",{"id":id},function (data) {
                if(data){
                    alert("删除成功");
                    $("#r"+id).remove();
                }
                    })
        }

    }
</script>
</body>
</html>
