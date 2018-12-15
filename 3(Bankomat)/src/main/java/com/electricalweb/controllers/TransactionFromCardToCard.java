package com.electricalweb.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "TransactionFromCardToCard", urlPatterns = "/cardTransaction")
public class TransactionFromCardToCard extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str = "number_of_card_for_transaction";
        Integer  number_card = (Integer) req.getSession().getAttribute("number_card");
        req.setAttribute("number_card",number_card);
        req.setAttribute("name", req.getParameter("name"));
        req.setAttribute("surname", req.getParameter("surname"));
        req.setAttribute("sum", req.getParameter("sum"));
        req.setAttribute("list",req.getParameter("list"));
        String str1 = "sum_of_transaction";
        String sum = req.getParameter(str1);
        String card_number = req.getParameter(str);
        Check check = new Check();
        boolean error = false;
        try {
            check.card_transaction(Integer.toString(number_card),card_number,sum,req);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (MoneydeficiteException e) {
            req.getRequestDispatcher("index4.jsp").forward(req, resp);
            error=true;
        } catch (WrongCardNumberException e){
            req.getRequestDispatcher("index5.jsp").forward(req, resp);
            error=true;
        }
        if(!error) {
            Logs logs = new Logs();
            logs.record(card_number, Integer.toString(number_card), sum);
            logs.getLogs(String.valueOf(number_card));
        }
        req.getRequestDispatcher("index2.jsp").forward(req, resp);
    }
}

