package Chap03;

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
        System.out.println("VIPCustomer(int, String) call");
    }

    public int getAgentID() {
        return agentID;
    }
}
