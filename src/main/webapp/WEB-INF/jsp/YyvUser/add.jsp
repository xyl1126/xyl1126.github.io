<%--
  Created by IntelliJ IDEA.
  User: 谢云龙
  Date: 2022/3/12
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <div>
       <form action="add" onsubmit="return tijiao()" method="post">
           <table border="1px" style="width: 300px;text-align: center;margin: 0 auto">
               <tr><td colspan="2">欢迎来到用户修改页面</td></tr>
               <tr><td colspan="2" style="color: red">${error}</td></tr>
               <tr>
                   <td>会员名称</td>
                   <td><input type="text"name="userName" ></td>
               </tr>
               <tr>
                   <td>会员手机号</td>
                   <td><input type="text" name="phone"></td>
               </tr>
               <tr>
                   <td colspan="2"><input type="submit" value="添加">&nbsp;&nbsp;&nbsp;<button onclick="javaScript:window.history.go(-1)">返回</button></td>
               </tr>
           </table>
       </form>
   </div>
<script src="../../../statics/js/jquery-1.8.3.min.js"></script>
   <script>
       function tijiao() {
           var userName=$("[name=userName]").val();
           if(userName==null){
               alert("会员名不能为空");
               return false;
           }
           return true;
       }
   </script>

</body>
</html>
