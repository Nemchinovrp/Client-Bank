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
@WebServlet("/AdminUserListController.do")
public class UserListController extends HttpServlet {
    public static final String LIST_USER = "/admin/listUser.jsp";
    public static final String INSERT_OR_EDIT = "/client/user.jsp";
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

}
