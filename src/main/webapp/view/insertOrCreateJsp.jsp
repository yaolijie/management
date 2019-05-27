<%--
  Created by IntelliJ IDEA.
  User: lj
  Date: 2019/5/26
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path=request.getContextPath();
%>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">

    function createTable() {
        $.ajax({
            url:'<%=path%>/LoadServlet?method=create',
            method:'get',
            param:{
                "username":$("#user").val(),
                "userpwd":$("#pwd").val()
            }
        });
    }

</script>
<div align="center">
    <table>
        <tr>
            <td colspan="2"><button type="button" value="" onclick="createTable();">创建表</button></td>
        </tr>
    </table>
</div>