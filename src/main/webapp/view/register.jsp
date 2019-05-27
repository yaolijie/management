<%--
  Created by IntelliJ IDEA.
  User: lj
  Date: 2019/5/24
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册用户</title>
    <style type="text/css">
        table{
            align-content: center;
            margin-top: 10px;
        }
        tr{
            margin: 10px 0 10px 0;
            align-content: center;
        }
    </style>
    <%
        String path=request.getContextPath();
    %>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">

    </script>
</head>
<body>
<form action=<%=path%>/InsertServlet method="post" style="align-items: center;" id="register">
    <table align="center">
        <tr>
            <td>用户名：</td>
            <td>
                <input type="text" name="name"  id="name">
            </td>
            <td>全名：</td>
            <td>
                <input type="text" name="nameFull"  id="namefull">
            </td>
        </tr>
        <tr>
            <td>性别：</td>
            <td>
                <input type="text" nenme="sex" id="sex">
            </td>
            <td>年龄：</td>
            <td>
                <input type="text" name="age" id="age">
            </td>
        </tr>
        <tr>
            <td>身份证号：</td>
            <td>
                <input type="text" name="userId" id="userId">
            </td>
        </tr>
        <tr>
            <td>学历：</td>
            <td>
                <input type="text" name="edu" id="edu">
            </td>

            <td>
                毕业学校：
            </td>
            <td>
                <input type="text" name="sch" id="sch">
            </td>
        </tr>
        <tr>
            <td>所在单位：</td>
            <td>
                <input type="text" name="dept" id="dept">
            </td>
        </tr>
        <tr>
            <td>密码：</td>
            <td>
                <input type="text" name="pwd" id="pwd">
            </td>
        </tr>
        <tr>
            <td>
                确认密码：
            </td>
            <td>
                <input type="text" name="qpwd" id="qpwd">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="注册">
            </td>
            <td>
                <input type="reset" value="重置">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
