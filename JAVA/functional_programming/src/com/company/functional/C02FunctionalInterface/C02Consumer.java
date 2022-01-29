package com.company.functional.C02FunctionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class C02Consumer {

    public static void main(String[] args) {
        Consumer<String> myStringConsumer = str -> {
            System.out.println(str);
        };

        myStringConsumer.accept("hello");
        myStringConsumer.accept("world");

        List<Integer> integerInputs = Arrays.asList(4, 2, 3); // 변경 불가능한 List
        Consumer<Integer> myIntegerProcessor = (Integer x) -> {
            System.out.println("Processing integer " + x);
        };
        process(integerInputs, myIntegerProcessor);

        Consumer<Integer> myDifferentProcessor = x -> {
            System.out.println("Processing integer in different way " + x);
        };
        process(integerInputs, myDifferentProcessor);

        Consumer<Double> myDoubleProcessor = x -> {
            System.out.println("Processing double " + x);
        };
        List<Double> doubleInputs = Arrays.asList(1.1, 2.2, 3.3);
        process(doubleInputs, myDoubleProcessor);
    }

    public static <T> void process(List<T> inputs, Consumer<T> processor) {
        for (T input : inputs) {
            processor.accept(input);
        }
    }
}
