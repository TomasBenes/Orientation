package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Customer john = new Customer("John P.", 15);
        Customer sarah = new Customer("Sarah M.", 200);
        Customer charles = new Customer("Charles B.", 150);
        Customer mary = new Customer("Mary T.", 1);

        List<Customer> customers = Arrays.asList(john, sarah, charles, mary);


        /*customers.stream()
                .filter(customer -> customer.getPoints() > 100)
                .forEach(customer -> System.out.println(customer.getName()));*/

        /*customers.stream()
                .filter(Customer::hasOverHundredPoints)
                .forEach(customer -> System.out.println(customer.getName()));*/

        /*customers.stream()
                .filter(c -> c.getPoints() > 100 && c.getName().startsWith("Charles"))
                .forEach(customer -> System.out.println(customer.getName()));*/

        /*Stream<Customer> customersNames = customers.stream()
                .filter(customer -> customer.getName().length() > 7);
        customersNames.forEach(customer -> System.out.println(customer.getName()));*/

        customers.stream()
                .filter(customer -> customer.getName().length() > 7)
                .forEach(customer -> System.out.println(customer.getName()));

        customers.stream()
                .filter(customer -> customer.getPoints() % 2 == 0)
                .forEach(customer -> System.out.println(customer.getName() + " has even amount of points: " + customer.getPoints()));

        customers.stream()
                .filter(customer -> customer.getName().contains("r"))
                .forEach(customer -> System.out.println(customer.getName()));

        customers.stream()
                .filter(customer -> customer.getName().toLowerCase().contains("m")) //toLowerCase()., case sensitive
                .forEach(customer -> System.out.println(customer.getName()));

        customers.stream()
                .filter(customer -> customer.getName().startsWith("s")) //toLowerCase()., case sensitive
                .forEach(customer -> System.out.println(customer.getName()));

    }
}
