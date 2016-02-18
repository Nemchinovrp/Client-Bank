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
    <style>
        <%@include file="/WEB-INF/css/bootstrap.css"%>
    </style>
    <title>Add New User</title>
</head>
<body>
<div class="container" style="padding:80px 0">
    <div class="row">
        <div class="col-md-offset-5 col-md-10">
            <form action="ClientUserAddController.do" method="post">
                <fieldset>
                    <div class="form-group">
                        <%--@declare id="id"--%><label for="id">Id</label>
                        <input type="text" name="id" value="<c:out value="${user.id}"/>" placeholder="ID"/>
                    </div>
                    <div class="form-group">
                        <%--@declare id="firstName"--%><label for="firstName">First Name</label>
                        <input type="text" name="firstName" value="<c:out value="${user.firstName}"/>"
                               placeholder="First Name"/>
                    </div>
                    <div class="form-group">
                        <%--@declare id="lastName"--%><label for="lastName">Last Name</label>
                        <input type="text" name="lastName" value="<c:out value="${user.lastName}"/>"
                               placeholder="Last Name"/>
                    </div>
                    <div class="form-group">
                        <%--@declare id="email"--%><label for="email">Email</label>
                        <input type="text" name="email" value="<c:out value="${user.email}"/>" placeholder="Email"/>
                    </div>
                    <div class="form-group">
                        <%--@declare id="password"--%><label for="password">Password</label>
                        <input type="text" name="password" value="<c:out value="${user.password}"/>"
                               placeholder="Password"/>
                    </div>
                    <div class="form-group">
                        <%--@declare id="dateOfBirth"--%><label for="dateOfBirth">Date of birth</label>
                        <input type="text" name="dateOfBirth" value="<c:out value="${user.dateOfBirth}"/>"
                               placeholder="Date of birth"/>
                    </div>
                    <div class="form-group">
                        <%--@declare id="registrationDate"--%><label for="registrationDate">Registration date</label>
                        <input type="text" name="registrationDate" value="<c:out value="${user.registrationDate}"/>"
                               placeholder="Registration date"/>
                    </div>
                    <div class="form-group"><input type="radio" name="gender" value="MAN"> MAN</input>
                        <input type="radio" name="gender" value="WOMAN"> WOMAN</input>
                    </div>
                    <div>
                        <div class="form-group">
                            <select id='check' name='role'>
                                <option value='CLIENT'>CLIENT</option>
                                <option value='PAYMASTER'>PAYMASTER</option>
                                <option value='ADMIN'>ADMIN</option>
                            </select>
                        </div>
                        <button type="submit" class="btn-success">Add User</button>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
</div>
</body>
</html>