package designpattern.factory_method;

public class CarTest {

	public static void main(String[] args) {
		CarFactory factory = new HyundaiCarFactory();
		Car sonata = factory.createCar("sonata");
		System.out.println(sonata);

		Car car = factory.returnCar("Tomas");
		Car hisCar = factory.returnCar("Tomas");
		System.out.println(car == hisCar);
	}
}
