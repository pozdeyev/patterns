package com.geekbrains.patterns.architectpatterns.datamapper;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBObjects {
    public static void createObjects(Connection connection) {
        dropSequence(connection);
        createSequence(connection);
       createTable(connection);
    }
        public static void dropObjects(Connection connection){
        dropTable(connection);
        dropSequence(connection);
    }

    public static void createTable(Connection  connection){
        Statement statement=null;
        try {
            statement=connection.createStatement();
            String sql="CREATE TABLE IF NOT EXISTS students(id int PRIMARY KEY, lastname varchar(32), firstname varchar(32), age int);";
            statement.execute(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void dropTable(Connection  connection){
        Statement statement=null;
        try {
            statement=connection.createStatement();
            String sql="DROP TABLE IF EXISTS students;";
            statement.execute(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void createSequence(Connection  connection){
        Statement statement=null;
        try {
            statement=connection.createStatement();
            String sqlStr=String.format("CREATE SEQUENCE %s START %d;", Sequence.NAME, Sequence.START);
            statement.execute(sqlStr);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void dropSequence(Connection  connection){
        Statement statement=null;
        try {
            statement=connection.createStatement();
            String sqlStr=String.format("DROP SEQUENCE IF EXISTS %s;", Sequence.NAME);
            statement.execute(sqlStr);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
