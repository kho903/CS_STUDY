package com.company.functional.C02FunctionalInterface;

import java.util.function.Supplier;

public class C01Supplier {

    public static void main(String[] args) {
        Supplier<String> myStringSupplier = () -> {
            return "hello world!";
        };
        System.out.println(myStringSupplier.get());
        Supplier<Double> myRandomDoubleSupplier = () -> Math.random();
        System.out.println(myRandomDoubleSupplier.get());

        printRandomDoubles(myRandomDoubleSupplier, 5);
    }

    public static void printRandomDoubles(Supplier<Double> randomSupplier, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(randomSupplier.get());
        }
    }
}
