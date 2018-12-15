package com.electricalweb.controllers;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PhoneNumber", urlPatterns = "/phoneNumber")
public class PhoneNumber extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phoneNumber =  req.getParameter("phone_number");
        String sum  = req.getParameter("sum_of_transaction");
        Integer number_card = (Integer) req.getSession().getAttribute("number_card");
        req.setAttribute("number_card",number_card);
        req.setAttribute("name", req.getParameter("name"));
        req.setAttribute("surname", req.getParameter("surname"));
        req.setAttribute("list",req.getParameter("list"));
        req.setAttribute("sum", req.getParameter("sum"));
        boolean error= false;
        if(!checkWithRegExp(phoneNumber)){
            req.getRequestDispatcher("incorrectPhoneNumber.jsp").forward(req,resp);
        }else {
            Check check = new Check();
            try {
                check.random_paymaent(Integer.toString(number_card), phoneNumber, sum, req);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (MoneydeficiteException e) {
                req.getRequestDispatcher("index4.jsp").forward(req, resp);
                error = true;
            }
            if (!error) {
                Logs logs = new Logs();
                logs.record(phoneNumber, Integer.toString(number_card), sum);
                logs.getLogs(String.valueOf(number_card));
            }
            req.getRequestDispatcher("index2.jsp").forward(req, resp);
        }
    }
    public boolean checkWithRegExp(String userNameString){
        Pattern p = Pattern.compile("^(\\+375|80)(29|25|44|33)(\\d{3})(\\d{2})(\\d{2})$");
        Matcher m = p.matcher(userNameString);
        return m.matches();
    }
}
