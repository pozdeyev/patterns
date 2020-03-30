package com.geekbrains.createpatterns;

public class ConcreteBuilder  extends Builder {
    public ConcreteBuilder() {
        super(HouseBuild.Steps.CREATE_BASEMENT);
    }

    @Override
    public void buildImpl() {
        System.out.println("Building basement");
    }
}
