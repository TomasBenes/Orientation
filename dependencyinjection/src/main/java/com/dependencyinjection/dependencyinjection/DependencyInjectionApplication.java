package com.dependencyinjection.dependencyinjection;

import com.dependencyinjection.dependencyinjection.helloDiProject.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DependencyInjectionApplication implements CommandLineRunner {

    private Printer printer;

    @Autowired
    DependencyInjectionApplication (Printer printer) {
        this.printer = printer;
    }


    public static void main(String[] args) {
        SpringApplication.run(DependencyInjectionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        printer.log("Hello");
    }
}
