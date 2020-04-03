package com.geekbrains.patterns.architectpatterns.datamapper;

import java.io.Serializable;


public final class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String lastName;
    private String firstName;
    private int age;

    public User() {
    }

    public User(final int id, final String lastName, final String firstName, final int age) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    @Override
    public boolean equals(final Object inputObject) {
        boolean isEqual = false;

        if (this == inputObject) {
            isEqual = true;
        } else if (inputObject != null && getClass() == inputObject.getClass()) {
            final User inputUser = (User) inputObject;

            if (this.getId() == inputUser.getId()) {
                isEqual = true;
            }
        }
        return isEqual;
    }

    @Override
    public int hashCode() {
        return this.getId();
    }

    @Override
    public String toString() {
        return " [userId=" + id + ", lastname=" + lastName + ", firstname=" + firstName + ", age=" + age + "]";
    }
}
