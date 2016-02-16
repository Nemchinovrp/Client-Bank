<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 10.02.2016
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="CONTENT-TYPE" content="text/html" ; charset="UTF-8">
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
    <title>Account</title>
</head>
<body>
<table class="table table-bordered table-hover">
    <thead class="thead-inverse">
    <tr>
        <th>Id</th>
        <th>Account Type</th>
        <th>Currency</th>
        <th>Balance</th>
        <th>User</th>
        <th>Action</th>
    </tr>
    </thead>
    <c:forEach items="${accounts}" var="account">
        <tr>
            <td>${account.id}</td>
            <td>${account.accountType}</td>
            <td>${account.idCurrency}</td>
            <td>${account.balance}</td>
            <td>${account.usersId}</td>
            <td><a href="AdminAccountDeleteController?action=delete&id=<c:out value="${account.id}"/>">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<p>
    <a href="AdminAccountListController?action=insert">Add Account</a>
</p>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
</body>
</html>
