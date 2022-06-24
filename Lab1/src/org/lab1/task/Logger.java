package org.lab1.task;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private static Logger logger = null;

    public static synchronized Logger getInstance(){
        if(logger == null)
            logger = new Logger();
        return logger;
    }

    private PrintWriter writer;
    private Logger() {
        try {
            String logFile = "log.txt";
            FileWriter fw = new FileWriter(logFile);
            writer = new PrintWriter(fw, true);
        } catch (IOException e) {}
    }
    public void logWrite (String string) {
        writer.println(string);
    }
}
