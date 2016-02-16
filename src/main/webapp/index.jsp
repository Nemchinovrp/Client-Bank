<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
    <title>Client-Bank</title>
</head>
<body>
<br>
<a href="/AdminUserListController?action=listUser">Registration user</a>
<br>
<br>
<a href="/AdminAccountListController?action=listAccount">Account</a>
<br>

<br>
<a href="/ClientTransactionListController?action=listTransaction">Transaction</a>
<br>


<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
</body>
</html>