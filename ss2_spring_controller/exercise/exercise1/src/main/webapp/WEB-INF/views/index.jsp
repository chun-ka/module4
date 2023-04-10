<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 18/11/2022
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>Sandwich Condiments</h2>
  <form action="/save" method="post">
      <input type="checkbox" name="condiment" value="Lettuce">Lettuce
      <input type="checkbox" name="condiment" value="Tomato">Tomato
      <input type="checkbox" name="condiment" value="Mustard">Mustard
      <input type="checkbox" name="condiment" value="Sprouts">Sprouts
      <hr>
<%--    <select name="condiment">--%>
<%--        <option value="Lettuce">Lettuce</option>--%>
<%--        <option value="Tomato">Tomato</option>--%>
<%--        <option value="Mustard">Mustard</option>--%>
<%--        <option value="Sprouts">Sprouts</option>--%>
<%--    </select>--%>
    <button>save</button>
  </form>
    <c:forEach var="condiment" items="${condiments}">
        <span>${condiment}</span>
    </c:forEach>
  </body>
</html>
