package com.uj.study.countcharinstring;

public class LinePrinterStub implements LinePrinter {
    String content;
    @Override
    public void printLine(String content) {
        this.content = content;
    }
}
