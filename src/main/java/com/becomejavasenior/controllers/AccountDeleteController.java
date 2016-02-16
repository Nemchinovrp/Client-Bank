package com.becomejavasenior.controllers;

import com.becomejavasenior.dao.AccountDAO;
import com.becomejavasenior.dao.impl.AccountDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Roman on 10.02.2016.
 */
@WebServlet("/AdminAccountDeleteController.do")
public class AccountDeleteController extends HttpServlet {
    AccountDAO dao;
   public AccountDeleteController(){
        dao = new AccountDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {

            int id = Integer.parseInt(request.getParameter("id"));
            dao.deleteAccount(id);
            response.sendRedirect("/AdminAccountListController?action=listAccount");
        }
    }
}
