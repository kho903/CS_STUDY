package Chap15.Customer;

public interface Sell {
    void sell();
    default void order() {
        System.out.println("Sell order");
    }
}
