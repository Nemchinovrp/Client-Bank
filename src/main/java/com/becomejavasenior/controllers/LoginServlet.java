package com.becomejavasenior.controllers;

import com.becomejavasenior.dao.AccountDAO;
import com.becomejavasenior.dao.TransactionDAO;
import com.becomejavasenior.dao.UserDAO;
import com.becomejavasenior.dao.impl.AccountDAOImpl;
import com.becomejavasenior.dao.impl.TransactionDAOImpl;
import com.becomejavasenior.dao.impl.UserDAOImpl;
import com.becomejavasenior.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Roman on 18.02.2016.
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    UserDAO daoUser = null;
    TransactionDAO daoTransaction = null;
    AccountDAO daoAccount = null;

    public LoginServlet() {
        daoUser = new UserDAOImpl();
        daoTransaction = new TransactionDAOImpl();
        daoAccount = new AccountDAOImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> list = daoUser.getAllUser();
        String emailR = request.getParameter("email");
        String passwordR = request.getParameter("password");
        for (User u : list) {
            if (u.getEmail().equals(emailR) && u.getPassword().equals(passwordR)) {
                HttpSession session = request.getSession();
                session.setAttribute("email", u.getEmail());
                session.setAttribute("password", u.getPassword());
                session.setAttribute("role", u.getRole().toString());
                session.setMaxInactiveInterval(30 * 60);
                if (u.getRole().toString().equals("ADMIN")) {
                    response.sendRedirect("/AdminUserListController.do?action=listUser");
                } else if (u.getRole().toString().equals("CLIENT")) {
                    response.sendRedirect("/ClientTransactionListController?action=listTransaction");
                } else if (u.getRole().toString().equals("PAYMASTER")) {
                    response.sendRedirect("/PaymasterAccountListController?action=listAccount");
                }

            }
        }

    }
}
