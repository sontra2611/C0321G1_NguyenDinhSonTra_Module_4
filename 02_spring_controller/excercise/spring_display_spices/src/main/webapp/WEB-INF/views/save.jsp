<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/15/2021
  Time: 10:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Các loại gia vị bạn đã chọn là :</h2>
<ul>
    <c:forEach items="${spices}" var="spice">
        <li>${spice}</li>
    </c:forEach>
</ul>
</body>
</html>
