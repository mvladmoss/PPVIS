package com.electricalweb.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Registration", urlPatterns = "/Registration")
public class Registration extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Check check = new Check();
        try {
            System.out.println(String.valueOf(req.getParameter("password")));
            check.record_new_user(String.valueOf(req.getParameter("password")),req.getParameter("name"),req.getParameter("surname"), req.getParameter("login"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
