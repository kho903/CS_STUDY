package Chap14;

import Chap14.Calc;
import Chap14.CompleteCalc;

public class CalculatorTest {
    public static void main(String[] args) {

        int num1 = 10;
        int num2 = 2;
        CompleteCalc calc = new CompleteCalc();
        System.out.println(calc.add(num1, num2));
        System.out.println(calc.subtract(num1, num2));
        System.out.println(calc.times(num1, num2));
        System.out.println(calc.divide(num1, num2));

        calc.description();

        int[] arr = {1, 2, 3, 4, 5};
        // static 메서드는 인터페이스 이름으로 바로 호출 가능
        System.out.println(Calc.total(arr));
    }
}
