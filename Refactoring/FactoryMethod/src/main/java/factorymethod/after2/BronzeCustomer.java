package factorymethod.after2;

public class BronzeCustomer extends Customer {
	private BronzeCustomer(String customerName) {
		super(customerName);
	}

	public static BronzeCustomer create(String customerName) {
		return new BronzeCustomer(customerName);
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
		return bonusPoint += (price * 0.01);
	}
}
