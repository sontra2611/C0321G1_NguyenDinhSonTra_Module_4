<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/15/2021
  Time: 10:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form method="post" action="calculate">
  <fieldset>
    <legend>Calculator</legend>
    <table>
      <tr>
        <td>First operand: </td>
        <td><input name="firstOperand" type="text" value="${firstOperand}"></td>
      </tr>
      <tr>
        <td>Operator: </td>
        <td>
          <select name="operator">
            <option value="+" ${operator == 43 ? 'selected': ''}>Addition</option>
            <option value="-" ${operator == 45 ? 'selected': ''}>Subtraction</option>
            <option value="*" ${operator == 42 ? 'selected': ''}>Multiplication</option>
            <option value="/" ${operator == 47 ? 'selected': ''}>Division</option>
          </select>
        </td>
      </tr>
      <tr>
        <td>Second operand: </td>
        <td><input name="secondOperand" type="text" value="${secondOperand}"></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" value="Calculate"/></td>
      </tr>
    </table>
  </fieldset>
</form>

<h2>Result : <span>${result} ${message}</span></h2>
</body>
</html>
