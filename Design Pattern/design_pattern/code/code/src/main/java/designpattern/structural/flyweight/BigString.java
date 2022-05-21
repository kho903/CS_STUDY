package designpattern.structural.flyweight;

public class BigString {
	// "큰 문자" 의 배열
	private BigChar[] bigChars;

	public BigString(String string) {
		bigChars = new BigChar[string.length()];
		BigCharFactory factory = BigCharFactory.getInstance();
		for (int i = 0; i < bigChars.length; i++) {
			bigChars[i] = factory.getBigChar(string.charAt(i));
		}
	}

	// 표시
	public void print() {
		for (BigChar bigChar : bigChars) {
			bigChar.print();
		}
	}
}
