package designpattern.structural.flyweight;

import java.util.HashMap;

public class BigCharFactory {
	private HashMap<String, BigChar> pool = new HashMap<>();
	private static BigCharFactory singleton = new BigCharFactory();

	private BigCharFactory() {
	}

	public static BigCharFactory getInstance() {
		return singleton;
	}

	public synchronized BigChar getBigChar(char charName) {
		BigChar bc = pool.get("" + charName);
		if (bc == null) {
			bc = new BigChar(charName);	// 여기에서 BidChar의 인스턴스를 생성
			pool.put("" + charName, bc);
		}
		return bc;
	}

}
