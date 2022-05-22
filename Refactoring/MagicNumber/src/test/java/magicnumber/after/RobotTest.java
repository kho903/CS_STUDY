package magicnumber.after;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RobotTest {

	@Test
	void order() {

		Robot robot = new Robot("James");

		/*robot.order(Robot.COMMAND_WALK);
		robot.order(Robot.COMMAND_STOP);
		robot.order(Robot.COMMAND_JUMP);
		robot.order(100);*/


		robot.order(Robot.COMMAND.WALK);
		robot.order(Robot.COMMAND.STOP);
		robot.order(Robot.COMMAND.JUMP);
		// robot.order(100);
	}
}