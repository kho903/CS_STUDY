package com.company.functional.C01LambdaExpression;

import com.company.functional.C01LambdaExpression.util.TriFunction;

public class C04TriFunctionMain {

    public static void main(String[] args) {
        TriFunction<Integer, Integer, Integer, Integer> addThreeNumbers =
                (x, y, z) -> x + y + z;

        Integer result = addThreeNumbers.apply(3, 2, 5);
        System.out.println(result);
    }
}
