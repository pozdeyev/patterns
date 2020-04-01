package com.geekbrains.patterns.createpatterns.builder;

public  abstract class HouseBuilder {

    private static volatile House instance;


    public HouseBuilder buildNewHouse() {
        getHouse();
        return this;
    }

    public abstract HouseBuilder buildFloors();
    public abstract HouseBuilder takeLocation();
    public abstract HouseBuilder chooseCompany();

    //возвращаем instance
    public static House getHouse() {
        House localInstance = instance;
        if (localInstance == null) {
            synchronized (House.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new House();
                }
            }
        }
        return localInstance;
    }

}
