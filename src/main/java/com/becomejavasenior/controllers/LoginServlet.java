package com.becomejavasenior.controllers;

import com.becomejavasenior.dao.AccountDAO;
import com.becomejavasenior.dao.TransactionDAO;
import com.becomejavasenior.dao.UserDAO;
import com.becomejavasenior.dao.impl.AccountDAOImpl;
import com.becomejavasenior.dao.impl.TransactionDAOImpl;
import com.becomejavasenior.dao.impl.UserDAOImpl;
import com.becomejavasenior.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

/**
 * Created by Roman on 18.02.2016.
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    public static final String LIST_USER = "/admin/listUser.jsp";
    public static final String LIST_TRANSACTION = "/client/listTransaction.jsp";
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
            if (u.getEmail().equals(emailR) && u.getPassword().equals(passwordR) && u.getRole().toString().equals("CLIENT")) {
                HttpSession session = request.getSession();
                session.setAttribute("user", u.getFirstName());
                session.setMaxInactiveInterval(30 * 60);
                Cookie userName = new Cookie("user", u.getFirstName());
                userName.setMaxAge(30 * 60);
                response.addCookie(userName);
                RequestDispatcher view = request.getRequestDispatcher(LIST_TRANSACTION);
                request.setAttribute("transactions", daoTransaction.getAllTransaction());
                view.forward(request, response);
            } else if (u.getEmail().equals(emailR) && u.getPassword().equals(passwordR) && u.getRole().toString().equals("ADMIN")) {
                HttpSession session = request.getSession();
                session.setAttribute("user", u.getFirstName());
                session.setMaxInactiveInterval(30 * 60);
                Cookie userName = new Cookie("user", u.getFirstName());
                userName.setMaxAge(30 * 60);
                response.addCookie(userName);
                RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
                request.setAttribute("users", daoUser.getAllUser());
                view.forward(request, response);
            } else if (u.getEmail().equals(emailR) && u.getPassword().equals(passwordR) && u.getRole().toString().equals("PAYMASTER")) {
                HttpSession session = request.getSession();
                session.setAttribute("user", u.getFirstName());
                session.setMaxInactiveInterval(30 * 60);
                Cookie userName = new Cookie("user", u.getFirstName());
                userName.setMaxAge(30 * 60);
                response.addCookie(userName);
                RequestDispatcher view = request.getRequestDispatcher(LIST_TRANSACTION);
                request.setAttribute("transactions", daoTransaction.getAllTransaction());
                view.forward(request, response);
            }
        }
    }
}
