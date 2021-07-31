package Chap06;

public class VIPCustomer extends Customer {
    double salesRatio;
    private int agentID;

//    public VIPCustomer() {
//        // super(); // 컴파일러가 자동으로 넣어줌
//        super(0, "no-name");
//        bonusRatio = 0.05;
//        salesRatio = 0.1;
//        customerGrade = "VIP";
//
//        System.out.println("VIPCustomer() call");
//    }

    public VIPCustomer(int customerID, String customerName) {
        super(customerID, customerName);
        customerGrade = "VIP";
        bonusRatio = 0.05;
        salesRatio = 0.1;
    }

    @Override
    public int calcPrice(int price) {
        bonusPoint += price * bonusRatio;
        price -= (int)(price * salesRatio);
        return super.calcPrice(price);
    }

    public int getAgentID() {
        return agentID;
    }
}
