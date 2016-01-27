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
  <meta http-equiv="CONTENT-TYPE" content="text/html"; charset="UTF-8">
    <title>Currency</title>
</head>
<body>
  <div style="width: 1200px; margin-left: auto;margin-right:auto;">
    <table cellpadding="10">
      <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Rate</th>
      </tr>
      <c:forEach items="${viewCur}" var="p">
        <tr>
          <td>${p.id}</td>
          <td>${p.name}</td>
          <td>${p.rate}</td>
        </tr>
      </c:forEach>
    </table>
  </div>
</body>
</html>
