package com.geekbrains.patterns.architectpatterns.datamapper;

import java.sql.Connection;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static final Random RANDOM=new Random();
    public static final String EXIT="exit";
    public static final UserDataMapper DATA_MAPPER=new UserDataMapperImpl();

    public static void main(String[] args) {
        Connection connection=DBConnector.getConnection();
        if(connection==null){
            exit(0);
            System.out.println("Connection not found");
        }

        DBObjects.createObjects(connection);
        generateStudents(connection, 4);
        Scanner input=new Scanner(System.in);
        String console;
        while (true){
            System.out.println("Введите команду (exit-выход): ");
            console=input.nextLine();
            if(console.equals(EXIT)) break;

            String[] commands=console.split(" ");
            if(commands.length<2)continue;
            
        }
        DBObjects.dropObjects(connection);
        DBConnector.close();
    }


    public static void generateStudents(Connection connection, int num){
        System.out.println("Генерация пользователей:");
       for(int i=0; i<num; i++) {
           User user = new User(i, "Фамилия №" + i, "Имя №" + i, RANDOM.nextInt(120));
           DATA_MAPPER.insert(user);
       }
       //Список пользователей
        System.out.println(DATA_MAPPER.getUsers());

       //Удаляем пользователя
        System.out.println("Удаляем пользователя с userId=2 и выводим новый список:");
        DATA_MAPPER.deleteById(2);
        System.out.println(DATA_MAPPER.getUsers());
        }
    }


