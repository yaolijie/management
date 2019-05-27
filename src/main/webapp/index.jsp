<%--
  Created by IntelliJ IDEA.
  User: lj
  Date: 2019/5/12
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <%
        String path=request.getContextPath();
    %>
    <script>
        function land(){
            $.ajax({
                url:'<%=path%>/LendServlet',
                method:'post',
                param:{
                    "username":$("#user").val(),
                    "userpwd":$("#pwd").val()
                }
            });
        }

        function insertJsp() {
            window.location="view/register.jsp";
        }

        function insertOrCreateJsp() {
            window.location="view/insertOrCreateJsp.jsp";
        }
    </script>
</head>
<body align="center" border="2">

<table align="center" style="align:center;height: 170px;width: 280px;" >
   <tr>
       <td>用户名：</td>
       <td>
           <input type="text" id="user">
       </td>
   </tr>
   <tr>
       <td>密码:</td>
       <td>
           <input type="text" id="pwd">
       </td>
   </tr>
   <tr align="center">
       <td colspan="2">
           <button type="button" value="" onclick="land();">登录</button>

           <button type="button" value="" onclick="insertJsp();">注册</button>
       </td>
   </tr>
    <tr>
        <td>
            <button value="" onclick="insertOrCreateJsp();">初始化数据</button>
        </td>
    </tr>
</table>
</body>
</html>
