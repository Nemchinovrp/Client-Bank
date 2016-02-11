<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 11.02.2016
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta http-equiv="CONTENT-TYPE" content="text/html" ; charset="UTF-8">
  <title>Add Transaction</title>
</head>
<body>
<form action="TransactionAddController.do" method="post">

  <fieldset>
    <div>
      <%--@declare id="id"--%><label for="id">Id</label>
      <input type="text" name="id" value="<c:out value="${transaction.id}"/>" placeholder="ID"/>
    </div>
    <div>
      <%--@declare id="idAccount"--%><label for="idAccount">Account</label>
      <input type="text" name="idAccount" value="<c:out value="${transaction.idAccount}"/>"
             placeholder="idAccount"/>
    </div>
    <div>
      <%--@declare id="operation"--%><label for="operation">Operation</label>
      <input type="text" name="operation" value="<c:out value="${transaction.operation}"/>" placeholder="operation"/>
    </div>
    <div>
      <%--@declare id="amount"--%><label for="amount">Amount</label>
      <input type="text" name="amount" value="<c:out value="${transaction.amount}"/>" placeholder="amount"/>
    </div>
    <div>
      <input type="submit" value="Submit">
    </div>
  </fieldset>

</form>
