package org.lab1.task;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        if(args.length < 1){
            System.out.println("Нужно задать имя файла csv при запуске программы");
            return;
        }

        String file = args[0];

        // для создания файла с тестовыми данными
//        Series s = new Linear(1, 5, "First");
//        Series s1 = new Linear(3, 7, "Second");
//        Series s2 = new Exponential(5, 2, "Third");
//        Series s3 = new Exponential(3, 7, "Forth");
//
//        ArrayList<Series> series = new ArrayList<>();
//        series.add(s);
//        series.add(s1);
//        series.add(s2);
//        series.add(s3);
//
//        org.lab1.task.CSVSerialization csv = new CSVSerialization("data.csv");
//        try {
//            csv.write(series);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        // создаем объект класса CSVSerialization, для десериализации входного файла
        CSVSerialization csv = new CSVSerialization(file);

        ArrayList<Series> series = null;
        try {
            series = csv.read();
        } catch (IOException e) {
            Logger.getInstance().logWrite("Не удалось прочитать входной файл");
        }

        // создаем объект класса BinarySerialization, для сериализации и десериализации массива данных
        BinarySerialization bin = new BinarySerialization("data.bin");

        try {
            bin.write(series);
        } catch (IOException e) {
            Logger.getInstance().logWrite("Не удалось сериализовать массив в бинарный файл");
        }

        try {
            ArrayList<Series> s = bin.read();
        } catch (IOException | ClassNotFoundException e) {
            Logger.getInstance().logWrite("Не удалось десериализовать массив из бинарного файла");
        }
    }
}