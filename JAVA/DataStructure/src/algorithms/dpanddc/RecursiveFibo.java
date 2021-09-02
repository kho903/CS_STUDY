package algorithms.dpanddc;

public class RecursiveFibo {
    public static int fiboFunc(int data) {
        if (data <= 1) {
            return data;
        }
        return fiboFunc(data - 1) + fiboFunc(data - 2);
    }

    public static void main(String[] args) {
        System.out.println(fiboFunc(10));
    }
}
