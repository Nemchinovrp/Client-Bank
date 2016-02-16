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
    <title>Add Account</title>
</head>
<body>
<form action="AccountAddController" method="post">

    <fieldset>
        <div>
            <%--@declare id="id"--%><label for="id">Id</label>
            <input type="text" name="id" value="<c:out value="${account.id}"/>" placeholder="ID"/>
        </div>
        <div>
            <label>Account</label>
            <select id='checkAccount' name='accountType'>
                <option value='Credit'>CREDIT</option>
                <option value='Debit'>DEBIT</option>
            </select>
        </div>
        <div>
            <label>Currency</label>
            <select id='check' name='idCurrency'>
                <option value='1'>EUR</option>
                <option value='2'>USD</option>
                <option value='3'>RUB</option>
            </select>
        </div>
        <div>
            <%--@declare id="balance"--%><label for="balance">Balance</label>
            <input type="text" name="balance" value="<c:out value="${account.balance}"/>" placeholder="balance"/>
        </div>
        <div>
            <%--@declare id="usersId"--%><label for="usersId">User</label>
            <input type="text" name="usersId" value="<c:out value="${account.usersId}"/>" placeholder="user"/>
        </div>
        <div>
            <input type="submit" value="Submit">
        </div>
    </fieldset>

</form>

</body>
</html>