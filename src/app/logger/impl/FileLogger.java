package app.logger.impl;

import app.logger.Loggable;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements Loggable {
    @Override
    public void log(String msg) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true));
        writer.append(msg);
        writer.close();
    }
}
