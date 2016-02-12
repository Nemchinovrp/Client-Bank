package com.becomejavasenior.controllers;

import com.becomejavasenior.dao.TransactionDAO;
import com.becomejavasenior.dao.impl.TransactionDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Roman on 12.02.2016.
 */
@WebServlet("/TransactionDeleteController.do")
public class TransactionDeleteController extends HttpServlet {
    TransactionDAO dao;

    TransactionDeleteController() {
        dao = new TransactionDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {

            int id = Integer.parseInt(request.getParameter("id"));
            dao.deleteTransaction(id);
            response.sendRedirect("/TransactionListController?action=listTransaction");
        }
    }
}
