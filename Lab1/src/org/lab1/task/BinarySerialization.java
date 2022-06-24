package org.lab1.task;

import java.io.*;
import java.util.ArrayList;

class BinarySerialization implements Serialization {
    private final String filename;

    BinarySerialization(String filename) {
        this.filename = filename;
    }

    @Override
    public void write(ArrayList<Series> series) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(filename);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(series);
        Logger.getInstance().logWrite("Массив объектов сериализован в бинарном виде");
    }

    @Override
    public ArrayList<Series> read() throws IOException, ClassNotFoundException {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(filename));
        ArrayList<Series> series = (ArrayList<Series>) is.readObject();
        Logger.getInstance().logWrite("Массив объектов десериализован из бинарного вида");
        Logger.getInstance().logWrite("Из бинарного файла удалось десериализовать объектов " + series.size());
        return series;
    }
}
