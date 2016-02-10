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
    <title>Add New User</title>
</head>
<body>
<form action="UserListController.do" method="post">

    <fieldset>
        <div>
            <%--@declare id="id"--%><label for="id">Id</label>
            <input type="text" name="id" value="<c:out value="${user.id}"/>" placeholder="ID"/>
        </div>
        <div>
            <%--@declare id="firstName"--%><label for="firstName">First Name</label>
            <input type="text" name="firstName" value="<c:out value="${user.firstName}"/>" placeholder="First Name"/>
        </div>
        <div>
            <%--@declare id="lastName"--%><label for="lastName">Last Name</label>
            <input type="text" name="lastName" value="<c:out value="${user.lastName}"/>" placeholder="Last Name"/>
        </div>
        <div>
            <%--@declare id="email"--%><label for="email">Email</label>
            <input type="text" name="email" value="<c:out value="${user.email}"/>" placeholder="Email"/>
        </div>
        <div>
            <%--@declare id="password"--%><label for="password">Password</label>
            <input type="text" name="password" value="<c:out value="${user.password}"/>" placeholder="Password"/>
        </div>
        <div>
            <%--@declare id="dateOfBirth"--%><label for="dateOfBirth">Date of birth</label>
            <input type="text" name="dateOfBirth" value="<c:out value="${user.dateOfBirth}"/>"
                   placeholder="Date of birth"/>
        </div>
        <div>
            <%--@declare id="registrationDate"--%><label for="registrationDate">Registration date</label>
            <input type="text" name="registrationDate" value="<c:out value="${user.registrationDate}"/>"
                   placeholder="Registration date"/>
        </div>
        <div>
            <%--@declare id="idGender"--%><label for="idGender">idGender</label>
            <input type="text" name="idGender" value="<c:out value="${user.gender}"/>" placeholder="Gender"/>
        </div>
        <div>
            <%--@declare id="idRole"--%><label for="idRole">idRole</label>
            <input type="text" name="idRole" value="<c:out value="${user.role}"/>" placeholder="Role"/>
        </div>
        <div>
            <input type="submit" value="Submit">
        </div>
    </fieldset>

</form>

</body>
</html>