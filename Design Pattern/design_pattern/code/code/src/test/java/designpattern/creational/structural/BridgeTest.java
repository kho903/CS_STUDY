package designpattern.creational.structural;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import designpattern.structural.bridge.impl.ArrayImpl;
import designpattern.structural.bridge.impl.LinkedListImpl;
import designpattern.structural.bridge.list.Queue;
import designpattern.structural.bridge.list.Stack;

public class BridgeTest {

	@Test
	public void linkedList() throws Exception {
		Stack<String> linkedListStack = new Stack<>(new LinkedListImpl<String>());
		linkedListStack.push("aaa");
		linkedListStack.push("bbb");
		linkedListStack.push("ccc");

		System.out.println(linkedListStack.toString());

		assertEquals(linkedListStack.pop(), "ccc");
		assertEquals(linkedListStack.pop(), "bbb");
		assertEquals(linkedListStack.pop(), "aaa");
	}

	@Test
	public void array() throws Exception {
		Stack<String> arrayStack = new Stack<>(new ArrayImpl<String>());
		arrayStack.push("aaa");
		arrayStack.push("bbb");
		arrayStack.push("ccc");

		System.out.println(arrayStack.toString());

		assertEquals(arrayStack.pop(), "ccc");
		assertEquals(arrayStack.pop(), "bbb");
		assertEquals(arrayStack.pop(), "aaa");
	}

	@Test
	public void queue() throws Exception {
		Queue<String> arrayQueue = new Queue<>(new ArrayImpl<String>());
		arrayQueue.enQueue("aaa");
		arrayQueue.enQueue("bbb");
		arrayQueue.enQueue("ccc");

		System.out.println(arrayQueue.toString());

		assertEquals(arrayQueue.dequeue(), "aaa");
		assertEquals(arrayQueue.dequeue(), "bbb");
		assertEquals(arrayQueue.dequeue(), "ccc");

		Queue<String> linkedQueue = new Queue<>(new LinkedListImpl<>());
		linkedQueue.enQueue("aaa");
		linkedQueue.enQueue("bbb");
		linkedQueue.enQueue("ccc");

		System.out.println(linkedQueue.toString());

		assertEquals(linkedQueue.dequeue(), "aaa");
		assertEquals(linkedQueue.dequeue(), "bbb");
		assertEquals(linkedQueue.dequeue(), "ccc");
	}
}
