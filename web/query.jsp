<%@ page import="com.cs.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/6
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script type="text/javascript">
        function ba() {
            history.back();
        }
    </script>
</head>
<body>
 <%
     User us=(User)request.getAttribute("us");
 %>
<form action="list.jsp" method="post">
    <table align="center" width="500px" border="1">
        <tr height="40px" align="center">
            <td colspan="2"><strong>用户信息</strong></td>
        </tr>
        <tr height="40px">
            <td align="right">编号：</td>
            <td>
                ${us.id}
            </td>
        </tr>
        <tr height="40px">
            <td align="right">用户名：</td>
            <td>
                ${us.username}
            </td>
        </tr>
        <tr height="40px">
            <td align="right">密码：</td>
            <td>
                ${us.password}
            </td>
        </tr>
        <tr height="40px">
            <td align="right">性别：</td>
            <td>
                ${us.sex}
            </td>
        </tr>
        <tr height="40px">
            <td></td>
            <td>
                <input type="button" value="返回" onclick="ba()"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
