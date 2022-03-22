package com.example.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HolidaysDao implements Dao{

    String url = "jdbc:sqlite:C:\\Users\\shook\\Desktop\\Calendar.db";
    List<Holidays> HolidaysList = new ArrayList<>();
    SqlLiteConnection sqliteConnection = new SqlLiteConnection();
    Connection connection = sqliteConnection.getConnection(url);
    Statement stm = sqliteConnection.getStatement();
    @Override
    public <T> List<T> getAll() {
        try {
            ResultSet result = stm.executeQuery
                    ("SELECT * FROM Holidays");
            while (result.next()) {
                HolidaysList.add(new Holidays
                        (result.getInt("id"),
                                result.getString("name")
                                , result.getInt("day")
                                , result.getInt("month")
                                , result.getInt("length")
                                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (List<T>) HolidaysList;
    }

    @Override
    public <T> T getById(int id) {
        Holidays holidays=null;
        try {
            var result = stm.executeQuery
                    ("SELECT * FROM Holidays WHERE id=" + id);
            result.next();
            holidays=new Holidays(result.getInt("id")
                    ,result.getString("name")
                    ,result.getInt("day")
                    ,result.getInt("month")
                    ,result.getInt("length")
                    );


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (T) holidays;
    }

    @Override
    public <T> boolean Add(T t) {
        Holidays holiday=new Holidays();
        holiday=(Holidays) t;
            int result=0;
            try {
                result=stm.executeUpdate("INSERT INTO \"Holidays\" (id,name,day,month,length) "+
                        "VALUES " +
                        "("+holiday.id+","+"\""+holiday.name+"\","+holiday.day+","+holiday.month+","+holiday.length+")");
            } catch (SQLException e) {
                System.out.println("please be more aware !!!!!!!!");
            }
            return  result==0?false:true;

    }

    @Override
    public <T> boolean Update(T t, int id) {
        Holidays holiday=new Holidays();
        holiday=(Holidays) t;
        int x= 0;
        try {
            x=stm.executeUpdate("UPDATE Movies SET name= \""+holiday.name+"\", day="+ holiday.day+"" +
                    ",month="+holiday.month+", length ="+holiday.length+"where id="+id+"");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return x!=0;
    }

    @Override
    public boolean Delete(int id) {
        int res=0;
        try {
            res=stm.executeUpdate("DELETE from Movies WHERE id = "+id);
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return (res ==0?false:true) ;
    }
}
