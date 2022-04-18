package designpattern.creational.singleton;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConnectionPoolTest {

	@Test
	public void singleton_pattern() throws Exception {
		ConnectionPool instance1 = ConnectionPool.getInstance();
		ConnectionPool instance2 = ConnectionPool.getInstance();

		assertTrue(instance1 == instance2);

		Calendar calendar = Calendar.getInstance();
	}

}