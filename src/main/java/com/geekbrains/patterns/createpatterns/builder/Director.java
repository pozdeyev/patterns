package com.geekbrains.patterns.createpatterns.builder;

public class Director {
    private HouseBuilder houseBuilder;
    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }
    public House getHouse() {
        return houseBuilder.getHouse();
    }

    public void makeHouse() {
        houseBuilder.buildNewHouse()
                .buildFloors()
                .takeLocation()
                .chooseCompany();
    }


}
