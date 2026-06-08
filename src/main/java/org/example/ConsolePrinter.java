package org.example;

public class ConsolePrinter implements Printer {

    @Override
    public void print(String text) {
        System.out.print(text);
    }
}