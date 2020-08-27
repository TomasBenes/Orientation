package com.dependencyinjection.dependencyinjection.coloringAround;

import com.dependencyinjection.dependencyinjection.helloDiProject.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlueColor implements  MyColor {

    /*private final MyColor myColor;

    @Autowired
    public BlueColor(MyColor myColor) {
        this.myColor = myColor;
    }

    @Override
    public void printColor() {
        System.out.println("It is blue in color...");
    }*/

    private final Printer printer;

    @Autowired
    public BlueColor(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void printColor() {
        printer.log("It is blue in color...");
    }
}
