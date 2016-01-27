package com.becomejavasenior.controllers;

import com.becomejavasenior.dao.CurrencyDAO;
import com.becomejavasenior.dao.impl.CurrencyDAOImpl;
import com.becomejavasenior.model.Currency;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by Роман on 24.01.2016.
 */
@WebServlet("/CurrencyController")
public class CurrencyController extends HttpServlet {
    private CurrencyDAO dao;
    public static final String LIST_CURRENCY = "/listCurrency.jsp";
    public static final String INSERT_OR_EDIT = "/currency.jsp";

    public CurrencyController() {
        dao = new CurrencyDAOImpl();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            forward = LIST_CURRENCY;
            int id = Integer.parseInt(request.getParameter("id"));
            try {
                dao.deleteCurrency(id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                request.setAttribute("currencies", dao.getAllCurrency());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("id"));
            Currency currency = null;
            try {
                currency = dao.getCurrencyById(id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.setAttribute("currency", currency);
        } else if (action.equalsIgnoreCase("insert")) {
            forward = INSERT_OR_EDIT;
        } else {
            forward = LIST_CURRENCY;
            try {
                request.setAttribute("currencies", dao.getAllCurrency());
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
        Currency currency = new Currency();
        currency.setId(Integer.parseInt(request.getParameter("id")));
        currency.setName(request.getParameter("name"));
        currency.setRate(Double.parseDouble(request.getParameter("rate")));
        try {
            dao.createCurrency(currency);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_CURRENCY);
        try {
            request.setAttribute("currencies", dao.getAllCurrency());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        view.forward(request, response);
    }
}
