package designpattern.structural.adapter;

// 상속
// public class PrintBanner extends Banner implements Printer {
//
// 	public PrintBanner(String string) {
// 		super(string);
// 	}
//
// 	@Override
// 	public void printWeek() {
// 		showWithParen();
// 	}
//
// 	@Override
// 	public void printStrong() {
// 		showWithAster();
// 	}
// }

// 확장
public class PrintBanner implements Print {

	private Banner banner;

	public PrintBanner(String string) {
		banner = new Banner(string);
	}

	@Override
	public void printWeak() {
		banner.showWithParen();
	}

	@Override
	public void printStrong() {
		banner.showWithAster();
	}
}