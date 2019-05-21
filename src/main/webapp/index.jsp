<%--
  Created by IntelliJ IDEA.
  User: lj
  Date: 2019/5/12
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        String path=request.getContextPath();
    %>
</head>
<body style="align:center;height: 200px;width: 300px">

<table style="align:center;height: 170px;width: 280px;">
   <tr>
       <td>用户名 ：</td>
       <td>
           <input type="text" id="user">
       </td>
   </tr>
   <tr>
       <td>密码 :</td>
       <td>
           <input type="text" id="pwd">
       </td>
   </tr>
   <tr>
       <td colspan="2">
           <button type="button" value="">登录</button>

           <button type="button" value="">注册</button>
       </td>
   </tr>
</table>
<script>

    function land(){
        $.ajax({
            url:<%=path%>'/LendServlet',
            method:'post',
            param:{
                "username":$("#user").val(),
                "userpwd":$("#pwd").val()
            }
        })
    }
</script>
</body>
</html>
