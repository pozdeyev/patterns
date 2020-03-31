package com.geekbrains.patterns.createpatterns.builder;

public class MySecondHouseBuilder extends HouseBuilder {

    @Override
    public HouseBuilder buildFloors() {
        getHouse().setFloorsCount(24);
        return this;
    }

    @Override
    public HouseBuilder takeLocation() {
        getHouse().setDistrictLocation("Kupchino");
        return this;
    }

    @Override
    public HouseBuilder chooseCompany() {
        getHouse().setCompanyDeveloper("MySecondHouse_Development");
        return this;
    }
}