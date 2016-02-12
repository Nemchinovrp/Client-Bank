package com.becomejavasenior.controllers;

import com.becomejavasenior.dao.TransactionDAO;
import com.becomejavasenior.dao.impl.TransactionDAOImpl;
import com.becomejavasenior.model.Transaction;
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
@WebServlet("/TransactionAddController.do")
public class TransactionAddController extends HttpServlet {
    public static final String LIST_TRANSACTION = "/listTransaction.jsp";
    static final Logger logger = LogManager.getRootLogger();
    private TransactionDAO dao;

    public TransactionAddController() {
        dao = new TransactionDAOImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("begin add object transaction");
        Transaction transaction = new Transaction();
        transaction.setId(Integer.parseInt(request.getParameter("id")));
        transaction.setIdAccount(Integer.parseInt(request.getParameter("idAccount")));
        transaction.setOperation(request.getParameter("operation"));
        transaction.setAmount(Double.parseDouble(request.getParameter("amount")));

        dao.createTransaction(transaction);
        logger.info("end add object transaction");
        RequestDispatcher view = request.getRequestDispatcher(LIST_TRANSACTION);
        request.setAttribute("transactions", dao.getAllTransaction());
        view.forward(request, response);
    }
}