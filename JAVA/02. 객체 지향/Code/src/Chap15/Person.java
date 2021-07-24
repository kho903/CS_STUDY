package Chap15;

public class Person {
    String name;
    int money;

    public Person(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public void takeTaxi(int money) {
        this.money -= money;
    }

    public void personInfo() {
        System.out.println(this.name + "님의 남은 돈은 " + this.money + "원 입니다.");
    }
}
