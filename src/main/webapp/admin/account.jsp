<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 10.02.2016
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="CONTENT-TYPE" content="text/html" ; charset="UTF-8">
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
    <title>Add Account</title>
</head>
<body>
<div  class="text-center" style="padding:200px 0">

<form  action="AdminAccountAddController" method="post">

    <fieldset>
        <div class="form-group">
            <%--@declare id="id"--%><label for="id"> Id </label>
                <input type="text"  name="id" value="<c:out value="${account.id}"/>" placeholder="ID"/>
        </div>
        <div class="form-group">
            <label>Account</label>
            <select id='checkAccount' name='accountType'>
                <option value='Credit'>CREDIT</option>
                <option value='Debit'>DEBIT</option>
            </select>
        </div>
        <div class="form-group">
            <label>Currency</label>
            <select id='check' name='idCurrency'>
                <option value='1'>EUR</option>
                <option value='2'>USD</option>
                <option value='3'>RUB</option>
            </select>
        </div>
        <div class="form-group">
            <%--@declare id="balance"--%><label for="balance">Balance</label>
            <input type="text" name="balance" value="<c:out value="${account.balance}"/>" placeholder="balance"/>
        </div>
        <div class="form-group">
            <%--@declare id="usersId"--%><label for="usersId">User</label>
            <input type="text" name="usersId" value="<c:out value="${account.usersId}"/>" placeholder="user"/>
        </div>
        <div>
            <button type="submit" class="btn-success" >Add Account</button>
        </div>
    </fieldset>

</form>

</div>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
</body>
</html>
