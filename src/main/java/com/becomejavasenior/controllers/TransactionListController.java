package com.becomejavasenior.controllers;

import com.becomejavasenior.dao.TransactionDAO;
import com.becomejavasenior.dao.impl.TransactionDAOImpl;
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
 * Created by Roman on 11.02.2016.
 */
@WebServlet("/TransactionListController")
public class TransactionListController extends HttpServlet {
    public static final String LIST_TRANSACTION = "/client/listTransaction.jsp";
    public static final String INSERT_OR_EDIT = "/paymaster/transaction.jsp";
    static final Logger logger = LogManager.getRootLogger();
    private TransactionDAO dao;

    public TransactionListController() {
        dao = new TransactionDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        logger.info("Transaction controller begin");
        if (action.equalsIgnoreCase("listTransaction")) {
            forward = LIST_TRANSACTION;
            request.setAttribute("transactions", dao.getAllTransaction());
        } else {
            forward = INSERT_OR_EDIT;

        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
        logger.info("Transaction controller end");
    }
}
