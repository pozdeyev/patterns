package com.geekbrains.patterns.architectpatterns.datamapper;


public class MapperException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public MapperException(final String message) {
        super(message);
    }
}
