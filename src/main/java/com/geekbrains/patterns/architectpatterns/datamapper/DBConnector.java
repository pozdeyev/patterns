package com.geekbrains.patterns.architectpatterns.datamapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private static final String URL="jdbc:h2:~/test";
    private static Connection connection;

    public static Connection getConnection(){
        if(connection==null){
            registerDriver();
            try {
                connection=DriverManager.getConnection(URL, "sa", "");

            }catch (SQLException e){
                e.printStackTrace();
            }
        }return connection;
    }

    private static void registerDriver(){
        try {
            DriverManager.registerDriver(new org.h2.Driver());
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void close(){
        try {
            if(connection!=null)connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
