package Chap02;

public class VIPCustomer extends Customer {
    double salesRatio;
    private int agentID;

    public VIPCustomer() {
        bonusRatio = 0.05;
        salesRatio = 0.1;
        customerGrade = "VIP";
    }

    public int getAgentID() {
        return agentID;
    }
}
