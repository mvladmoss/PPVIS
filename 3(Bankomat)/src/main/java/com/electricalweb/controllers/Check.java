package com.electricalweb.controllers;


import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.Random;
import java.util.concurrent.ExecutionException;

public class Check {
    public static int last = 0;
    public static boolean flag = false;
    static Statement statement = null;
    Check(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/base?useSSL=false", "root", "6021252");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Response check(String login, String password) throws SQLException {
        int number_of_card = 0;
        int pas = 0;
        String name = "";
        String surname = "";
        int sum = 0;
        String request = "SELECT password,name,surname,sum,number_of_card FROM cards where number_of_card=" + Integer.parseInt(login);
        ResultSet r = statement.executeQuery(request);
        try{
            if (r.next()) {
                pas = r.getInt("password");
                number_of_card = r.getInt("number_of_card");
                name = r.getString("name");
                surname = r.getString("surname");
                sum = r.getInt("sum");
            }
        }finally {
            r.close();
            statement.close();
        }

        if (number_of_card == (Integer.parseInt(login)) && pas == (Integer.parseInt(password))) {
            return new Response(true, name, surname, sum, number_of_card);
        } else
            return new Response(false);

    }

    public void card_transaction(String card, String card_number, String sum,HttpServletRequest request) throws SQLException, MoneydeficiteException, WrongCardNumberException {
        String request1 = "SELECT sum FROM cards WHERE number_of_card=" + Integer.parseInt(card);
        String request2 = "SELECT sum FROM cards WHERE number_of_card=" + Integer.parseInt(card_number);
        int sum_from = 0;
        int sum_to =0;
            ResultSet second = statement.executeQuery(request2);
        if(second.next()){
            sum_to = second.getInt("sum");
            int new_sum_second = sum_to+Integer.parseInt(sum);
            String for_update_second = "UPDATE cards SET sum =" + new_sum_second + " WHERE number_of_card= " + card_number ;
            statement.executeUpdate(for_update_second);
        }
        else {
            throw new WrongCardNumberException();
        }
        ResultSet first = statement.executeQuery(request1);

        if(first.next()) {
            sum_from = first.getInt("sum");
            if (sum_from < Integer.parseInt(sum))
                throw new MoneydeficiteException();
            int new_sum_first = sum_from - Integer.parseInt(sum);
            String for_update_first = "UPDATE cards SET sum =" + new_sum_first + " WHERE number_of_card= " + card;
            statement.executeUpdate(for_update_first);
            request.setAttribute("sum", new_sum_first);
            last = new_sum_first;
            flag = true;

        }

    }
    public void random_paymaent(String card,String pay_check, String sum,HttpServletRequest request) throws SQLException, MoneydeficiteException {
        String request1 = "SELECT sum FROM cards WHERE number_of_card=" + Integer.parseInt(card);
        int old_sum = 0;
        ResultSet first = statement.executeQuery(request1);
        if(first.next()) {
            old_sum = first.getInt("sum");
            if (old_sum < Integer.parseInt(sum))
                throw new MoneydeficiteException();
            int new_sum_first = old_sum - Integer.parseInt(sum);
            String for_update_first = "UPDATE cards SET sum =" + new_sum_first + " WHERE number_of_card= " + card;
            statement.executeUpdate(for_update_first);
            last = new_sum_first;
            flag=true;
            request.setAttribute("sum", new_sum_first);
        }
    }


    public void record_new_user(String password, String names, String surnames, String number_of_card) throws SQLException {
        Random random = new Random(2000);
        int sum = random.nextInt(2000);
        String suma = Integer.toString(sum);
        String request = "INSERT INTO cards(password, sum, name, surname, number_of_card) VALUES" + "(" + password + "," + suma + "," + "'" + names + "'" + "," + "'" + surnames + "'" +  "," + number_of_card + ");";
        System.out.println(request);
        statement.executeUpdate(request);
    }

}
class Response{
    int card = 0;
    boolean flag = false;
    String name="";
    String surname="";
    int sum = 0;

    Response(boolean flag){
        this.flag=flag;
    }
    Response(boolean flag, String name,String surname,int sum, int card) {
        this.flag = flag;
        this.name = name;
        this.surname=surname;
        this.sum=sum;
        this.card = card;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}

class MoneydeficiteException extends Exception{

}

class WrongCardNumberException extends  Exception{

}