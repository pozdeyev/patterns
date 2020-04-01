package com.geekbrains.patterns.structuralpatterns.proxy;

public class ShowHouses {
    private HouseList houseList = new MyFirstDevHouseListProxy();

    public void printHouseTable() {
        String[] houseTable = houseList.getHouseTable();
        String[] temp;
        System.out.println("House ID\tAddress");
        for(int i = 0; i < houseTable.length; i++) {
            temp = houseTable[i].split(";");
            System.out.printf("%s\t\t\t%s\t\t\t\n", temp[0], temp[1]);
        }
        System.out.println("Get address by id:  " + houseList.getHouseAddress("3"));
    }
}
