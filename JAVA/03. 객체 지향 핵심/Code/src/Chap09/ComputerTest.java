package Chap09;

public class ComputerTest {
    public static void main(String[] args) {
        Computer desktop = new Desktop(); // Desktop 클래스에서 추가 구현한 메소드 사용불가
//        Computer computer = new Computer(); // X
        desktop.display();
    }
}
