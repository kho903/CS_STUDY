package designpattern.structural.proxy;

public interface Printable {
	public void setPrinterName(String name);	// 이름의 설정
	public String getPrinterName();			// 이름의 취득
	public void print(String string);			// 문자열 표시 (프린트아웃)
}
