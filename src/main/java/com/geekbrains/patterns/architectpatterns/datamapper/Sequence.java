package com.geekbrains.patterns.architectpatterns.datamapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sequence {
    public static final String NAME="keys";
    public static final int START=1;

    public static int nextVal (Connection connection){
        int result=0;
        Statement statement=null;
        try {
            String sql="SELECT nextVal('" +NAME+"')";
            statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            if(resultSet.next()) result=resultSet.getInt(1);
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        } return result;
    }
}
