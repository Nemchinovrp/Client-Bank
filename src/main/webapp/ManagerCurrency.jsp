<%@ page import="com.becomejavasenior.model.Currency" %>
<%@ page import="com.becomejavasenior.dao.impl.CurrencyDAOImpl" %>
<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 26.01.2016
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
  <%
    String id = request.getParameter("id");
    String name =request.getParameter("name");
    String rate =request.getParameter("rate");

    Currency currency = new Currency(Integer.parseInt(id), name, Double.parseDouble(rate));
    CurrencyDAOImpl currencyDAO = new CurrencyDAOImpl();
    currencyDAO.createCurrency(currency);
    response.sendRedirect("addCurrency");

  %>
</body>
</html>
