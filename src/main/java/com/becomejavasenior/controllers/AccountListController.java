package com.becomejavasenior.controllers;

import com.becomejavasenior.dao.AccountDAO;
import com.becomejavasenior.dao.impl.AccountDAOImpl;
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
@WebServlet("/PaymasterAccountListController")
public class AccountListController extends HttpServlet {
    public static final String LIST_ACCOUNT = "/admin/listAccount.jsp";
    public static final String INSERT_OR_EDIT = "/admin/account.jsp";
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

}
