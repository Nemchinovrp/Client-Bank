<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 11.02.2016
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta http-equiv="CONTENT-TYPE" content="text/html" ; charset="UTF-8">
  <title>Transaction</title>
</head>
<body>
<table>
  <thead>
  <tr>
    <th>Id</th>
    <th>Account</th>
    <th>Operation</th>
    <th>Amount</th>
    <th>Action</th>
  </tr>
  </thead>
  <c:forEach items="${transactions}" var="transaction">
    <tr>
      <td>${transaction.id}</td>
      <td>${transaction.idAccount}</td>
      <td>${transaction.operation}</td>
      <td>${transaction.amount}</td>
      <td><a href="TransactionDeleteController?action=delete&id=<c:out value="${transaction.id}"/>">Delete</a></td>
    </tr>
  </c:forEach>
</table>
<p>
  <a href="TransactionListController.do?action=insert">Add Transaction</a>
</p>

</body>
</html>

