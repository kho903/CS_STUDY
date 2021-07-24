package Chap15;

public class Main {
    public static void main(String[] args) {

        Person personEdward = new Person("Edward", 20000);
        Taxi taxi1 = new Taxi("잘나간다 운수");

        personEdward.takeTaxi(10000);
        taxi1.take(10000);

        personEdward.personInfo();
        taxi1.showTaxiInfo();
    }
}
