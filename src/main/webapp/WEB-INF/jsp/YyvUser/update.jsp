<%--
  Created by IntelliJ IDEA.
  User: 谢云龙
  Date: 2022/3/12
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
       <form action="update" onsubmit="return tijiao()" method="post">
           <input type="hidden" name="id" value="${yyvUser.id}">
           <table border="1px" style="width: 300px;text-align: center;margin: 0 auto">
               <tr><td colspan="2">欢迎来到用户修改页面</td></tr>
               <tr><td colspan="2" style="color: red">${error}</td></tr>
               <tr>
                   <td>会员号</td>
                   <td><input type="text" name="userCode" value="${yyvUser.userCode}" disabled="disabled"></td>
               </tr>
               <tr>
                   <td>会员名称</td>
                   <td><input type="text"name="userName" value="${yyvUser.userName}"></td>
               </tr>
               <tr>
                   <td>会员手机号</td>
                   <td><input type="text"name="phone" value="${yyvUser.phone}"></td>
               </tr>
               <tr>
                   <td>总消费</td>
                   <td><input type="text"name="sumjin" value="${yyvUser.sumjin}"></td>
               </tr>
               <tr>
                   <td>余额</td>
                   <td><input type="text"name="yuE" value="${yyvUser.yuE}"></td>
               </tr>
               <tr>
                   <td>消费次数</td>
                   <td><input type="text"name="zcount" value="${yyvUser.zcount}"></td>
               </tr>
               <tr>
                   <td colspan="2"><input type="submit" value="修改">&nbsp;&nbsp;&nbsp;<button onclick="javaScript:window.history.go(-1)">返回</button></td>
               </tr>
           </table>
       </form>
    </div>
</body>
<script src="../../../statics/js/jquery-1.8.3.min.js"></script>
<script>
    function tijiao() {
       var userName=$("[name=userName]").val();
       var sumjin=$("[name=sumjin]").val();
       var yuE=$("[name=yuE]").val();
       var zcount=$("[name=zcount]").val();
       if(userName==null||sumjin==null||yuE==null||zcount==null){
           alert("请补充用户完整信息不能为空");
           return false;
       }
       return true;
    }
</script>
</html>
