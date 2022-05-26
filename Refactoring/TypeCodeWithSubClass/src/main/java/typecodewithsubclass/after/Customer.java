package typecodewithsubclass.after;

public abstract class Customer {
	protected int customerType;
	protected String customerName;
	protected String customerGrade;
	protected int bonusPoint;

	public Customer(String customerName) {
		this.customerName = customerName;
	}

	public abstract String getCustomerGrade();
	public abstract int calcPrice(int price);
	public abstract int calcBonusPoint(int price);

	public String getCustomerName() {
		return customerName;
	}

	@Override
	public String toString() {
		return customerName + "님의 멤버십 등급은 " + getCustomerGrade() + "입니다.";
	}
}
