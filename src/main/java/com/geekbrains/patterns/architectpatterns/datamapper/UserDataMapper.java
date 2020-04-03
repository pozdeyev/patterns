package com.geekbrains.patterns.architectpatterns.datamapper;

import java.util.List;
import java.util.Optional;

public interface UserDataMapper {

    Optional<User> find(int id);
    void insert(User user) throws MapperException;
    void update(User user) throws MapperException;
    void delete(User user) throws MapperException;
    void deleteById(int id) throws MapperException;
    List<User> getUsers();

}
