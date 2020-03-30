package com.geekbrains.createpatterns;

public abstract class Builder {
    protected Builder nextBuilder;
    private final HouseBuild.Steps step;
    public abstract void buildImpl();

    public Builder(HouseBuild.Steps step) {
        this.step = step;
    }


    public void build(HouseBuild houseBuild) {
        if (houseBuild.getSteps().contains(step)) {
            buildImpl();
        }
        if (nextBuilder != null) {
            nextBuilder.build(houseBuild);
        }
    }

    public Builder setNext(Builder builder) {
        nextBuilder = builder;
        return builder;
    }
}