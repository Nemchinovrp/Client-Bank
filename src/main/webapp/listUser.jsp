<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 28.01.2016
  Time: 12:55
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
    <th>First Name</th>
    <th>Last Name</th>
    <th>Email</th>
    <th>Password</th>
    <th>Date of birth</th>
    <th>Registration Date</th>
    <th>Gender</th>
    <th>Role</th>
    <th>Action</th>
    <th>Action</th>
  </tr>
  </thead>
  <c:forEach items="${users}" var="user">
    <tr>
      <td>${user.id}</td>
      <td>${user.firstName}</td>
      <td>${user.lastName}</td>
      <td>${user.email}</td>
      <td>${user.password}</td>
      <td>${user.dateOfBirth}</td>
      <td>${user.registartionDate}</td>
      <td>${user.gender}</td>
      <td>${user.id}</td>
      <td>${user.name}</td>
      <td>${user.rate}</td>
      <td>${user.role}</td>
      <td><a href="CurrencyController.do?action=edit&id=<c:out value="${currency.id}"/>">Update</a></td>
      <td><a href="CurrencyController.do?action=delete&id=<c:out value="${currency.id}"/>">Delete</a></td>
    </tr>
  </c:forEach>
</table>
<p>
  <a href="CurrencyController.do?action=insert">Add Currency</a>
</p>

</body>
</html>
