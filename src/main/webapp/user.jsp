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
<form action="UserController.do" method="post">

  <fieldset>
    <div>
      <%--@declare id="id"--%><label for="id">Id</label>
      <input type="text" name="id" value="<c:out value="${user.id}"/>"  placeholder="ID"/>
    </div>
    <div>
      <%--@declare id="firstName"--%><label for="firstName">First Name</label>
      <input type="text" name="name" value="<c:out value="${user.firstName}"/>"  placeholder="NAME"/>
    </div>
    <div>
      <%--@declare id="lastName"--%><label for="lastName">Last Name</label>
      <input type="text" name="rate" value="<c:out value="${user.lastName}"/>"  placeholder="RATE"/>
    </div>
    <div>
      <%--@declare id="id"--%><label for="id">Id</label>
      <input type="text" name="id" value="<c:out value="${user.id}"/>"  placeholder="ID"/>
    </div>
    <div>
      <%--@declare id="firstName"--%><label for="firstName">First Name</label>
      <input type="text" name="name" value="<c:out value="${user.firstName}"/>"  placeholder="NAME"/>
    </div>
    <div>
      <%--@declare id="lastName"--%><label for="lastName">Last Name</label>
      <input type="text" name="rate" value="<c:out value="${user.lastName}"/>"  placeholder="RATE"/>
    </div>
    <div>
      <%--@declare id="id"--%><label for="id">Id</label>
      <input type="text" name="id" value="<c:out value="${user.id}"/>"  placeholder="ID"/>
    </div>
    <div>
      <%--@declare id="firstName"--%><label for="firstName">First Name</label>
      <input type="text" name="name" value="<c:out value="${user.firstName}"/>"  placeholder="NAME"/>
    </div>
    <div>
      <%--@declare id="lastName"--%><label for="lastName">Last Name</label>
      <input type="text" name="rate" value="<c:out value="${user.lastName}"/>"  placeholder="RATE"/>
    </div>
    <div>
      <input type="submit" value="Submit">
    </div>
  </fieldset>

</form>

</body>
</html>