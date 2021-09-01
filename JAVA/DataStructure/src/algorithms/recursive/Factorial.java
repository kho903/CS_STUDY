package algorithms.recursive;

public class Factorial {
    /*public static int factorial(int num) {
        if (num > 1)
            return num * factorial(num - 1);
        else
            return 1;
    }*/

    public static int factorial(int num) {
        if (num < 1)
            return 1;
        return num * factorial(num - 1);
    }


    public static void main(String[] args) {
        System.out.println(factorial(2));
        System.out.println(factorial(3));
        System.out.println(factorial(4));
        System.out.println(factorial(5));
        System.out.println(factorial(6));
    }
}
