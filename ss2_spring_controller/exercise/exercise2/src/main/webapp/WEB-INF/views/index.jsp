<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 18/11/2022
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Caculator</h1>
<form action="" method="post">
    <input type="number" placeholder="number1" name="number1">
    <select name="calculate">
        <option value="+">+</option>
        <option value="-">-</option>
        <option value="*">*</option>
        <option value="/">/</option>
    </select>
    <input type="number" placeholder="number2" name="number2">
    <input type="submit" value="result">
</form>
<p>${result}</p>
</body>
</html>
