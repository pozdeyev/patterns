package com.geekbrains.patterns.architectpatterns.datamapper;

import java.util.*;

public final class UserDataMapperImpl implements UserDataMapper {

    private List<User> users = new ArrayList<>();

    @Override
    public Optional<User> find(int id) {
        return this.getUsers().stream().filter(x -> x.getId() == id).findFirst();
    }



    @Override
    public void update(User userToBeUpdated) throws MapperException {
        String lastName = userToBeUpdated.getLastName();
        String firstName = userToBeUpdated.getFirstName();
        Integer index = Optional.of(userToBeUpdated)
                .map(User::getId)
                .flatMap(this::find)
                .map(users::indexOf)
                .orElseThrow(() -> new MapperException("User [" + lastName +  firstName + "] is not found"));

        users.set(index, userToBeUpdated);
    }

    @Override
    public void insert(User userToBeInserted) throws MapperException {
        Optional<User> user = find(userToBeInserted.getId());
        if (user.isPresent()) {
            String lastName = userToBeInserted.getLastName();
            String firstName = userToBeInserted.getFirstName();
            throw new MapperException("User already [" + lastName + firstName + "] exists");
        }

        users.add(userToBeInserted);
    }

    @Override
    public void delete(User userToBeDeleted) throws MapperException {
        if (!users.remove(userToBeDeleted)) {
            String lastName = userToBeDeleted.getLastName();
            String firstName = userToBeDeleted.getFirstName();
            throw new MapperException("User already [" + lastName + firstName + "] is not found");
        }
    }

    public void deleteById(int id) throws MapperException {
        users.remove(id);
    }




    public List<User> getUsers() {
        return this.users;
    }
}