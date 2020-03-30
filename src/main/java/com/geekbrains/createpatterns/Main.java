package com.geekbrains.createpatterns;

public class Main {

    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        builder.setNext(new FloorBuilder())
                .setNext(new RoofBuilder())
                .setNext(new FenceBuilder());

        HouseBuild realbuild = new HouseBuild(
                HouseBuild.Steps.CREATE_BASEMENT,
                HouseBuild.Steps.CREATE_FLOOR,
                HouseBuild.Steps.CREATE_ROOF,
                HouseBuild.Steps.CREATE_FENCE
        );

        builder.build(realbuild);
    }


}
