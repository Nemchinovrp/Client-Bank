<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <style>
        <%@include file="/WEB-INF/css/bootstrap.css"%>
    </style>
    <title>Client-Bank</title>
</head>
<body>
<br>
<a class="text-primary" href="/AdminUserListController?action=listUser">Registration user</a>
<br>
<br>
<a class="text-primary" href="/AdminAccountListController?action=listAccount">Account</a>
<br>

<br>
<a class="text-primary" href="/ClientTransactionListController?action=listTransaction">Transaction</a>
<br>
</body>
</html>