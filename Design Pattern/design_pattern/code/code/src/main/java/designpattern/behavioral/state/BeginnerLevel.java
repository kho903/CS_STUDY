package designpattern.behavioral.state;

public class BeginnerLevel extends PlayerLevel {
	@Override
	public void run() {
		System.out.println("천천히 달립니다.");
	}

	@Override
	public void jump() {
		System.out.println("점프를 할 수 없습니다.");
	}

	@Override
	public void turn() {
		System.out.println("턴을 할 수 없습니다.");
	}

	@Override
	public void showLevelMessage() {
		System.out.println("****** 초보자 레벨입니다. ******");
	}
}
