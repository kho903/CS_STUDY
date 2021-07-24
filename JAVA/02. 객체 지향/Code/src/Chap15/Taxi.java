package Chap15;

public class Taxi {
    String company;
    int money;

    public Taxi(String company) {
        this.company = company;
    }

    public void take(int money) {
        this.money += money;
    }

    public void showTaxiInfo() {
        System.out.println(this.company + " 수입은 " + this.money + "입니다.");
    }
}
