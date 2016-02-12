package com.becomejavasenior.controllers;

import com.becomejavasenior.dao.AccountDAO;
import com.becomejavasenior.dao.impl.AccountDAOImpl;
import com.becomejavasenior.model.Account;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Roman on 10.02.2016.
 */
@WebServlet("/AccountAddController")
public class AccountAddController extends HttpServlet {
    public static final String LIST_ACCOUNT = "/listAccount.jsp";
    static final Logger logger = LogManager.getRootLogger();
    private AccountDAO dao;

    public AccountAddController() {
        dao = new AccountDAOImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("begin add object account");
        Account account = new Account();
        account.setId(Integer.parseInt(request.getParameter("id")));
        account.setAccountType(request.getParameter("accountType"));
        account.setIdCurrency(Integer.parseInt(request.getParameter("idCurrency")));
        account.setBalance(Double.parseDouble(request.getParameter("balance")));
        account.setUsersId(Integer.parseInt(request.getParameter("usersId")));
        dao.createAccount(account);
        logger.info("end add object account");
        RequestDispatcher view = request.getRequestDispatcher(LIST_ACCOUNT);
        request.setAttribute("accounts", dao.getAllAccount());
        view.forward(request, response);
    }
}
