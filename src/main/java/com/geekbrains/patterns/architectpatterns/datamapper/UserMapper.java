package com.geekbrains.patterns.architectpatterns.datamapper;

import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserMapper {

    Map<Integer, User> identityMap=new ConcurrentHashMap<>();

    private final Connection connection;
    private boolean next;

    public UserMapper(Connection connection) {
        this.connection = connection;
    }

    public void insert(Connection connection, User user) throws SQLException {

        String insertion = "INSERT into users values (?, ?, ?, ?);";
        PreparedStatement ps = connection.prepareStatement(insertion);
        try {
            user.setId(Sequence.nextVal(connection));
            ps.setInt(1, user.getId());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getFirstName());
            ps.setInt(4, user.getAge());
            ps.executeUpdate();
            identityMap.put(user.getId(), user);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                ;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(Connection connection, User user) throws SQLException {

        String insertion = "UPDATE users SET lastname=?, firstname=?, age=? WHERE id=?;";
        PreparedStatement ps = connection.prepareStatement(insertion);
        try {
            ps.setInt(1, user.getId());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getFirstName());
            ps.setInt(4, user.getAge());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                ;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public void delete(Connection connection, User user) throws SQLException {
        int result = -1;
        String insertion = "DELETE from users WHERE id=?;";
        PreparedStatement ps = connection.prepareStatement(insertion);
        try {
            ps.setInt(1, user.getId());
            int count = ps.executeUpdate();
            result = 0;
            identityMap.remove(user.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public User getById(Connection connection, Integer id) {
        User user =null;

        PreparedStatement ps = null;
        if(identityMap.containsKey(id)) return identityMap.get(id);
        try {
            String insertion = "SELECT * from users WHERE id=?;";
            ps=connection.prepareStatement(insertion);
            ps.setInt(1, id);
            ResultSet resultSet= ps.executeQuery();
            if(resultSet.next()){
                user =new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }return user;
    }

    public List<User> selectAll(Connection connection){
        Statement statement = null;
        List<User> users =null;
        try {
            String insertion = "SELECT * from users;";
            statement=connection.createStatement();
            ResultSet resultSet= statement.executeQuery(insertion);
            if(resultSet.next()){
                users.add(new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getInt(4)));
                System.out.println(resultSet.getString(2) +" "+ resultSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                ;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } return users;
    }

}


