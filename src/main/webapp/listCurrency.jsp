<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 25.01.16
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="CONTENT-TYPE" content="text/html" ; charset="UTF-8">
    <title>Currency</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Rate</th>
        <th>Action</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${currencies}" var="currency">
        <tr>
            <td><c:out value="${currency.id}"/></td>
            <td><c:out value="${currency.name}"/></td>
            <td><c:out value="${currency.rate}"/></td>
            <td><a href="CurrencyController.do?action=edit&id=<c:out value="${currency.id}"/>">Update</a></td>
            <td><a href="CurrencyController.do?action=delete&id=<c:out value="${currency.id}"/>">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p>
    <a href="CurrencyController.do?action=insert">Add Currency</a>
</p>

</body>
</html>
