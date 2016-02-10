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
<form action="AccountListController.do" method="post">

    <fieldset>
        <div>
            <%--@declare id="id"--%><label for="id">Id</label>
            <input type="text" name="id" value="<c:out value="${account.id}"/>" placeholder="ID"/>
        </div>
        <div>
            <%--@declare id="accountType"--%><label for="accountType">Account Type</label>
            <input type="text" name="accountType" value="<c:out value="${account.accountType}"/>"
                   placeholder="accountType"/>
        </div>
        <div>
            <%--@declare id="currency"--%><label for="currency">Currency</label>
            <input type="text" name="currency" value="<c:out value="${account.idCurrency}"/>" placeholder="currency"/>
        </div>
        <div>
            <%--@declare id="balance"--%><label for="balance">Balance</label>
            <input type="text" name="balance" value="<c:out value="${account.balance}"/>" placeholder="balance"/>
        </div>
        <div>
            <%--@declare id="user"--%><label for="user">User</label>
            <input type="text" name="user" value="<c:out value="${account.userId}"/>" placeholder="user"/>
        </div>

    </fieldset>

</form>

</body>
</html>
