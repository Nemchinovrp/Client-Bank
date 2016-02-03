<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 02.02.2016
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="CONTENT-TYPE" content="text/html" ; charset="UTF-8">
    <title>Add New User</title>
</head>
<form action="LoginController.do" method="post">

    <fieldset>
        <div>
            <%--@declare id="firstName"--%><label for="firstName">First Name</label>
            <input type="text" name="firstName" value="<c:out value="${user.firstName}"/>" placeholder="name"/>
        </div>
        <div>
            <%--@declare id="password"--%><label for="password">Password</label>
            <input type="text" name="password" value="<c:out value="${user.password}"/>" placeholder="password"/>
        </div>
        <div>
            <input type="submit" value="Submit">
        </div>
    </fieldset>
</form>
</body>
</html>
