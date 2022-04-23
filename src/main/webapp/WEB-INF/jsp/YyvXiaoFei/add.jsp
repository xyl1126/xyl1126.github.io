<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 谢云龙
  Date: 2022/3/16
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form  action="home" id="fm" onsubmit="return tj()">
        <input type="hidden" name="userId" value="">
        <table border="1px" style="text-align: center;width: 500px;margin: 0 auto">
            <tr><td colspan="2"><h1>欢迎来到会员添加页</h1></td></tr>
            <tr>
                <td>请输入会员号：</td>
                <td><input type="text" name="userCode"><span id="sp" style="color: red"></span></td>
            </tr>
            <tr>
                <td>会员名称：</td>
                <td><input type="text" name="userName" readonly="readonly"></td>
            </tr>
            <tr>
                <td>消费总金额：</td>
                <td><input type="text" name="sumjin" readonly="readonly"></td>
            </tr>
            <tr>
                <td>请输入本次消费金额：</td>
                <td><input type="text" name="benci"></td>
            </tr>
            <tr>
                <td>请选择本次消费类型：</td>
                <td><select name="spId">
                    <c:forEach items="${yyvSpList}" var="sp">
                        <option value="${sp.id}">${sp.spName}</option>
                    </c:forEach>
                </select></td>
            </tr>
            <tr>
                <td>余额：</td>
                <td><input type="text" name="benciyuE" readonly="readonly"></td>
            </tr>
            <tr><td colspan="2"><input type="submit" value="提交">    <button onclick="javaScript:window.history.go(-1)">返回</button></td></tr>
        </table>

    </form>
</div>
<script src="${pageContext.request.contextPath}/statics/js/jquery-1.8.3.min.js"></script>
<script>
    $("[name=userCode]").blur(function () {
        var userCode=$(this).val();
        $.get("/user/userCodeAjax",{"userCode":userCode},function (data) {
            if(data==""||data==null){
                $("#sp").text("会员号不存在");
                $("[name=userName]").val("");
                $("[name=sumjin]").val("");
                $("[name=benciyuE]").val("");
                $("[name=userId]").val("");
            }else{
                $("[name=userName]").val(data.userName);
                $("[name=sumjin]").val(data.sumjin);
                $("[name=benciyuE]").val(data.yuE);
                $("[name=userId]").val(data.id);
                $("#sp").text(" ");
            }
        })
    });
        function tj() {
            var userCode=$("[name=userCode]").val();
            var benci=$("[name=benci]").val();
            if(userCode==null||benci==null||userCode==""||benci==""){
                alert("请填写完整信息");
                return false;
            }else {
                $.get("/show/add",$("#fm").serialize(),function (data) {
                    if(data==true){
                        alert("添加成功");
                        return true;
                    }else {
                        alert("添加失败,余额不足");
                        return false;
                    }
                });
            }
            return true;
        }


</script>

</body>
</html>
