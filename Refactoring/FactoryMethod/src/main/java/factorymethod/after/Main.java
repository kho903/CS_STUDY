package factorymethod.after;

public class Main {

	public static void main(String[] args) {
		Customer bronzeCustomer = Customer.create(Customer.BRONZE_CUSTOMER, "KIM");
		Customer silverCustomer = Customer.create(Customer.SILVER_CUSTOMER, "LEE");
		Customer goldCustomer = Customer.create(Customer.GOLD_CUSTOMER, "PARK");

		int price = 10000;

		System.out.println(bronzeCustomer);
		System.out.println(bronzeCustomer.getCustomerName() + " : price : "
			+ bronzeCustomer.calcPrice(price) + " bonusPoint: " + bronzeCustomer.calcBonusPoint(price));

		System.out.println(silverCustomer);
		System.out.println(silverCustomer.getCustomerName() + " : price : "
			+ silverCustomer.calcPrice(price) + " bonusPoint: " + silverCustomer.calcBonusPoint(price));

		System.out.println(goldCustomer);
		System.out.println(goldCustomer.getCustomerName() + " : price : "
			+ goldCustomer.calcPrice(price) + " bonusPoint: " + goldCustomer.calcBonusPoint(price));

	}
}
