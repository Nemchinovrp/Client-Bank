package com.becomejavasenior.controllers;

import com.becomejavasenior.dao.AccountDAO;
import com.becomejavasenior.dao.impl.AccountDAOImpl;
import com.becomejavasenior.model.Account;
import com.becomejavasenior.model.Gender;
import com.becomejavasenior.model.Role;
import com.becomejavasenior.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Roman on 10.02.2016.
 */
public class AccountListController extends HttpServlet {
    public static final String LIST_ACCOUNT = "/listAccount.jsp";
    public static final String INSERT_OR_EDIT = "/account.jsp";
    static final Logger logger = LogManager.getRootLogger();
    private AccountDAO dao;

    public AccountListController() {
        dao = new AccountDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        logger.info("Account controller begin");
        if (action.equalsIgnoreCase("listAccount")) {
            forward = LIST_ACCOUNT;
            request.setAttribute("accounts", dao.getAllAccount());
        } else {
            forward = INSERT_OR_EDIT;

        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
        logger.info("Account controller end");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Account account = new Account();
        account.setId(Integer.parseInt(request.getParameter("id")));
        account.setAccountType(request.getParameter("firstName"));
        account.setId_currency(Integer.parseInt(request.getParameter("lastName")));
        account.setBalance(Double.parseDouble(request.getParameter("email")));
        account.setUsers_id(Integer.parseInt(request.getParameter("password")));

        dao.createAccount(account);
        RequestDispatcher view = request.getRequestDispatcher(LIST_ACCOUNT);
        request.setAttribute("accounts", dao.getAllAccount());
        view.forward(request, response);
    }
}
