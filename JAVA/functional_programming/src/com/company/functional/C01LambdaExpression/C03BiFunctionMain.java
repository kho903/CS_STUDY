package com.company.functional.C01LambdaExpression;

import java.util.function.BiFunction;

public class C03BiFunctionMain {

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> add = (Integer x, Integer y) -> {
            return x + y;
        };
        int result = add.apply(3, 5);
        System.out.println(result);

        BiFunction<Integer, Integer, Integer> add2 = (x, y) -> x + y;
        int result2 = add2.apply(3, 5);
        System.out.println(result2);
    }
}
