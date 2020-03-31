package com.geekbrains.patterns.createpatterns.builder;

public class MyThirdHouseBuilder extends HouseBuilder {

    @Override
    public HouseBuilder buildFloors() {
        getHouse().setFloorsCount(12);
        return this;
    }

    @Override
    public HouseBuilder takeLocation() {
        getHouse().setDistrictLocation("Zvezdnaya");
        return this;
    }

    @Override
    public HouseBuilder chooseCompany() {
        getHouse().setCompanyDeveloper("MyThirdHouse_Development");
        return this;
    }
}