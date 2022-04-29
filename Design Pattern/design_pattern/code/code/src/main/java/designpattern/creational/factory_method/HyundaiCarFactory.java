package designpattern.creational.factory_method;

import java.util.HashMap;

public class HyundaiCarFactory extends CarFactory {

	HashMap<String, Car> carMap = new HashMap<>();

	@Override
	public Car createCar(String name) {
		Car car = null;

		if (name.equals("sonata")) {
			car = new Sonata();
		} else if (name.equals("santafe")) {
			car = new Santafe();
		}

		return car;
	}

	public Car returnCar(String name) {
		Car car = carMap.get(name);
		if (car == null) {
			if (name.equals("Tomas")) {
				car = new Santafe();
			} else if (name.equals("James")) {
				car = new Sonata();
			}
			carMap.put(name, car);
		}
		return car;
	}

}
