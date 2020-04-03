package com.geekbrains.patterns.createpatterns.builder;

public class Main {

    public static void main(String[] args) {
        Director director = new Director();

        //строим дом 1
        HouseBuilder myFirstHouseBuilder = new MyFirstHouseBuilder();
        director.setHouseBuilder(myFirstHouseBuilder);
        director.makeHouse();
        House house1 = director.getHouse();
        System.out.println(house1.toString());

        //строим дом 2
        HouseBuilder mySecondHouseBuilder = new MySecondHouseBuilder();
        director.setHouseBuilder(mySecondHouseBuilder);
        director.makeHouse();
        House house2 = director.getHouse();
        System.out.println(house2.toString());


        //строим дом 3
        HouseBuilder myThirdHouseBuilder = new MyThirdHouseBuilder();
        director.setHouseBuilder(myThirdHouseBuilder);
        director.makeHouse();
        House house3 = director.getHouse();
        System.out.println(house3.toString());


    }
}