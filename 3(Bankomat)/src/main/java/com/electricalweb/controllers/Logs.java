package com.electricalweb.controllers;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Logs {
    static Statement statement = null;
    public static List<String> list = null;
    public static boolean flag = false;
    Logs(){
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
    public void record(String to, String from, String sum){
        Date today = Date.valueOf(LocalDate.now());
        Time now = Time.valueOf(LocalTime.now());
        String req = "INSERT INTO history_of_transactions VALUES(" + from + "," + to + "," + sum + "," +  "current_date,current_time)";
        try {
            statement.executeUpdate(req);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<String> getLogs(String card){
        String req = "SELECT * FROM history_of_transactions where `from`=" + card;
        try {
            statement.executeQuery(req);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<String> list = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery(req);
             while(resultSet.next()){
                 String temp = "";
                 temp+=(resultSet.getString("from") + "   " + resultSet.getString("to") + "   " + resultSet.getInt("sum") + "   " + resultSet.getDate("date") + "   " + resultSet.getTime("time"));
                 list.add(temp);
             }
            for(String s : list){
                System.out.println(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        flag = true;
        this.list = list;
        return list;

    }

}
