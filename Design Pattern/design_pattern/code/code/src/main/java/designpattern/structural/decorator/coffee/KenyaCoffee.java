package designpattern.structural.decorator.coffee;

public class KenyaCoffee extends Coffee {
	@Override
	public void brewing() {
		System.out.println("Kenya Americano");
	}
}
