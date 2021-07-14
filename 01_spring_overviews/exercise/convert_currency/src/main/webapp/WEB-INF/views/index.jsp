<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/14/2021
  Time: 10:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>currency converter</title>
</head>
<body>
<form method="post" action="/result">
    <div>
        <label>Rate: </label>
        <input type="text" name="rate" placeholder="Rate" value="23000"><br>
    </div>

    <div style="margin: 5px 0px">
        <label>USD: </label>
        <input type="text" name="usd" placeholder="USD" value="0"><br>
    </div>
    <input type="submit" id="submit" value="Convert">
</form>
</body>
</html>
