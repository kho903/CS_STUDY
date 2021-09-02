package algorithms.dpanddc;

public class DPFibo {
    public static int dynamicFunc(int data) {
        Integer[] cache = new Integer[data + 1];
        cache[0] = 0;
        cache[1] = 1;
        for (int i = 2; i < data + 1; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[data];
    }

    public static void main(String[] args) {
        System.out.println(dynamicFunc(10));
    }
}
