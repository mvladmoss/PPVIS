package com.electricalweb.controllers;

import com.electricalweb.validators.StringValidator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "CustomerController", urlPatterns = "/processcustomer")
public class CustomerController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestCustomer customer = RequestCustomer.fromRequestParameters(request);
        customer.setAsRequestAttributes(request);
        List<String> violations =  new ArrayList<String>();
        Response resp = new Response(false);
        Check.flag=false;
        Logs logs = new Logs();
        try {
            Check check1 = new Check();
            resp = check1.check(customer.getLogin(), customer.getPassword());
        } catch (SQLException e) {
            System.out.println("Error");
        }
        if(resp.flag) {
            request.setAttribute("name", resp.name);
            request.setAttribute("surname",resp.surname);
            request.getSession().setAttribute("number_card", resp.card);
            request.getSession().setAttribute("name", resp.name);
            request.getSession().setAttribute("surname", resp.surname);
            List<String> list = logs.getLogs(String.valueOf(resp.card));
            request.setAttribute("list",list);
            request.setAttribute("sum",resp.sum);
            request.setAttribute("number_card",resp.card);
            forwardResponse("index3.jsp", request, response);
        }
        else{
            forwardResponse("index6.jsp",request,response);
        }
    }

    private String determineUrl(List<String> violations) {
        if (!violations.isEmpty()) {
            return "/";
        } else {
            return "/WEB-INF/views/index2.jsp";
        }
    }

    private void forwardResponse(String url, HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> check(String Login, String Password) {
        String check_login = "";
        String check_password = " ";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/base?useLegacyDatetimeCode=false&amp;serverTimezone=UTC", "root", "6021252");
            Statement statement = con.createStatement();
            ResultSet r = statement.executeQuery("SELECT *  FROM cards where password=1111");
            while (r.next()) {

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(check_login.equals(Login) && check_password.equals(Password)){
            System.out.println("good");
            return new ArrayList<String>();
        }
        else{
            List<String> list = new ArrayList<String>();
            for(String srt : "check your email or password".split(" "))
                list.add(srt);
            return list;
        }
    }


    private static class RequestCustomer {

        private final String Login;

        public String getLogin() {
            return Login;
        }

        public String getPassword() {
            return Password;
        }



        private final String Password;


        private RequestCustomer(String firstName, String lastName) {
            this.Login = firstName;
            this.Password = lastName;

        }

        public static RequestCustomer fromRequestParameters(HttpServletRequest request) {
            return new RequestCustomer(
                    request.getParameter("login"),
                    request.getParameter("password"));

        }

        public void setAsRequestAttributes(HttpServletRequest request) {
            request.setAttribute("login", Login);
            request.setAttribute("password", Password);

        }

        public List<String> validate() {
            List<String> violations = new ArrayList<String>();
            if (!StringValidator.validate(Login)) {
                violations.add("First Name is mandatory");
            }
            if (!StringValidator.validate(Password)) {
                violations.add("Last Name is mandatory");
            }

            return violations;
        }
    }
}
