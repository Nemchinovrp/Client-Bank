package com.becomejavasenior.controllers;

import com.becomejavasenior.dao.UserDAO;
import com.becomejavasenior.dao.impl.UserDAOImpl;
import com.becomejavasenior.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Roman on 28.01.2016.
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
    private UserDAO dao;
    public static final String LIST_USER = "/listUser.jsp";
    public static final String INSERT_OR_EDIT = "/user.jsp";

    public UserController() {
        dao = new UserDAOImpl();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            forward = LIST_USER;
            int id = Integer.parseInt(request.getParameter("id"));
            try {
                dao.deleteUser(id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                request.setAttribute("users", dao.getAllUser());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("id"));
            User user = null;
            try {
                user = dao.getUserById(id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.setAttribute("users", user);
        } else if (action.equalsIgnoreCase("insert")) {
            forward = INSERT_OR_EDIT;
        }
        else {
            forward = LIST_USER;
            try {
                request.setAttribute("users", dao.getAllUser());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = new User();
        user.setId(Integer.parseInt(request.getParameter("id")));
        user.setFirstName(request.getParameter("firstname"));
        user.setLastName(request.getParameter("lastname"));
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
        Date dob = null;
        try {
             dob = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("dateOfBirth"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setDateOfBirth(dob);
        Date rd = null;
        try {
            rd = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("registrationDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setRegistrationDate(rd);
        user.setGender(request.getParameter("gender"));
        user.setRole(request.getParameter("role"));

        try {
            dao.createUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        try {
            request.setAttribute("users", dao.getAllUser());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        view.forward(request, response);
    }
}
