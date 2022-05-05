package designpattern.structural.decorator.coffee;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class CoffeeMain {
	public static void main(String[] args) throws IOException {
		Coffee kenyaCoffee = new KenyaCoffee();
		kenyaCoffee.brewing();

		System.out.println();
		Coffee KenyaLatte = new Latte(kenyaCoffee);
		KenyaLatte.brewing();

		System.out.println();
		Coffee mochaKenya = new MochaCoffee(new Latte(new KenyaCoffee()));
		mochaKenya.brewing();

		System.out.println();
		Coffee ethiopiaCoffee = new MochaCoffee(new Latte(new EthiopiaCoffee()));
		ethiopiaCoffee.brewing();

		// 데코레이터 패턴 예
		Socket socket = new Socket();
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new InputStreamReader(new FileInputStream("a.txt")));
	}
}
