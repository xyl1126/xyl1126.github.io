<%--
  Created by IntelliJ IDEA.
  User: 谢云龙
  Date: 2022/3/12
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <style>
        ul{ list-style: none}
        ul li{display: inline-block}
    </style>
</head>
<body>
<div style="text-align: center">
    <table border="1px" id="tab" style="width: 1200px;text-align: center;margin: 0 auto">
        <tr><td colspan="12">欢迎来到用户页</td></tr>
        <tr><td colspan="3">请输入会员号：</td>
            <td colspan="2"><input type="text" name="userCode"></td>
            <td colspan="3">请输入会员名称：</td>
            <td colspan="2"><input type="text" name="userName"></td>
            <td colspan="2"><button onclick="ajaxfenye()">查询</button></td>
        </tr>
        <tr><td colspan="11"></td>
            <td><a href="toadd">添加</a></td>
        </tr>
        <tr id="di3">
            <td>用户编号</td>
            <td>会员号</td>
            <td>会员名称</td>
            <td>手机号</td>
            <td>总消费</td>
            <td>余额</td>
            <td>消费次数</td>
            <td>会员加入日期</td>
            <td>最后一次消费日期</td>
            <td>充值操作</td>
            <td>修改操作</td>
            <td>删除操作</td>
        </tr>

    </table>
    <ul id="pa"></ul>
    <a href="/show/home">去往消费页</a>
</div>
<script src="../../../statics/js/jquery-1.8.3.min.js"></script>
<script>
    function del(id) {
        var con=confirm("确定要删除吗,删除之后该用户的消费记录也随之删除");
        if(con){
            $.get("/user/del",{"id":id},function (data) {
                if(data){
                    alert("删除成功");
                    $("#r"+id).remove();
                }
            })
        }
    }
    function cj(id) {
        var jin=prompt("请输入充值的金额");
        if(isNaN(jin)){
            alert("请输入数字");
        }else {
            $.get("/user/cj",{"yuE":jin,"id":id},function (data) {
                if(data==true){

                    var yuE=parseFloat($("#yuE"+id).text());
                    var sum=parseFloat(jin);
                    var sum2=parseFloat(yuE+sum);
                    $("#yuE"+id).text(sum2);
                    alert("充值成功");

                }
            })
        }
    }
    $(function () {
        ajaxfenye();
    });
    function ajaxfenye(pageIndex) {
        var userName=$("[name=userName]").val();
        var userCode=$("[name=userCode]").val();
        $.get("/user/list",{"userName":userName,"userCode":userCode,"pageIndex":pageIndex},function (data) {
            if (data!=null){
                $("#di3").nextAll().remove();
                $("#pa li").remove();
                for (var i=0;i<data.yyvUsers.length;i++){
                    $("#tab").append("<tr id='r"+data.yyvUsers[i].id+"'><td>"+data.yyvUsers[i].id+"</td>" +
                        "<td>"+data.yyvUsers[i].userCode+"</td>" +
                        "<td>"+data.yyvUsers[i].userName+"</td>" +
                        "<td>"+data.yyvUsers[i].phone+"</td>" +
                        "<td>"+data.yyvUsers[i].sumjin+"</td>" +
                        "<td id='yuE"+data.yyvUsers[i].id+"'>"+data.yyvUsers[i].yuE+"</td>" +
                        "<td>"+data.yyvUsers[i].zcount+"</td>" +
                        "<td>"+data.yyvUsers[i].firstTime+"</td>" +
                        "<td>"+data.yyvUsers[i].lastTime+"</td>" +
                        "<td><a href='javaScript:cj("+data.yyvUsers[i].id+")'>充值</a></td>" +
                        "<td><a href='toupdate?id="+data.yyvUsers[i].id+"'>修改</a></td>" +
                        "<td><a href='javaScript:del("+data.yyvUsers[i].id+")'>删除</a></td>" +
                        "</tr>")
                }
                var shang="";
                if(data.currentPageNo>1){
                    shang="<li><a href='javascript:ajaxfenye("+(data.currentPageNo-1)+")'>上一页</a></li>";
                }
                var xia="";
                if(data.currentPageNo<data.totalPageCount){
                    xia="<li><a href='javascript:ajaxfenye("+(data.currentPageNo+1)+")'>下一页</a></li>"
                }
                $("#pa").append("<li><a href='javascript:ajaxfenye("+1+")'>首页</a></li>"+shang+""+xia+"<li><a href='javascript:ajaxfenye("+data.totalPageCount+")'>尾页</a></li><li>"+data.currentPageNo+"/"+data.totalPageCount+"</li>")

            }
        },"json")
    }

</script>
</body>
</html>
