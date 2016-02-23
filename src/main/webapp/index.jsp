<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <style>
        <%@include file="/WEB-INF/css/bootstrap.css"%>
        <%@include file="/WEB-INF/css/jquery-ui.css"%>
    </style>
    <script type="text/javascript" src="/resources/jquery-2.2.0.js"></script>
    <script type="text/javascript" src="/resources/js/calendar.js"></script>
    <script type="text/javascript" src="/resources/js/jquery-ui.js"></script>

    <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/ui-lightness/jquery-ui.css" rel="stylesheet" type="text/css"/>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
    <script>
        $(document).ready(function() {
            $("#datepicker").datepicker({
                dateFormat: "yy-mm-dd"
            });
        });
    </script>
    <title>Client-Bank</title>
</head>
<body>
<br>
<a class="text-primary" href="/AdminUserListController?action=listUser">Registration user</a>
<br>
<br>
<a class="text-primary" href="/PaymasterAccountListController?action=listAccount">Account</a>
<br>

<br>
<a class="text-primary" href="/ClientTransactionListController?action=listTransaction">Transaction</a>
<br>
<input type = "text" id ="datepicker" />

<script type="text/javascript" src="/WEB-INF/js/jquery-2.2.0.js"></script>
<script type="text/javascript" src="/WEB-INF/js/calendar.js"></script>
<script type="text/javascript" src="/WEB-INF/js/jquery-ui.js"></script>
</body>
</html>