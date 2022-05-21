package designpattern.structural.proxy;

public class Printer implements Printable {
	String name;

	public Printer() {
		heavyJob("Printer 인스턴스 생성중");
	}

	public Printer(String name) {
		this.name = name;
		heavyJob("Printer 인스턴스 생성중");
	}

	private void heavyJob(String message) {
		System.out.println(message);
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println(".");
		}
		System.out.println("complete");
	}

	@Override
	public void setPrinterName(String name) {
		System.out.println("real : setName()");
		this.name = name;
	}

	@Override
	public String getPrinterName() {
		System.out.println("real : getName() ");
		return name;
	}

	@Override
	public void print(String string) {
		System.out.println("=== " + name + " ===");
		System.out.println(string);
	}
}
