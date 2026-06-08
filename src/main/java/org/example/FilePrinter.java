package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class FilePrinter implements Printer {

    private final String fileName;

    public FilePrinter(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void print(String text) {
        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "FilePrinter{" +
                "fileName='" + fileName + '\'' +
                '}';
    }
}
