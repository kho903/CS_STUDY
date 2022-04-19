package designpattern.creational.builder;

import static designpattern.creational.builder.Pizza.*;

import designpattern.creational.builder.NyPizza.Size;

public class PizzaMain {
	public static void main(String[] args) {
		Pizza pizza = new NyPizza.Builder(Size.SMALL).addTopping(Topping.SAUSAGE)
			.addTopping(Topping.ONION).build();

		Pizza calzone = new Calzone.Builder().addTopping(Topping.HAM).addTopping(Topping.PEPPER)
				.sauceInside().build();

		System.out.println(pizza);
		System.out.println(calzone);
	}
}
