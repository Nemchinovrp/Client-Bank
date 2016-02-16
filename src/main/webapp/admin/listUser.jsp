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
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
    <title>User</title>
</head>
<body>
<table class="table table-bordered table-hover">
    <thead class="thead-inverse">
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
            <td>${user.registrationDate}</td>
            <td>${user.gender}</td>
            <td>${user.role}</td>
            <td><a href="AdminUserDeleteController.do?action=delete&id=<c:out value="${user.id}"/>">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<p>
    <a href="AdminUserListController.do?action=insert">Add User</a>
</p>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
</body>
</html>
