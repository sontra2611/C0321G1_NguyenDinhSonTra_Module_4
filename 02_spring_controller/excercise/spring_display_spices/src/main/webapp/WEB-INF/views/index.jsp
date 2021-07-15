<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/15/2021
  Time: 9:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Sandwich Spices</h1>
<form method="get" action="save">
    <span><input type="checkbox" name="spice" value="Lettuce">Lettuce</span>
    <span><input type="checkbox" name="spice" value="Tomato">Tomato</span>
    <span><input type="checkbox" name="spice" value="Mustard">Mustard</span>
    <span><input type="checkbox" name="spice" value="Sprouts">Sprouts</span>
    <hr style="border: inset 3px">
    <span><input type="submit" value="save"></span>
</form>
</body>
</html>
