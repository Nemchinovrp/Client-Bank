package com.becomejavasenior.controllers;

import com.becomejavasenior.dao.UserDAO;
import com.becomejavasenior.dao.impl.UserDAOImpl;
import com.becomejavasenior.model.Gender;
import com.becomejavasenior.model.Role;
import com.becomejavasenior.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Роман on 07.02.2016.
 */
@WebServlet("/UserAddController.do")
public class UserAddController extends HttpServlet {
    public static final String LIST_USER = "/admin/listUser.jsp";

    private UserDAO dao;

    public UserAddController() {
        dao = new UserDAOImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setId(Integer.parseInt(request.getParameter("id")));
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
        Date dob = null;
        try {
            dob = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateOfBirth"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setDateOfBirth(dob);
        Date rd = null;
        try {
            rd = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("registrationDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setRegistrationDate(rd);
        user.setGender(Gender.fromString(request.getParameter("gender")));
        user.setRole(Role.fromString(request.getParameter("role")));
        dao.createUser(user);
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("users", dao.getAllUser());
        view.forward(request, response);
    }
}
