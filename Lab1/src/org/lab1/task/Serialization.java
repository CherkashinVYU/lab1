package org.lab1.task;

import java.io.IOException;
import java.util.ArrayList;

interface Serialization {
    void write(ArrayList<Series> series) throws IOException;

    ArrayList<Series> read() throws IOException, NumberFormatException, ClassNotFoundException;
}
