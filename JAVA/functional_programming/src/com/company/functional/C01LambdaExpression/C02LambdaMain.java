package com.company.functional.C01LambdaExpression;

import java.util.function.Function;

public class C02LambdaMain {

    public static void main(String[] args) {
        // Lambda Expression - Anonymous Function
        Function<Integer, Integer> myAdder2 = (Integer x) -> {
            return x + 10;
        };
        Integer result2 = myAdder2.apply(5);
        System.out.println(result2);

        Function<Integer, Integer> myAdder3 = x -> x + 10;
        Integer result3 = myAdder2.apply(5);
        System.out.println(result3);

    }
}
