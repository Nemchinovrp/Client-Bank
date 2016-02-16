package com.becomejavasenior.controllers;

import com.becomejavasenior.dao.UserDAO;
import com.becomejavasenior.dao.impl.UserDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Роман on 07.02.2016.
 */
@WebServlet("/AdminUserDeleteController.do")
public class UserDeleteController extends HttpServlet {

    private UserDAO dao;

    public UserDeleteController() {
        dao = new UserDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {

            int id = Integer.parseInt(request.getParameter("id"));
            dao.deleteUser(id);
            response.sendRedirect("/AdminUserListController?action=listUser");

        }
    }
}
