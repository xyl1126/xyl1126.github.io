<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 谢云龙
  Date: 2022/3/13
  Time: 2:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    ul{ list-style: none}
    ul li{display: inline-block}
</style>
<body>
<div style="text-align: center">
    <table border="1px" id="tab" style="width: 1000px;text-align: center;margin: auto">
        <tr><td colspan="9">欢迎来到主页</td></tr>
        <tr><td colspan="2">请输入会员号：</td>
            <td colspan="2"><input type="text" name="userCode"></td>
            <td colspan="2">请输入会员名称：</td>
            <td colspan="2"><input type="text" name="userName"></td>
            <td><button onclick="fenye()">查询</button></td>
        </tr>

        <tr>
            <td colspan="4"><a href="/sp/list">去往商品管理页</a></td>
            <td colspan="4"><a href="/user/home">去往会员管理页</a></td>
            <td><a href="toAdd">添加会员消费记录</a></td>
        </tr>
        <tr  id="di3">
            <td>消费编号</td>
            <td>会员号</td>
            <td>会员名称</td>
            <td>总消费金额</td>
            <td>消费商品</td>
            <td>本次消费</td>
            <td>余额</td>
            <td>本次消费时间</td>
            <td>删除操作</td>
        </tr>
    </table>
    <ul id="pa"></ul>
</div>
<script src="../../../statics/js/jquery-1.8.3.min.js"></script>
<script>
    $(function () {
      fenye();  
    });
    function fenye(pageIndex) {
        var userName=$("[name=userName]").val();
        var userCode=$("[name=userCode]").val();
        $.get("/show/list",{"userName":userName,"userCode":userCode,"pageIndex":pageIndex},function (data) {
            if(data!=null){
                $("#di3").nextAll().remove();
                $("#pa li").remove();
                for (var i=0;i<data.yyvXiaoFeis.length;i++){
                    $("#tab").append("<tr id='r"+data.yyvXiaoFeis[i].id+"'><td>"+data.yyvXiaoFeis[i].id+"</td>" +
                        "<td>"+data.yyvXiaoFeis[i].userCode+"</td>" +
                        "<td>"+data.yyvXiaoFeis[i].userName+"</td>" +
                        "<td>"+data.yyvXiaoFeis[i].sumjin+"</td>" +
                        "<td>"+data.yyvXiaoFeis[i].spName+"</td>" +
                        "<td>"+data.yyvXiaoFeis[i].benci+"</td>" +
                        "<td>"+data.yyvXiaoFeis[i].benciyuE+"</td>" +
                        "<td>"+data.yyvXiaoFeis[i].xTime+"</td>"+
                        "<td><a href='javaScript:del("+data.yyvXiaoFeis[i].id+")'>删除</a></td>"+
                        "</tr>")

                }
                var shang="";
                if(data.currentPageNo>1){
                    shang="<li><a href='javascript:fenye("+(data.currentPageNo-1)+")'>上一页</a></li>";
                }
                var xia="";
                if(data.currentPageNo<data.totalPageCount){
                    xia="<li><a href='javascript:fenye("+(data.currentPageNo+1)+")'>下一页</a></li>"
                }

                $("#pa").append("<li><a href='javascript:fenye("+1+")'>首页</a></li>      "+shang+""+xia+"<li><a href='javascript:fenye("+data.totalPageCount+")'>尾页</a></li>    <li>"+data.currentPageNo+"/"+data.totalPageCount+"</li>")
            }
        },"json")
    }

    function del(id) {
        var con=confirm("确定要删除吗？");
        if(con){
            $.get("/show/del",{"id":id},function (data) {
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
