<%--
  Created by IntelliJ IDEA.
  User: 谢云龙
  Date: 2022/3/12
  Time: 6:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form action="save" method="post" onsubmit="return baocun()">
        <input type="hidden" name="id" value="${yyvsp.id}">
        <table border="1px" style="width: 300px;text-align: center;margin: 0 auto">
            <tr><td colspan="2">欢迎来到商品修改页</td></tr>
            <tr>
                <td>请输入商品名称</td>
                <td><input type="text" name="spName" value="${yyvsp.spName}"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="保存">  <button onclick="javaScript:window.history.go(-1)">返回</button></td>
            </tr>
        </table>
    </form>
</div>
<script src="../../../statics/js/jquery-1.8.3.min.js"></script>
<script>
    function baocun() {
        var spName=$("[name=spName]").val();
        if (spName==null){
            alert("商品不能为空");
            return false;
        }
        return true;
    }
</script>
</body>
</html>
