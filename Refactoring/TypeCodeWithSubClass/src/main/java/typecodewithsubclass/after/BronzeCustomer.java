package typecodewithsubclass.after;

public class BronzeCustomer extends Customer{
	public BronzeCustomer(String customerName) {
		super(customerName);
	}

	@Override
	public String getCustomerGrade() {
		return "BRONZE";
	}

	@Override
	public int calcPrice(int price) {
		return price;
	}

	@Override
	public int calcBonusPoint(int price) {
		return bonusPoint += (int)(price * 0.01);
	}
}
