package com.codurance.srp;

public class Printer {
    private final Console console;

    public Printer(Console console) {
        this.console = console;
    }

    public void printLine(String line) {
        this.console.printLine(line);
    }
}
