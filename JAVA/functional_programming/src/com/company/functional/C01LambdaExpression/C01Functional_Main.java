package com.company.functional.C01LambdaExpression;

import com.company.functional.C01LambdaExpression.util.Adder;

import java.util.function.Function;

public class C01Functional_Main {

    public static void main(String[] args) {
        // User Functional Interface
        Function<Integer, Integer> myAdder = new Adder();
        Integer result = myAdder.apply(5);
        System.out.println(result);
    }
}
