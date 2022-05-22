package magicnumber.after;

public class Robot {

	public static final int COMMAND_WALK = 0;
	public static final int COMMAND_STOP = 1;
	public static final int COMMAND_JUMP = 2;

	public static final int ZERO = 0;

	public enum COMMAND {
		WALK,
		STOP,
		JUMP
	}

	public String name;

	public Robot(String name) {
		this.name = name;
	}

	public void order(
		// int command
		COMMAND command
	) {

		// if (command == COMMAND_WALK) { // 걷기
		// 	System.out.println(name + " walk");
		// } else if (command == COMMAND_STOP) { // 멈추기
		// 	System.out.println(name + " stop");
		// } else if (command == COMMAND_JUMP) { // 점프
		// 	System.out.println(name + " jump");
		// } else {
		// 	System.out.println("error");
		// }

		if (command == COMMAND.WALK) {
			System.out.println(name + " walk");
		} else if (command == COMMAND.STOP) {
			System.out.println(name + " stop");
		} else if (command == COMMAND.JUMP) {
			System.out.println(name + " jump");
		} else {
			System.out.println("error");
		}
	}
}
