package com.becomejavasenior.controllers;

import com.becomejavasenior.dao.UserDAO;
import com.becomejavasenior.dao.impl.UserDAOImpl;
import com.becomejavasenior.model.Gender;
import com.becomejavasenior.model.Role;
import com.becomejavasenior.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
 * Created by Roman on 28.01.2016.
 */
@WebServlet("/UserListController")
public class UserListController extends HttpServlet {
    public static final String LIST_USER = "/listUser.jsp";
    public static final String INSERT_OR_EDIT = "/user.jsp";
    static final Logger logger = LogManager.getRootLogger();
    private UserDAO dao;

    public UserListController() {
        dao = new UserDAOImpl();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String forward = "";
        String action = request.getParameter("action");
        logger.info("Action controller begin");
        if (action.equalsIgnoreCase("listUser")) {
            forward = LIST_USER;
            //response.sendRedirect(forward);
            request.setAttribute("users", dao.getAllUser());
        } else {
            forward = INSERT_OR_EDIT;

        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
        logger.info("Action controller end");

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        user.setGender(Gender.fromString(request.getParameter("idGender")));
        user.setRole(Role.fromString(request.getParameter("idRole")));
        dao.createUser(user);
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("users", dao.getAllUser());
        view.forward(request, response);
    }
}
