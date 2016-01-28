<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 27.01.2016
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="CONTENT-TYPE" content="text/html" ; charset="UTF-8">
    <title>Add New Currency</title>
</head>
<body>
<form action="CurrencyController.do" method="post">

    <fieldset>
        <div>
            <%--@declare id="id"--%><label for="id">Id</label>
            <input type="text" name="id" value="<c:out value="${currency.id}"/>"  placeholder="ID"/>
        </div>
        <div>
            <%--@declare id="name"--%><label for="name">Name</label>
            <input type="text" name="name" value="<c:out value="${currency.name}"/>"  placeholder="NAME"/>
        </div>
        <div>
            <%--@declare id="rate"--%><label for="rate">Rate</label>
            <input type="text" name="rate" value="<c:out value="${currency.rate}"/>"  placeholder="RATE"/>
        </div>
        <div>
            <input type="submit" value="Submit">
        </div>

    </fieldset>

</form>

</body>
</html>
