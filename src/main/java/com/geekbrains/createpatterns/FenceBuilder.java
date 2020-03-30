package com.geekbrains.createpatterns;

public class FenceBuilder extends Builder {
    public FenceBuilder() {
        super(HouseBuild.Steps.CREATE_FENCE);
    }

    @Override
    public void buildImpl() {
        System.out.println("Building fence");
    }
}