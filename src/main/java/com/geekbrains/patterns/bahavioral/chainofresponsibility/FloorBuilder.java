package com.geekbrains.patterns.bahavioral.chainofresponsibility;

public class FloorBuilder extends Builder {
    public FloorBuilder() {
        super(HouseBuild.Steps.CREATE_FLOOR);
    }

    @Override
    public void buildImpl() {
        System.out.println("Building floor");
    }
}
