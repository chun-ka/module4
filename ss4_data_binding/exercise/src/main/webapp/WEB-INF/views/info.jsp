<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 22/11/2022
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>Languages  </td>
        <td>${mailbox.language}</td>
    </tr>
    <tr>
        <td>Page Size:   </td>
        <td>${mailbox.size}</td>
    </tr>
    <tr>
        <td>Spams filter:    </td>
        <td>${mailbox.spams}</td>
    </tr>
    <tr>
        <td>Signature:   </td>
        <td>${mailbox.signature}</td>
    </tr>
</table>
</body>
</html>
