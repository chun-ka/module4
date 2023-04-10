<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</head>
<body>
<div align="center" class="container">
    <%--@elvariable id="student" type=""--%>
    <form:form action="student" method="post" modelAttribute="student">
        <table border="1" cellpadding="5" >
            <tr>
                <td>ID</td>
                <td><form:input path="id" type="test"/></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><form:input path="name" type="test"/></td>
            </tr>
            <tr>
                <td>address</td>
                <td><form:input path="address" type="test"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button>save</button>
                </td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
