package designpattern.structural.bridge.list;

import designpattern.structural.bridge.impl.AbstractList;

public class Queue<T> extends List<T> {
	public Queue(AbstractList<T> impl) {
		super(impl);
		System.out.println("Queue로 구현합니다.");
	}

	public void enQueue(T obj) {
		impl.addElement(obj);
	}

	public T dequeue() {
		return impl.deleteElement(0);
	}
}
