<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 18/11/2022
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h2>Settings</h2>
<%--@elvariable id="maibox" type=""--%>
<form:form action="show" method="post" modelAttribute="maibox">
    <table>
        <tr>
            <th><pre>Languages          </pre></th>
            <td><form:select path="language" items="${languageList}" cssStyle="width: 200px" ></form:select> </td>
        </tr>
        <tr>
            <th><pre>Page Size:         </pre></th>
            <td>Show <form:select path="size" items="${sizeList}"></form:select> emails per page</td>
        </tr>
        <tr>
            <th><pre>Spams filter:      </pre></th>
            <td><form:checkbox path="spams"/> Enable spams filter</td>
        </tr>
        <tr>
            <th><pre>Signature:         </pre></th>
            <td><form:input path="signature" cssStyle="height: 50px;width: 200px"/></td>
        </tr>
        <tr>
            <th></th>
            <td>
                <button>Update</button>
                <button type="reset" style="margin-left: 20px">Cancel</button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
