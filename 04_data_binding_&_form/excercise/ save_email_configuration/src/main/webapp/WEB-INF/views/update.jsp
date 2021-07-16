<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/16/2021
  Time: 10:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <style>
        th {
            text-align: left;
            height: 50px;
        }
    </style>
</head>
<body>
<h1>Settings</h1>
<form:form action="update" method="post" modelAttribute="emailBox">
    <table>
        <tr>
            <th><form:label path="languages">Languages :</form:label></th>
            <td>
                <form:select path="languages">
                    <form:option value="English">English</form:option>
                    <form:option value="Vietnamese">Vietnamese</form:option>
                    <form:option value="Japanese">Japanese</form:option>
                    <form:option value="Chinese">Chinese</form:option>
                </form:select>
            </td>
        </tr>

        <tr>
            <th><form:label path="pageSize">Page Size :</form:label></th>
            <td>
                <form:select path="pageSize">
                    <form:option value="5">5</form:option>
                    <form:option value="10">10</form:option>
                    <form:option value="15">15</form:option>
                    <form:option value="25">25</form:option>
                    <form:option value="50">50</form:option>
                    <form:option value="100">100</form:option>
                </form:select>
                emails per page
            </td>
        </tr>

        <tr>
            <th><form:label path="spamFillter">Spams fillter :</form:label></th>
            <td><form:checkbox path="spamFillter" value="true"/>Enables spam fillter</td>
        </tr>

        <tr>
            <th><form:label path="signature">Signature :</form:label></th>
            <td><form:textarea path="signature"/></td>
        </tr>

        <tr>
            <td></td>
            <td><form:button>Update</form:button></td>
        </tr>
    </table>
</form:form>
</body>
</html>
