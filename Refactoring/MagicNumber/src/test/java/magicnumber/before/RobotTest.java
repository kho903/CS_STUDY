package magicnumber.before;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RobotTest {

	@Test
	void order() {
		Robot robot = new Robot("James");

		robot.order(0);
		robot.order(1);
		robot.order(2);
		robot.order(100);
	}

}